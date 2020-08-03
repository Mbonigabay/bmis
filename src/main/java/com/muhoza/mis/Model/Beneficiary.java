package com.muhoza.mis.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class Beneficiary {

    @Id
    @GeneratedValue
    private Integer id;
    private Boolean active;
    private String firstName;
    @Size(min = 3, message = "Last name should be at least 3 character")
    private String lastName;
    @NotNull
    @Column(unique = true)
    @NotEmpty(message = "Phone number should not be empty")
    private String phone;
    private String otherMeansOfContact;
    private String gender;
    private String age;
    private String status;
    private String disability;
    private String reasonOfIntervention;
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    @OneToOne(mappedBy = "beneficiary")
    private InfoFile infoFile;
}