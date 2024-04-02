package com.managementsystem.employeemanagementwebapp.service;

import com.managementsystem.employeemanagementwebapp.dto.UserRegistrationDto;
import com.managementsystem.employeemanagementwebapp.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
