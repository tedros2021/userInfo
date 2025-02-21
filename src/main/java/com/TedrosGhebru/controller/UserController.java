package com.TedrosGhebru.controller;

import com.TedrosGhebru.dto.UserDto;
import com.TedrosGhebru.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers(){
        List<UserDto> userDtos= userService.fetchAllUsers();

        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserDto> saveRestaurant(@RequestBody UserDto userDto) {

        return new ResponseEntity<>(userService.addUser(userDto),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable("id") Integer id) {
        return userService.fetchUserById(id);

    }
}
