package com.company.NeuroCity.citizen_service.repository;

import com.company.NeuroCity.citizen_service.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CitizenRepository extends JpaRepository<Citizen,Long> {

    List<Citizen> findByAuthUserId(Long authUserId);

    Optional<Citizen> findByEmail(String email);
}
