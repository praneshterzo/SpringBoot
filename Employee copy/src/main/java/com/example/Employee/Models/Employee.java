package com.example.Employee.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;
    @Email(message = "Enter the Name of the employee")
    @NotBlank
    private String empEmail;
    @NotBlank(message = "Enter the email of the employee")
    private String empDesignation;
    private long empPhoneNo;
    @NotBlank(message = "Enter the Phone number of the employee")
    private String empAddress;
    @NotBlank(message = "Enter the Adddress of the employee")
    private String empDepartment;
    @NotBlank(message = "Enter the Password of the employee")
    private String empPassword;
}
