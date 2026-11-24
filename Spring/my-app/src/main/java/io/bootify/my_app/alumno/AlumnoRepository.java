package io.bootify.my_app.alumno;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    Alumno findFirstByCursoId(Long id);

}
