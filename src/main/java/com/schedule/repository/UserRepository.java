package com.schedule.schedule.repository;

import com.scheduleapi.domain.User;

import java.util.List;

public interface UserRepository {
    List<User> listAll();
}
