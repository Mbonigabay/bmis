package com.muhoza.mis.Controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.muhoza.mis.Config.SecurityConfiguration;
import com.muhoza.mis.Model.Beneficiary;
import com.muhoza.mis.Model.InfoFile;
import com.muhoza.mis.Model.Project;
import com.muhoza.mis.Model.User;
import com.muhoza.mis.Service.AuthService;
import com.muhoza.mis.Service.InfoFileService;
import com.muhoza.mis.Service.ProjectService;
import com.muhoza.mis.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    InfoFileService infoFileService;

    @Autowired
    AuthService authService;
    
    @Autowired
    SecurityConfiguration security;

    @RequestMapping("")
    public String getUserPage(Model model, Principal principal, HttpSession session) {
        HashMap<String, Object> cardData = new HashMap<String, Object>();
        Beneficiary beneficiary = new Beneficiary();
        User user = authService.getAuthUser(principal);
        List<InfoFile> infoFiles =  infoFileService.findByUser(user);

        cardData.put("allBeneficiariesbyuser", infoFiles.size());
        session.setAttribute("cardData", cardData);

        model.addAttribute("beneficiary", beneficiary);
        return "user/index";
    }
    
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