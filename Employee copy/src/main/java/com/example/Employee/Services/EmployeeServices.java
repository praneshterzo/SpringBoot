package com.example.Employee.Services;

import com.example.Employee.Dto.AddemployeeDto;
import com.example.Employee.Dto.EmployeeDto;
import com.example.Employee.Models.Employee;

import java.util.List;

public interface EmployeeServices {
    List<EmployeeDto> findallemployee();

    public void save(Employee employee);


    public void save(Employee employee, AddemployeeDto employeeDTO);

    public void deleteemplo(int Id);

    public Employee getEmployeeById(int id);

    public Employee getByEmployeeEmail(String email);
}
