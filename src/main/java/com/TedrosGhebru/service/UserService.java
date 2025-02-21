package com.TedrosGhebru.service;

import com.TedrosGhebru.dto.UserDto;
import com.TedrosGhebru.entity.User;
import com.TedrosGhebru.mapper.UserMapper;
import com.TedrosGhebru.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<UserDto> fetchAllUsers() {
         List<User>   users       =userRepo.findAll();
      List<UserDto> userDtos = users.stream().map(user -> UserMapper.instance.userToUserDto(user)).collect(Collectors.toList());

      return userDtos;
    }


    public UserDto addUser(UserDto userDto) {
       User user = UserMapper.instance.userDtoToUser(userDto);
      User userFromDb= userRepo.save(user);
      return UserMapper.instance.userToUserDto(userFromDb);
    }


    public ResponseEntity<UserDto> fetchUserById(Integer id) {
        Optional<User> user=userRepo.findById(id);
        if(user.isPresent()) {
            return new ResponseEntity(UserMapper.instance.userToUserDto(user.get()),HttpStatus.OK);
        }
        return new ResponseEntity(null,HttpStatus.NOT_FOUND);
    }
}
