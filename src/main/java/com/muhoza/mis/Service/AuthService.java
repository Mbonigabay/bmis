package com.muhoza.mis.Service;

import java.security.Principal;

import com.muhoza.mis.Model.User;

public interface AuthService {
    User getAuthUser(Principal principal);
}