package com.practical.demo.Repository;


import com.practical.demo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface StudentRepository extends JpaRepository<Student,Integer> {

   //@Query("select s from Student s where s.stuname =1? ")
    public Student findByStuname(String stuname);
}