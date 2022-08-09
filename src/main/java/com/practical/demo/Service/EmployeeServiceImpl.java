package com.practical.demo.Service;

import com.practical.demo.Entity.Employee;
import com.practical.demo.Repository.EmployeeRepository;
import com.practical.demo.error.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeeById(Employee employee) {
        return employeeRepository.findAll();
    }

    @Override
    public Employee employeeGetById(Long empid) throws StudentNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(empid);

        if(!employee.isPresent())
        {
            throw new StudentNotFoundException("Employee Not Available");

        }
        return employee.get();
    }

    @Override
    public void employeeDeleteById(Long empid) {
        employeeRepository.deleteById(empid);
    }

    @Override
    public Employee employeeUpdate(Long empid, Employee employee) {
        Employee depDb = employeeRepository.findById(empid).get();

        if(Objects.nonNull(employee.getEmpname()) &&
                !"".equalsIgnoreCase(employee.getEmpname())) {
            depDb.setEmpname(employee.getEmpname());
        }

            if(Objects.nonNull(employee.getEmpdept()) &&
                    !"".equalsIgnoreCase(employee.getEmpdept())){
                depDb.setEmpdept(employee.getEmpdept());
        }

        if(Objects.nonNull(employee.getEmpid())&&
        !"".equalsIgnoreCase(String.valueOf(employee.getEmpid()))){
            depDb.setEmpid(employee.getEmpid());
        }

        return employeeRepository.save(depDb);
    }


}
