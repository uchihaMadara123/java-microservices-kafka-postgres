package com.authservice.controller;

import com.authservice.DTO.ResponseDTO;
import com.authservice.DTO.UserDto;
import com.authservice.records.UserRequest;
import com.authservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody UserRequest request) {
        return  userService.createUser(request);
    }
}
