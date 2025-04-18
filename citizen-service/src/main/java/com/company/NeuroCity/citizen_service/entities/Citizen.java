package com.company.NeuroCity.citizen_service.entities;


import com.company.NeuroCity.citizen_service.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "citizens")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long authUserId;
    private String fullName;

    private String email;

    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String country;
    private Double latitude;
    private Double longitude;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean active = true;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
