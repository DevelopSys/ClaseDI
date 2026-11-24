package com.example.centro.repository;

import com.example.centro.model.Course;
import com.example.centro.model.Student;
import com.example.centro.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    // creo la firma de los metodos que quiero contra base de datos

}
