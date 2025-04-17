package com.company.NeuroCity.Auth_Service.controller;


import com.company.NeuroCity.Auth_Service.dtos.AuthRequestDto;
import com.company.NeuroCity.Auth_Service.dtos.UserDto;
import com.company.NeuroCity.Auth_Service.exceptions.BadRequestException;
import com.company.NeuroCity.Auth_Service.service.AuthService;
import com.company.NeuroCity.Auth_Service.service.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController{

    private final AuthService authService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody AuthRequestDto authRequestDto) {
        try {
            UserDto userDto = authService.signUp(authRequestDto);
            return new ResponseEntity<>(userDto, HttpStatus.CREATED);
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Signup failed: " + e.getMessage());
        }
    }
}
