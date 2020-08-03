package com.muhoza.mis.Repository;

import java.util.Optional;

import com.muhoza.mis.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);
    
}