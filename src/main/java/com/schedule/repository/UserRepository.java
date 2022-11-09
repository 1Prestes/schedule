package com.schedule.repository;

import com.schedule.domain.User;

import java.util.List;

public interface UserRepository {
    List<User> listAll();
}
