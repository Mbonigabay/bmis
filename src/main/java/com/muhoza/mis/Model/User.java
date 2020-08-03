package com.muhoza.mis.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class User {
    
    @Id
    @GeneratedValue
    private Integer id;
    private Boolean active;
    @Column(unique = true)
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Invalid email")
    @NotNull
    private String email;
    private String firstName;
    @Size(min=3, message="Last name should be at least 3 character")
    private String lastName; 
    @NotNull
    @Column(unique = true)
    @NotEmpty(message = "Username should not be empty") 
    private String username;
    @NotNull
    @Column(unique = true)
    @NotEmpty(message = "Phone number should not be empty") 
    private String phone;
    @CreationTimestamp
    private LocalDateTime createDateTime; 
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    @NotEmpty(message = "Please choose a password")
    @NotNull
    @Size(min=7, message = "Password should be at least 7 characters")
    private String password;
    private String roles;
    @OneToOne(mappedBy = "user")
    private InfoFile infoFile; 
    @ManyToOne
    @JoinColumn(name = "project_id")  
    private Project project;

}