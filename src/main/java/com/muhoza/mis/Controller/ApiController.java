package com.muhoza.mis.Controller;

import java.util.List;

import com.muhoza.mis.Model.User;
import com.muhoza.mis.Repository.UserRepository;
import com.muhoza.mis.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    UserService userService;
    
    @RequestMapping(value="/users")
    public @ResponseBody List<User> getUsers() {	
        return userService.getAllUsers();
    }
    
}