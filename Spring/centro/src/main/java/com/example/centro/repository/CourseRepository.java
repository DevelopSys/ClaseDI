package com.example.centro.repository;

import com.example.centro.model.Course;
import com.example.centro.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // creo la firma de los metodos que quiero contra base de datos
}
