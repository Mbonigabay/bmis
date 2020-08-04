package com.muhoza.mis.Controller;

import com.muhoza.mis.Config.SecurityConfiguration;
import com.muhoza.mis.Model.Project;
import com.muhoza.mis.Model.User;
import com.muhoza.mis.Service.ProjectService;
import com.muhoza.mis.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;
    
    @Autowired
    SecurityConfiguration security;
    
    @PostMapping("")
    public String create(@ModelAttribute("user") User user, @RequestParam Integer projectId){
        Project project = projectService.findById(projectId);
        user.setActive(true);
        user.setProject(project);
        user.setRoles("ROLE_USER");
        user.setPassword(security.getPasswordEncoder().encode(user.getPassword()));
        userService.createUser(user);
        return "redirect:/admin/user";
    }
}