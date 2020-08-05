package com.muhoza.mis.Service.Impl;

import java.util.List;

import com.muhoza.mis.Model.Project;
import com.muhoza.mis.Repository.ProjectRepository;
import com.muhoza.mis.Service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class IProjectService implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(int id) {
          return projectRepository.findById(id).get();
    }

    @Override
    public Project storeProject(Project project) {
        return projectRepository.save(project);
    }
}