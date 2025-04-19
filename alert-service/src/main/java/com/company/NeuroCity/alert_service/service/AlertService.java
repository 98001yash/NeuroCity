package com.company.NeuroCity.alert_service.service;

import com.company.NeuroCity.alert_service.dtos.AlertRequest;
import com.company.NeuroCity.alert_service.dtos.AlertResponse;

import java.util.List;

public interface AlertService {

    AlertResponse createAlert(AlertRequest request);
    List<AlertResponse> getAlertById();
    List<AlertResponse> getAlertByType(String type);
}
