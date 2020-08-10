package com.muhoza.mis.Service;

import java.util.List;

import com.muhoza.mis.Model.Beneficiary;

public interface BeneficiaryService {
    List<Beneficiary> getAllBeneficiaries();
    Beneficiary storeBeneficiary(Beneficiary beneficiary);
}