package com.muhoza.mis.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Project {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String manager;
    private String managerPhone;
    private String managerEmail;
    private String areaOfIntervention;
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "project")
    private List<User> users;
}