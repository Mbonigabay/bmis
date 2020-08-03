package com.muhoza.mis.Controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("")
    public String index(Principal principal) {
        return "admin/index";
    }

    @RequestMapping("/user")
    public String getUserPage(Principal principal) {
        return "admin/user";
    }
}