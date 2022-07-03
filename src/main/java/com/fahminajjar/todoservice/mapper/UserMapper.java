package com.fahminajjar.todoservice.mapper;

import com.fahminajjar.todoservice.dto.UserDto;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);
}
