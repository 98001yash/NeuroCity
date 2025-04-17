package com.company.NeuroCity.Auth_Service.dtos;



import com.company.NeuroCity.Auth_Service.enums.Role;
import lombok.Data;

@Data
public class AuthRequestDto {
    private String name;
    private String email;
    private String password;
    private Role role;
    private String adminCode;
}
