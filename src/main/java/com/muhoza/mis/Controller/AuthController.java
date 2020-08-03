package com.muhoza.mis.Controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AuthController {
    @RequestMapping("/")
    public String home() {
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


    @RequestMapping("/user")
    public String user() {
        return "user/index";
    }
}