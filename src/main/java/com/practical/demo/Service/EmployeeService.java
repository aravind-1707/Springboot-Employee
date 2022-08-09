package com.practical.demo.Service;

import com.practical.demo.Entity.Employee;
import com.practical.demo.error.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
   public Employee saveEmployee(Employee employee);

   public List<Employee> fetchEmployeeById(Employee employee);


   public Employee employeeGetById(Long empid) throws StudentNotFoundException;



   public void employeeDeleteById(Long empid);

   public Employee employeeUpdate(Long empid, Employee employee);


}
