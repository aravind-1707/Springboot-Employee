package com.practical.demo.Service;

import com.practical.demo.Entity.Employee;
import com.practical.demo.Entity.Student;
import com.practical.demo.error.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> fetchStudentList();

    public  Student fetchStudentById(Integer studentId) throws StudentNotFoundException;

    public void deleteStudentById(Integer studentId);

    public Student updateStudent(Integer studentId,Student student);

     Student fetchStudentByName(String stuname);


}
