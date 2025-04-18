package com.company.NeuroCity.citizen_service.controller;


import com.company.NeuroCity.citizen_service.dtos.CitizenDto;
import com.company.NeuroCity.citizen_service.service.CitizenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/citizens")
@RequiredArgsConstructor
public class CitizenController {

    private final CitizenService citizenService;

    @PostMapping
    public ResponseEntity<CitizenDto> register(@RequestBody CitizenDto dto){
        return ResponseEntity.ok(citizenService.createCitizen(dto));
    }


    @GetMapping("/{id}")
    public ResponseEntity<CitizenDto> getById(@PathVariable Long id){
        return citizenService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
