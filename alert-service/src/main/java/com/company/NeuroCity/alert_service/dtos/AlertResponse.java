package com.company.NeuroCity.alert_service.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertResponse {

    private Long id;
    private String type;
    private String title;
    private String description;
    private String location;
    private LocalDateTime createdAt;
    private Boolean acknowledged;
}
