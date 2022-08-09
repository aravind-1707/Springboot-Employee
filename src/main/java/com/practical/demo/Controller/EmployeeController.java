package com.practical.demo.Controller;

import com.practical.demo.Entity.Employee;
import com.practical.demo.Service.EmployeeService;
import com.practical.demo.Service.StudentService;
import com.practical.demo.error.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/Employee")
    public Employee saveEmployee(@RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/Employee/getall")
    public List<Employee> fetchEmployeeById(Employee employee) {
        return employeeService.fetchEmployeeById(employee);
    }


    @GetMapping("/Employee/{id}")
    public Employee employeeGetById(@PathVariable("id") Long empid) throws StudentNotFoundException {
        return employeeService.employeeGetById(empid);
    }

    @DeleteMapping("/Employee/{id}")
    public String employeeDeleteById(@PathVariable("id") Long empid)
    {
        employeeService.employeeDeleteById(empid);
        return "Deleted Successfully..";
    }

    @PutMapping("/Employee/{id}")
    public Employee employeeUpdate(@PathVariable("id") Long empid, @RequestBody Employee employee)
    {
        return employeeService.employeeUpdate(empid,employee) ;
    }


}


