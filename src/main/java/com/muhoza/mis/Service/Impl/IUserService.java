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
    
}