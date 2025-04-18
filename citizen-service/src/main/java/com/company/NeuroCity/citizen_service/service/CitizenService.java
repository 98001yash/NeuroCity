package com.company.NeuroCity.citizen_service.service;


import com.company.NeuroCity.citizen_service.dtos.CitizenDto;
import com.company.NeuroCity.citizen_service.entities.Citizen;
import com.company.NeuroCity.citizen_service.repository.CitizenRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CitizenService {

    private final CitizenRepository citizenRepository;
    private final ModelMapper modelMapper;


    public CitizenDto createCitizen(CitizenDto dto){
        Citizen citizen = modelMapper.map(dto, Citizen.class);
        citizen.setActive(true);
        Citizen saved = citizenRepository.save(citizen);
        return modelMapper.map(saved, CitizenDto.class);
    }

    public Optional<CitizenDto> getById(Long id){
        return citizenRepository.findById(id)
                .map(citizen->modelMapper.map(citizen, CitizenDto.class));
    }
}
