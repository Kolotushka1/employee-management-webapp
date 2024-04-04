package com.managementsystem.employeemanagementwebapp.controllers;

import com.managementsystem.employeemanagementwebapp.dto.UserRegistrationDto;
import com.managementsystem.employeemanagementwebapp.models.Employee;
import com.managementsystem.employeemanagementwebapp.models.Role;
import com.managementsystem.employeemanagementwebapp.models.User;
import com.managementsystem.employeemanagementwebapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("newUser")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping("/users")
    public String users(Model model) {

        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);

        return "users/users";
    }

    @GetMapping("/users/newUserForm")
    public String newUserForm(Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "users/new_user";
    }

    @PostMapping("/users/saveUser")
    public String saveUser(@ModelAttribute("newUser") UserRegistrationDto registrationDto) {

       userService.save(registrationDto);
       return "redirect:/users";

    }

    @PostMapping("/users/updateUser")
    public String updateUser(@ModelAttribute("newUser") UserRegistrationDto userRegistrationDto) {

        userService.save(userRegistrationDto);
        return "redirect:/users";

    }

    @GetMapping("/users/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

        User newUser = userService.getUserById(id);

        model.addAttribute("newUser", newUser);
        return "users/update_user";
    }

    @GetMapping("/users/deleteEmployee/{id}")
    public String deleteUser(@PathVariable (value = "id") long id) {

        this.userService.deleteUserById(id);
        return "redirect:/users";
    }
}
