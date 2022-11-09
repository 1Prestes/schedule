package com.schedule.schedule.service;

import com.schedule.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private static List<User> users;
    static {
        users = new ArrayList<>(List.of(new User(
                        UUID.fromString("e4e9413e-7783-46c1-8293-9b56f6ba69f0"),
                        "El Kuririn",
                        "Rua dos bobos",
                        "kuririn",
                        "show",
                        LocalDate.now()
                ),
                new User(
                        UUID.fromString("5d98a9ba-3b1b-4a9a-8519-f6e156f0c334"),
                        "El Goku",
                        "Rua dos marajas",
                        "goku",
                        "dbz",
                        LocalDate.now()
                )
        ));
    }
    public List<User> listAll() {
        return users;
    }

    public User findById(UUID id) {
        return users.stream()
                .filter(user -> user.getIduser().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found."));
    }

    public User save(User user) {
        user.setIduser(UUID.randomUUID());
        users.add(user);

        return user;
    }

    public void delete(UUID id) {
        users.remove(findById(id));
    }

    public void replace(User user) {
        delete(user.getIduser());
        users.add(user);
    }
}