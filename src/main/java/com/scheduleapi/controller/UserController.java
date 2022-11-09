package com.scheduleapi.controller;

import com.scheduleapi.domain.User;
import com.scheduleapi.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("users")
@Log4j2
@RequiredArgsConstructor
public class UserController {

    private final DateUtil dateUtil;

    @GetMapping(path = "list")
    public List<User> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new User(
                "El Kuririn",
                "Rua dos bobos",
                "kuririn",
                LocalDate.now(),
                "show")
        );
    }
}
