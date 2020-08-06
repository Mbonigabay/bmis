package com.muhoza.mis.Service.Impl;

import java.util.List;

import com.muhoza.mis.Model.User;
import com.muhoza.mis.Repository.UserRepository;
import com.muhoza.mis.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserService implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }
    
}