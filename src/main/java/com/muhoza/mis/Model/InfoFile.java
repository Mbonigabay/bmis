package com.muhoza.mis.Model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class InfoFile {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String status;
    @ManyToOne
    @JoinColumn(name="created_by")
    private User user;
    @OneToOne
    @JoinColumn(name="contains_info_by")
    private Beneficiary beneficiary;
    @CreationTimestamp
    private LocalDateTime createDateTime; 
    @UpdateTimestamp
    private LocalDateTime updateDateTime; 

}