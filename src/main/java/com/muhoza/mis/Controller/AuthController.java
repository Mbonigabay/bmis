package com.muhoza.mis.Controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.muhoza.mis.Model.Beneficiary;
import com.muhoza.mis.Model.Project;
import com.muhoza.mis.Model.User;
import com.muhoza.mis.Service.BeneficiaryService;
import com.muhoza.mis.Service.ProjectService;
import com.muhoza.mis.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AuthController {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @Autowired
    BeneficiaryService beneficiaryService;
    
    @RequestMapping("/")
    public String home(HttpSession session) {
        HashMap<String, Object> cardData = new HashMap<String, Object>();
        List<Project> projects = projectService.getAllProjects();
        List<User> users = userService.getAllUsers();
        List<Beneficiary> beneficiaries = beneficiaryService.getAllBeneficiaries();

        cardData.put("allProjects", projects.size());
        cardData.put("allUsers", users.size());
        cardData.put("allBeneficiaries", beneficiaries.size());
        session.setAttribute("cardData", cardData);
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "redirect:/";
    }

    @RequestMapping("/loginError")
    public String loginError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("loginError", "true");
        return "redirect:/";
    }
}