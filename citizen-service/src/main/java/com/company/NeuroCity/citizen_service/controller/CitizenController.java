package com.company.NeuroCity.citizen_service.controller;


import com.company.NeuroCity.citizen_service.dtos.CitizenDto;
import com.company.NeuroCity.citizen_service.service.CitizenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citizens")
@RequiredArgsConstructor
public class CitizenController {

    private final CitizenService citizenService;

    @PostMapping
    public ResponseEntity<CitizenDto> register(@RequestBody CitizenDto dto){
        return ResponseEntity.ok(citizenService.createCitizen(dto));
    }
}
