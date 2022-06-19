package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiUser {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String name;
    private LocalDateTime createdAtTime;

    @Enumerated(EnumType.STRING)
    private Role role;
}
