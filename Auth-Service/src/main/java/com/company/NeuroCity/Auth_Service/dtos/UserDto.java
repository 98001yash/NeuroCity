package com.company.NeuroCity.Auth_Service.dtos;

import com.company.NeuroCity.Auth_Service.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private Role role = Role.INDIVIDUAL; // Default to USER
}
