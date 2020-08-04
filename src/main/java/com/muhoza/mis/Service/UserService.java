package com.muhoza.mis.Service;

import java.util.List;

import com.muhoza.mis.Model.User;

import org.springframework.stereotype.Service;

public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
}