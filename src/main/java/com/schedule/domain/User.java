package com.schedule.schedule.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class User {
    private UUID iduser;
    private String name;
    private String address;
    private String username;
    private String password;
    private LocalDate birthDate;
}
