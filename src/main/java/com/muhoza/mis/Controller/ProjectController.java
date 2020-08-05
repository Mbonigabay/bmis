package com.muhoza.mis.Controller;

import com.muhoza.mis.Model.Project;
import com.muhoza.mis.Service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/projects")
@Slf4j
public class ProjectController {

    @Autowired
    ProjectService projectService;
    
    @PostMapping("")
    public String store(@ModelAttribute("project") Project project){
        projectService.storeProject(project);
        return "redirect:/admin/project";
    }
}