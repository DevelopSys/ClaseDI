package io.bootify.my_app.curso;

import jakarta.validation.Valid;
import java.util.List;
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
@RequestMapping(value = "/api/cursoes", produces = MediaType.APPLICATION_JSON_VALUE)
public class CursoResource {

    private final CursoService cursoService;

    public CursoResource(final CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> getAllCursoes() {
        return ResponseEntity.ok(cursoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> getCurso(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(cursoService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createCurso(@RequestBody @Valid final CursoDTO cursoDTO) {
        final Long createdId = cursoService.create(cursoDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateCurso(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final CursoDTO cursoDTO) {
        cursoService.update(id, cursoDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable(name = "id") final Long id) {
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
