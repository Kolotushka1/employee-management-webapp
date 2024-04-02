package com.managementsystem.employeemanagementwebapp.repository;

import com.managementsystem.employeemanagementwebapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
