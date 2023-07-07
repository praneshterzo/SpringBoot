package com.example.Employee.Dto;

public class AddemployeeDto {
    private int empId;
    private String empName;
    private String empDesignation;
    private String empDepartment;
    private String empAddress;
    private long empPhoneNo;
    private String empEmail;
    private String empPassword;
    private String empConfirmpass;

    @Override
    public String toString() {
        return "AddemployeeDto{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empDesignation='" + empDesignation + '\'' +
                ", empDepartment='" + empDepartment + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", empPhoneno=" + empPhoneNo +
                ", empEmail='" + empEmail + '\'' +
                ", empPassword='" + empPassword + '\'' +
                ", empConfirmpass='" + empConfirmpass + '\'' +
                '}';
    }

    public AddemployeeDto(int empId) {
        this.empId = empId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpConfirmpass(String empConfirmpass) {
        this.empConfirmpass = empConfirmpass;
    }

    public AddemployeeDto(String empName, String empDesignation, String empDepartment, String empAddress, long empPhoneno, String empEmail, String empPassword, String empConfirmpass) {
        this.empName = empName;
        this.empDesignation = empDesignation;
        this.empDepartment = empDepartment;
        this.empAddress = empAddress;
        this.empPhoneNo = empPhoneno;
        this.empEmail = empEmail;
        this.empPassword = empPassword;
        this.empConfirmpass = empConfirmpass;
    }

    public AddemployeeDto() {}

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public long getEmpPhoneno() {
        return empPhoneNo;
    }

    public void setEmpPhoneno(long empPhoneno) {
        this.empPhoneNo = empPhoneno;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpConfirmpass() {
        return empConfirmpass;
    }

    public void setEmpConformpass(String empConfirmpass) {
        this.empConfirmpass = empConfirmpass;
    }


}
