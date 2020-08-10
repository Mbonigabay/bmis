package com.muhoza.mis.Service.Impl;

import java.util.List;

import com.muhoza.mis.Model.InfoFile;
import com.muhoza.mis.Model.User;
import com.muhoza.mis.Repository.InfoFileRepository;
import com.muhoza.mis.Service.InfoFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IInfoFileService implements InfoFileService {

    @Autowired
    InfoFileRepository infoFileRepository;

    @Override
    public InfoFile storeInfofile(InfoFile infoFile) {
        return infoFileRepository.save(infoFile);
    }

    @Override
    public List<InfoFile> findByUser(User user) {
        return infoFileRepository.findByUser(user);
    }

    @Override
    public List<InfoFile> getAllInfoFile() {
        return infoFileRepository.findAll();
    }


}