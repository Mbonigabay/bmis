package com.muhoza.mis.Service;

import java.util.List;

import com.muhoza.mis.Model.InfoFile;
import com.muhoza.mis.Model.User;

public interface InfoFileService {
    InfoFile storeInfofile(InfoFile infoFile);
    List<InfoFile> findByUser(User user);
}