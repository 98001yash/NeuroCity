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

    public Optional<CitizenDto> getByAuthUserId(Long authUserId){
        return citizenRepository.findByAuthUserId(authUserId)
                .map(citizen->modelMapper.map(citizen, CitizenDto.class));
    }


    public Optional<CitizenDto> updateCitizen(Long id, CitizenDto dto) {
        return citizenRepository.findById(id).map(existing -> {
            existing.setFullName(dto.getFullName());
            existing.setEmail(dto.getEmail());
            existing.setPhoneNumber(dto.getPhoneNumber());
            existing.setAddress(dto.getAddress());
            existing.setCity(dto.getCity());
            existing.setState(dto.getState());
            existing.setPinCode(dto.getPinCode());
            existing.setCountry(dto.getCountry());
            existing.setLatitude(dto.getLatitude());
            existing.setLongitude(dto.getLongitude());
            existing.setRole(dto.getRole());
            Citizen updated = citizenRepository.save(existing);
            return modelMapper.map(updated, CitizenDto.class);
        });
    }

    public boolean deactivateCitizen(Long id){
        return citizenRepository.findById(id).map(citizen->{
            citizen.setActive(false);
            citizenRepository.save(citizen);
            return true;
        }).orElse(false);
    }
}
