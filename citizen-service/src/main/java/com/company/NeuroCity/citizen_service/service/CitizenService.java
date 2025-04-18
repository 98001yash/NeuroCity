package com.company.NeuroCity.citizen_service.service;


import com.company.NeuroCity.citizen_service.dtos.CitizenDto;
import com.company.NeuroCity.citizen_service.entities.Citizen;
import com.company.NeuroCity.citizen_service.repository.CitizenRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
