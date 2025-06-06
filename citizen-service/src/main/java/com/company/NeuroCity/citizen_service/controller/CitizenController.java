package com.company.NeuroCity.citizen_service.controller;


import com.company.NeuroCity.citizen_service.dtos.CitizenDto;
import com.company.NeuroCity.citizen_service.service.CitizenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
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

    @GetMapping("/auth-user/{authUserId}")
    public ResponseEntity<List<CitizenDto>> getAllByAuthUserId(@PathVariable Long authUserId) {
        List<CitizenDto> citizens = citizenService.getByAuthUserId(authUserId);
        if (citizens.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(citizens);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CitizenDto> updateCitizen(@PathVariable Long id, @RequestBody CitizenDto dto){
        return citizenService.updateCitizen(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateCitizen(@PathVariable Long id){
        boolean result = citizenService.deactivateCitizen(id);
        return result ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
