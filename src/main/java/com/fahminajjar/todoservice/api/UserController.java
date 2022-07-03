package com.fahminajjar.todoservice.api;

import com.fahminajjar.todoservice.dto.UserDto;
import com.fahminajjar.todoservice.dto.UserLoginDto;
import com.fahminajjar.todoservice.dto.UserRegistrationDto;
import com.fahminajjar.todoservice.mapper.UserMapper;
import com.fahminajjar.todoservice.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(name = "api/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    @PostMapping
    public UserDto register(@Valid @RequestBody UserRegistrationDto userRegistrationDto) {
        // TODO: Check if given username already exists!

        var user = userService.register(userRegistrationDto.getUsername(),
                userRegistrationDto.getPassword());

        return userMapper.userToUserDto(user);
    }

//    @PostMapping("login")
//    public User login(@Valid @RequestBody UserLoginDto userLoginDto) {
//        try {
//            var auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                    userLoginDto.getUsername(), userLoginDto.getPassword()));
//
//            User user = (User) auth.getPrincipal();
//            return user;
//        } catch (BadCredentialsException e) {
//
//        }
//    }

}
