package com.scheduleapi.domain;

import java.time.LocalDate;

public class User {
    private String name;
    private String address;
    private String username;
    private String password;
    private LocalDate birthDate;

    public User(String name, String address, String username, LocalDate birthDate, String password) {
        this.name = name;
        this.birthDate = birthDate;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
