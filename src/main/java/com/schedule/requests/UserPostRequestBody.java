package com.schedule.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserPostRequestBody {
    private String name;
    private String address;
    private String username;
    private String password;
    private LocalDate birthDate;
}
