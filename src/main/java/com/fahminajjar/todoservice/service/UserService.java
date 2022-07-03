package com.fahminajjar.todoservice.service;

import com.fahminajjar.todoservice.exception.LoginCredentialsException;
import com.fahminajjar.todoservice.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User register(String username, String password) {
        var user = new User(username, password, Collections.emptyList());
        return userRepository.save(user);
    }

    public User login(String username, String password) throws LoginCredentialsException {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new LoginCredentialsException("Username or password is invalid"));
    }

}
