package com.company.NeuroCity.alert_service.service;

import com.company.NeuroCity.alert_service.dtos.AlertRequest;
import com.company.NeuroCity.alert_service.dtos.AlertResponse;

import java.util.List;
import java.util.Optional;

public interface AlertService {

    AlertResponse createAlert(AlertRequest request);
    Optional<AlertResponse> getAlertById(Long id);

    List<AlertResponse> getAlertByType(String type);
}
