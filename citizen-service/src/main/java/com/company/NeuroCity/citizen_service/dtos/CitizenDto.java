package com.company.NeuroCity.citizen_service.dtos;


import com.company.NeuroCity.citizen_service.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CitizenDto {

    private Long id;
    private String authUserId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private Double latitude;
    private Double longitude;
    private Role role;
    private Boolean active;
}
