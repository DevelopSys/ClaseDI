package com.example.centro.repository;

import com.example.centro.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // creo la firma de los metodos que quiero contra base de datos
    // query SELECT * FROM Studente WHERE email = email
    Optional<Student> findByEmail(String email);
}
