package com.muhoza.mis.Service.Impl;

import java.util.List;

import com.muhoza.mis.Model.Beneficiary;
import com.muhoza.mis.Repository.BeneficiaryRepository;
import com.muhoza.mis.Service.BeneficiaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IBeneficiaryService implements BeneficiaryService {

    @Autowired
    BeneficiaryRepository beneficiaryRepository;

    @Override
    public List<Beneficiary> getAllBeneficiaries() {
        return beneficiaryRepository.findAll();
    }
    
}