package com.TedrosGhebru.mapper;

import com.TedrosGhebru.dto.UserDto;
import com.TedrosGhebru.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper instance= Mappers.getMapper(UserMapper.class);

    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);
}
