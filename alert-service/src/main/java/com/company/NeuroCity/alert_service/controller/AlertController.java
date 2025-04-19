package com.company.NeuroCity.alert_service.controller;


import com.company.NeuroCity.alert_service.advices.ApiError;
import com.company.NeuroCity.alert_service.advices.ApiResponse;
import com.company.NeuroCity.alert_service.dtos.AlertRequest;
import com.company.NeuroCity.alert_service.dtos.AlertResponse;
import com.company.NeuroCity.alert_service.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    @PostMapping
    public ResponseEntity<AlertResponse> createAlert(@RequestBody AlertRequest request){
        return ResponseEntity.ok(alertService.createAlert(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AlertResponse>> getAlertById(@PathVariable Long id) {
        return alertService.getAlertById(id)
                .map(alertDto -> ResponseEntity.ok(new ApiResponse<>(alertDto)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(
                                ApiError.builder()
                                        .status(HttpStatus.NOT_FOUND)
                                        .message("Alert with id " + id + " not found")
                                        .build()
                        )));
    }



    @GetMapping("/type/{type}")
    public ResponseEntity<List<AlertResponse>> getByType(@PathVariable String type) {
        return ResponseEntity.ok(alertService.getAlertByType(type));
    }

}
