package com.example.Employee.Repoistry;

import com.example.Employee.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer>{
    Optional <Employee> findEmployeeByEmpName(String empName);
    public void deleteByEmpId(int id);
    public Employee findByEmpId(int id);

    public Employee findByEmpEmail(String email);
}
