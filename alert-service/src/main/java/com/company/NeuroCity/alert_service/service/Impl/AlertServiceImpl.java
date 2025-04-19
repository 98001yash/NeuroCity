package com.company.NeuroCity.alert_service.service.Impl;


import com.company.NeuroCity.alert_service.dtos.AlertRequest;
import com.company.NeuroCity.alert_service.dtos.AlertResponse;
import com.company.NeuroCity.alert_service.entities.Alert;
import com.company.NeuroCity.alert_service.repository.AlertRepository;
import com.company.NeuroCity.alert_service.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private  final AlertRepository alertRepository;
    private final ModelMapper modelMapper;


    @Override
    public AlertResponse createAlert(AlertRequest request) {
        Alert alert = Alert.builder()
                .type(request.getType())
                .title(request.getTitle())
                .description(request.getDescription())
                .location(request.getLocation())
                .createdAt(LocalDateTime.now())
                .acknowledged(false)
                .build();
        alert = alertRepository.save(alert);
        return modelMapper.map(alert, AlertResponse.class);
    }


    @Override
    public Optional<AlertResponse> getAlertById(Long id) {
        return alertRepository.findById(id)
                .map(alert -> modelMapper.map(alert, AlertResponse.class));
    }


    @Override
    public List<AlertResponse> getAlertByType(String type) {
        return alertRepository.findByType(type).stream()
                .map(alert -> modelMapper.map(alert, AlertResponse.class))
                .collect(Collectors.toList());
    }
}
