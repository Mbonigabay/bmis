package com.muhoza.mis.Service.Impl;

import java.security.Principal;

import com.muhoza.mis.Model.User;
import com.muhoza.mis.Service.AuthService;
import com.muhoza.mis.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IAuthService implements AuthService {

    @Autowired
    UserService userService;

    @Override
    public User getAuthUser(Principal principal) {
        String username = principal.getName();
        return userService.getUserByUsername(username);
    }
    
}