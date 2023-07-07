package com.example.Employee.Controller;

import com.example.Employee.Dto.*;
import com.example.Employee.Models.Employee;
import com.example.Employee.Models.User;
import com.example.Employee.Services.EmployeeServices;
import com.example.Employee.Services.UserServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Employeecontroller {
    private EmployeeServices empservices;
    private UserServices userServices;

    @Autowired
    public Employeecontroller(EmployeeServices empservices) {

        this.empservices = empservices;
    }

    @GetMapping("/view")
    public List<EmployeeDto> listEmployees() {
        List<EmployeeDto> Details = empservices.findallemployee();
        return Details;
    }

    @PostMapping("/add")
    public String register( @RequestBody AddemployeeDto employee)
    {
        Employee det=new Employee();
        String errorMsg="";
        if(employee.getEmpEmail().endsWith("@terzo.com"))
            det.setEmpEmail(employee.getEmpEmail());
        else
            errorMsg+="Enter a valid email id!\n";

        if(errorMsg.equals("")) {
            BeanUtils.copyProperties(employee,det);
            empservices.save(det);
            return "Details Saved";
        }
        else {
            return errorMsg;
        }

    }

    @GetMapping("/Employee/{id}/view")
    public AddemployeeDto view(@PathVariable("id")String id ){

        Employee employee = empservices.getEmployeeById((Integer.parseInt(id)));
        AddemployeeDto addEmployeeDTO = new AddemployeeDto();
        BeanUtils.copyProperties(employee,addEmployeeDTO);
        return addEmployeeDTO;
    }

    @DeleteMapping("/Employee/{id}/delete")
    public String deleteemplo(@PathVariable("id") int id){
        empservices.deleteemplo(id);
        return "Employee Details Deleted Successfully";

    }

    @PutMapping("/Employee/{id}/update")
    public String save(@PathVariable("id")int id ,@RequestBody Employee employee){
        Employee empl = empservices.getEmployeeById(id);
        String errorMsg="";

        if(employee.getEmpEmail().endsWith("@terzo.com"))
            empl.setEmpEmail(employee.getEmpEmail());
        else
            errorMsg+="Enter a valid email id!\n";

        if(errorMsg.equals("")){
            BeanUtils.copyProperties(employee,empl);
            return "Details Saved";
        }
        else {
            return errorMsg;
        }
    }


    @PostMapping("/register")
    public String authenticate(@RequestBody User user){
        userServices.save(user);
        return "Registered";
    }
}
