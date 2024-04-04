package com.managementsystem.employeemanagementwebapp.service;

import com.managementsystem.employeemanagementwebapp.dto.UserRegistrationDto;
import com.managementsystem.employeemanagementwebapp.models.Employee;
import com.managementsystem.employeemanagementwebapp.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    User save(UserRegistrationDto registrationDto);
    User getUserById(long id);
    void deleteUserById(long id);
}
