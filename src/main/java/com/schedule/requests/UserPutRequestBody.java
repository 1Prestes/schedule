package com.schedule.requests;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class UserPutRequestBody {
    private UUID id;
    private String name;
    private String address;
    private String username;
    private String password;
    private LocalDate birthDate;
}
