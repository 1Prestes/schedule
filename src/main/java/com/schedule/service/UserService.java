package com.schedule.service;

import com.schedule.domain.User;
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
        System.out.println("teste " + id);
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found.")
                );
    }

    public User save(UserPostRequestBody user) {
        return userRepository.save(
                User.builder()
                        .id(UUID.randomUUID())
                        .name(user.getName())
                        .address(user.getAddress())
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .birthDate(user.getBirthDate())
                        .build()
        );
    }

    public void delete(UUID id) {
        userRepository.delete(findById(id));
    }

    public void replace(UserPutRequestBody user) {
        User savedUser = findById((UUID) user.getId());
        User userToSave = User.builder()
                .id(savedUser.getId())
                .name(user.getName())
                .address(user.getAddress())
                .username(user.getUsername())
                .password(user.getPassword())
                .birthDate(user.getBirthDate())
                .build();

        userRepository.save(userToSave);
    }
}
