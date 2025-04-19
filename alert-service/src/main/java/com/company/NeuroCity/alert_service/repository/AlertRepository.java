package com.company.NeuroCity.alert_service.repository;

import com.company.NeuroCity.alert_service.entities.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertRepository extends JpaRepository<Alert,Long> {
    List<Alert> findByType(String type);
}
