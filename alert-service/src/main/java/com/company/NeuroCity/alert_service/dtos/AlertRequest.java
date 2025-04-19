package com.company.NeuroCity.alert_service.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertRequest {

    private String type;
    private String title;
    private String description;
    private String location;
}
