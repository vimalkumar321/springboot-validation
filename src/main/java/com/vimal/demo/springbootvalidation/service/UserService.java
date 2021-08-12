package com.vimal.demo.springbootvalidation.service;

import com.vimal.demo.springbootvalidation.model.User;
import com.vimal.demo.springbootvalidation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getById(int id){
        if(userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        else
            return null;
    }
    public List<User> getAllUsers(){
        return (List<User>)userRepository.findAll();
    }
}
