package com.managementsystem.employeemanagementwebapp.controllers;

import com.managementsystem.employeemanagementwebapp.mail.MailService;
import com.managementsystem.employeemanagementwebapp.models.Employee;
import com.managementsystem.employeemanagementwebapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.context.Context;

import java.util.List;

@Controller
public class EmailController {
    private final MailService emailService;
    private final EmployeeService employeeService;

    @Autowired
    public EmailController(MailService emailService, EmployeeService employeeService) {
        this.emailService = emailService;
        this.employeeService = employeeService;
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestParam("email") String recipientEmail,
                            RedirectAttributes redirectAttributes,
                            Model model) {
        List<Employee> employees = employeeService.getAllEmployees();

        Context context = new Context();
        context.setVariable("title", "About Employees");
        context.setVariable("message", "This is a list (table) of Employees.");
        context.setVariable("employees", employees);

        emailService.sendHtmlMessage(recipientEmail, "About Employees", "email-template", context);

        redirectAttributes.addFlashAttribute("messageSent", true);

        return "redirect:/";
    }
}
