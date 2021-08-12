package com.vimal.demo.springbootvalidation.controller;

import com.vimal.demo.springbootvalidation.dto.UserDto;
import com.vimal.demo.springbootvalidation.model.User;
import com.vimal.demo.springbootvalidation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto dto){
        //convert UserDto to User entity
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setDob(dto.getDob());
        user.setSalary(dto.getSalary());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        User savedUser = userService.createUser(user);

        //convert User entity to UserDto class
        UserDto userResponse =new UserDto();
        userResponse.setId(savedUser.getId());
        userResponse.setName(savedUser.getName());
        userResponse.setDob(savedUser.getDob());
        userResponse.setSalary(savedUser.getSalary());
        userResponse.setEmail(savedUser.getEmail());
        //don't provide password to client
        //userResponse.setPassword(savedUser.getPassword());
        return new ResponseEntity<>(userResponse,HttpStatus.CREATED);
    }
    @GetMapping("get/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getById(id);
    }
    @GetMapping("get/all")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }
}
