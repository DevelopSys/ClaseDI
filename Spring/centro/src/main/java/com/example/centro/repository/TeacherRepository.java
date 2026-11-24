package com.example.centro.repository;

import com.example.centro.model.Student;
import com.example.centro.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    // creo la firma de los metodos que quiero contra base de datos
}
