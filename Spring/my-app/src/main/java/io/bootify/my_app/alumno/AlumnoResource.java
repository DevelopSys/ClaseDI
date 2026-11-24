package io.bootify.my_app.alumno;

import io.bootify.my_app.curso.CursoService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/alumnoes", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlumnoResource {

    private final AlumnoService alumnoService;
    private final CursoService cursoService;

    public AlumnoResource(final AlumnoService alumnoService, final CursoService cursoService) {
        this.alumnoService = alumnoService;
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> getAllAlumnoes() {
        return ResponseEntity.ok(alumnoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> getAlumno(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(alumnoService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createAlumno(@RequestBody @Valid final AlumnoDTO alumnoDTO) {
        final Long createdId = alumnoService.create(alumnoDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateAlumno(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final AlumnoDTO alumnoDTO) {
        alumnoService.update(id, alumnoDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable(name = "id") final Long id) {
        alumnoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cursoValues")
    public ResponseEntity<Map<Long, Long>> getCursoValues() {
        return ResponseEntity.ok(cursoService.getCursoValues());
    }

}
