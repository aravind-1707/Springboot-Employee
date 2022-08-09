package com.practical.demo.Repository;

import com.practical.demo.Entity.Course;
import com.practical.demo.Entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMaterialRepository {


    void save(CourseMaterial courseMaterial);

    List<CourseMaterial> findAll();
}
