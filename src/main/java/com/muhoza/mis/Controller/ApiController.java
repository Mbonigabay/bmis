package com.muhoza.mis.Controller;

import java.security.Principal;
import java.util.List;

import com.muhoza.mis.Model.Beneficiary;
import com.muhoza.mis.Model.InfoFile;
import com.muhoza.mis.Model.Project;
import com.muhoza.mis.Model.User;
import com.muhoza.mis.Service.AuthService;
import com.muhoza.mis.Service.BeneficiaryService;
import com.muhoza.mis.Service.InfoFileService;
import com.muhoza.mis.Service.ProjectService;
import com.muhoza.mis.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Autowired
    BeneficiaryService beneficiaryService;

    @Autowired
    InfoFileService infoFileService;

    @Autowired
    AuthService authService;
    
    @RequestMapping(value="/users")
    public @ResponseBody List<User> getUsers() {	
        return userService.getAllUsers();
    }
    

    @RequestMapping(value="/projects")
    public @ResponseBody List<Project> getProjects() {	
        return projectService.getAllProjects();
    }

    @RequestMapping(value="/beneficiaries")
    public @ResponseBody List<Beneficiary> getBeneficiaries() {	
        return beneficiaryService.getAllBeneficiaries();
    }

    @RequestMapping(value="/beneficiariesbyuser")
    public @ResponseBody List<InfoFile> getInfoFileByUser(Principal principal) {
        User user = authService.getAuthUser(principal);
        return infoFileService.findByUser(user);
    }

    @RequestMapping(value="/beneficiaries/{id}")
    public @ResponseBody List<InfoFile> getInfoFileByUserById(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        return infoFileService.findByUser(user);
    }
    
}