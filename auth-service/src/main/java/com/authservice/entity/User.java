package com.authservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users",schema = "auth_db_schema")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role",nullable = false)
    private String role;

    @Column(name = "enabled" ,nullable = false)
    private boolean enabled = true;
}
