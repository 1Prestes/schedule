package com.scheduleapi.repository;

import com.scheduleapi.domain.User;

import java.util.List;

public interface UserRepository {
    List<User> listAll();
}
