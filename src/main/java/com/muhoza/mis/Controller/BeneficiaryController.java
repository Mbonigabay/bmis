package com.muhoza.mis.Controller;

import java.security.Principal;

import com.muhoza.mis.Model.Beneficiary;
import com.muhoza.mis.Model.InfoFile;
import com.muhoza.mis.Model.User;
import com.muhoza.mis.Service.AuthService;
import com.muhoza.mis.Service.BeneficiaryService;
import com.muhoza.mis.Service.InfoFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/beneficiaries")
@Slf4j
public class BeneficiaryController {

    @Autowired
    AuthService authService;

    @Autowired
    BeneficiaryService beneficiaryService;

    @Autowired
    InfoFileService infoFileService;
    
    @RequestMapping("")
    public String store(@ModelAttribute("beneficiary") Beneficiary beneficiary, Principal principal) {
        InfoFile infoFile = new InfoFile();
        User auth = authService.getAuthUser(principal);

        infoFile.setStatus("pending");
        infoFile.setUser(auth);
        Beneficiary newBeneficiary = beneficiaryService.storeBeneficiary(beneficiary);
        infoFile.setBeneficiary(newBeneficiary);
        infoFileService.storeInfofile(infoFile);

        log.info("{}", infoFile);
        log.info("{}", beneficiary);
        log.info("{}", auth);
        return "redirect:/users";
    }
}