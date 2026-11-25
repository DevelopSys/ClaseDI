package com.example.centro.repository;

import com.example.centro.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // creo la firma de los metodos que quiero contra base de datos
    // query SELECT * FROM Studente WHERE email = email
    Optional<Student> findByEmail(String email);

    List<Student> findByAddress(String address);

    //@Query("SELECT * FROM Student s WHERE s.address = :location")
    // @Query("FROM Student s SET s.phone = :phone WHERE s.address = :location")
    // int updateByLocation(@Param("location") String location, @Param("phone") int phone);
}
