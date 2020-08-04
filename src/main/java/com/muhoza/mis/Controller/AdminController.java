package com.muhoza.mis.Controller;

import java.security.Principal;
import java.util.List;

import com.muhoza.mis.Model.Project;
import com.muhoza.mis.Model.User;
import com.muhoza.mis.Service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    ProjectService projectService;

    @RequestMapping("")
    public String index(Principal principal) {
        return "admin/index";
    }

    @RequestMapping("/user")
    public String getUserPage(Model model) {
        List<Project> projects = projectService.getAllProjects();
        User user = new User();
        model.addAttribute("projects", projects);
        model.addAttribute("user", user);
        return "admin/user";
    }
}