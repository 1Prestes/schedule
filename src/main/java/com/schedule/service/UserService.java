package com.schedule.service;

import com.schedule.domain.User;
import com.schedule.mapper.UserMapper;
import com.schedule.repository.UserRepository;
import com.schedule.requests.UserPostRequestBody;
import com.schedule.requests.UserPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found.")
                );
    }

    public User save(UserPostRequestBody user) {
        User userToSave = UserMapper.INSTANCE.toUser(user);
        userToSave.setId(UUID.randomUUID());
        System.out.println("Só teste " + UserMapper.INSTANCE.toUser(user));
        return userRepository.save(userToSave);
    }

    public void delete(UUID id) {
        userRepository.delete(findById(id));
    }

    public void replace(UserPutRequestBody user) {
        User savedUser = findById((UUID) user.getId());
        User userToSave = UserMapper.INSTANCE.toUser(user);

        userToSave.setId(savedUser.getId());

        userRepository.save(userToSave);
    }
}
