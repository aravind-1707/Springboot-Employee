package com.practical.demo.Controller;

import com.practical.demo.Entity.Student;
import com.practical.demo.Service.StudentService;
import com.practical.demo.Service.StudentServiceImpl;
import com.practical.demo.error.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/Student")
    public Student saveStudent(@Valid @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/Student/getall")
    public List<Student> fetchStudentList() {
        return studentService.fetchStudentList();
    }

    @GetMapping("/Student/getall/{id}")
    public Student fetchStudentById(@PathVariable("id") Integer studentId) throws StudentNotFoundException
    {
        return studentService.fetchStudentById(studentId);
    }

    @DeleteMapping("/Student/delete/{id}")
    public String deleteStudentById(@PathVariable("id") Integer studentId)
    {
        studentService.deleteStudentById(studentId);
        return "Student Details Deleted Successfully";
    }

    @PutMapping("/Student/update/{id}")
    public Student updateStudent(@PathVariable("id") Integer studentId,@RequestBody Student student)
    {
        return studentService.updateStudent(studentId,student);
    }

    @GetMapping("/Student/name/{name}")
    public Student fetchStudentByName(@PathVariable("name") String stuname){
        return studentService.fetchStudentByName(stuname);
    }
}
