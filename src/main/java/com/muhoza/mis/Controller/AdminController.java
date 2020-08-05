package com.muhoza.mis.Controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.muhoza.mis.Model.Project;
import com.muhoza.mis.Model.User;
import com.muhoza.mis.Service.ProjectService;
import com.muhoza.mis.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @RequestMapping("")
    public String index(HttpSession session) {
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

    @RequestMapping("/project")
    public String getProjectPage(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "admin/project";
    }

    @RequestMapping(value="/beneficiary", method=RequestMethod.GET)
    public String getBeneficiaryPage() {
        return "admin/beneficiary";
    }
    
}