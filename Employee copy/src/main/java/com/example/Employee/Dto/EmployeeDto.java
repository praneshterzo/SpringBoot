package com.example.Employee.Dto;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@Builder
public class EmployeeDto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int empId;
        private String empName;
        private String empEmail;
        private String empDesignation;
        private long empPhoneNo;
        private String empAddress;
        private String empDepartment;

    }


