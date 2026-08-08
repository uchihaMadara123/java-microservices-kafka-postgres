package com.authservice.records;

public record UserRequest(String username,
        String password,
        String role) {
}
