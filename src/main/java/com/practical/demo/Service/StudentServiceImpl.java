package com.practical.demo.Service;

import com.practical.demo.Entity.Student;
import com.practical.demo.Repository.StudentRepository;
import com.practical.demo.error.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetchStudentById(Integer studentId) throws StudentNotFoundException {
        Optional<Student> student =  studentRepository.findById(studentId);

        if(!student.isPresent()){
            throw new StudentNotFoundException("Student Not Available");
        }

        return student.get();
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudent(Integer studentId, Student student) {
        Student depDB = studentRepository.findById(studentId).get();
        if (Objects.nonNull(student.getStuname()) &&
                !"".equalsIgnoreCase(student.getStuname())) {
            depDB.setStuname(student.getStuname());
        }

        return studentRepository.save(depDB);
    }

    @Override
    public Student fetchStudentByName(String stuname) {
        return studentRepository.findByStuname(stuname);
    }
}