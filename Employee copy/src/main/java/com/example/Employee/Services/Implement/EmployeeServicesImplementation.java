package com.example.Employee.Services.Implement;

import com.example.Employee.Dto.AddemployeeDto;
import com.example.Employee.Dto.EmployeeDto;
import com.example.Employee.Models.Employee;
import com.example.Employee.Repoistry.EmployeeRepository;
import com.example.Employee.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class EmployeeServicesImplementation implements EmployeeServices {

 EmployeeRepository employeerepo;

    @Autowired
    public EmployeeServicesImplementation(EmployeeRepository employeerepo) {
        this.employeerepo = employeerepo;
    }
    @Override
    public List<EmployeeDto> findallemployee() {
        List<Employee> emp=employeerepo.findAll();
        return emp.stream().map((empl)-> mapToEmployeeDto(empl)).collect(Collectors.toList());
    }
    @Override
    public void save(Employee employee, AddemployeeDto employeeDTO) {
        employee.setEmpAddress(employeeDTO.getEmpAddress());
        employee.setEmpDesignation(employeeDTO.getEmpDesignation());
        employee.setEmpDepartment(employeeDTO.getEmpDepartment());
        employeerepo.save(employee);
    }

    @Override
    public void save(Employee employee) {
        employeerepo.save(employee);
    }

    @Override
    public void deleteemplo(int Id) {
        employeerepo.deleteByEmpId(Id);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeerepo.findByEmpId(id);
    }

    @Override
    public Employee getByEmployeeEmail(String email) {
        return employeerepo.findByEmpEmail(email);
    }

    private EmployeeDto mapToEmployeeDto(Employee empl) {
        EmployeeDto empdto=EmployeeDto.builder()
                .empId(empl.getEmpId())
                .empName(empl.getEmpName())
                .empDepartment(empl.getEmpDepartment())
                .empDesignation(empl.getEmpDesignation())
                .empAddress(empl.getEmpAddress())
                .empEmail(empl.getEmpEmail())
                .empPhoneNo(empl.getEmpPhoneNo())
                .empId(empl.getEmpId())
                .build();
        return empdto;
    }
}
