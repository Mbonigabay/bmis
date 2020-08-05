package com.muhoza.mis.Repository;

import java.util.List;

import com.muhoza.mis.Model.InfoFile;
import com.muhoza.mis.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoFileRepository extends JpaRepository<InfoFile, Integer>{
    List<InfoFile> findByUser(User user);
}