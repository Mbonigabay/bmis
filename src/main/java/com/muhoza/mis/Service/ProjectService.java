package com.muhoza.mis.Service;

import java.util.List;

import com.muhoza.mis.Model.Project;

public interface ProjectService {
    List<Project> getAllProjects();
    Project findById(int id);
}