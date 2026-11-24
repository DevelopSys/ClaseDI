package io.bootify.my_app.alumno;

import io.bootify.my_app.curso.Curso;
import io.bootify.my_app.curso.CursoRepository;
import io.bootify.my_app.events.BeforeDeleteCurso;
import io.bootify.my_app.util.NotFoundException;
import io.bootify.my_app.util.ReferencedException;
import java.util.List;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final CursoRepository cursoRepository;

    public AlumnoService(final AlumnoRepository alumnoRepository,
            final CursoRepository cursoRepository) {
        this.alumnoRepository = alumnoRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<AlumnoDTO> findAll() {
        final List<Alumno> alumnoes = alumnoRepository.findAll(Sort.by("id"));
        return alumnoes.stream()
                .map(alumno -> mapToDTO(alumno, new AlumnoDTO()))
                .toList();
    }

    public AlumnoDTO get(final Long id) {
        return alumnoRepository.findById(id)
                .map(alumno -> mapToDTO(alumno, new AlumnoDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final AlumnoDTO alumnoDTO) {
        final Alumno alumno = new Alumno();
        mapToEntity(alumnoDTO, alumno);
        return alumnoRepository.save(alumno).getId();
    }

    public void update(final Long id, final AlumnoDTO alumnoDTO) {
        final Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(alumnoDTO, alumno);
        alumnoRepository.save(alumno);
    }

    public void delete(final Long id) {
        final Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        alumnoRepository.delete(alumno);
    }

    private AlumnoDTO mapToDTO(final Alumno alumno, final AlumnoDTO alumnoDTO) {
        alumnoDTO.setId(alumno.getId());
        alumnoDTO.setName(alumno.getName());
        alumnoDTO.setMail(alumno.getMail());
        alumnoDTO.setCurso(alumno.getCurso() == null ? null : alumno.getCurso().getId());
        return alumnoDTO;
    }

    private Alumno mapToEntity(final AlumnoDTO alumnoDTO, final Alumno alumno) {
        alumno.setName(alumnoDTO.getName());
        alumno.setMail(alumnoDTO.getMail());
        final Curso curso = alumnoDTO.getCurso() == null ? null : cursoRepository.findById(alumnoDTO.getCurso())
                .orElseThrow(() -> new NotFoundException("curso not found"));
        alumno.setCurso(curso);
        return alumno;
    }

    @EventListener(BeforeDeleteCurso.class)
    public void on(final BeforeDeleteCurso event) {
        final ReferencedException referencedException = new ReferencedException();
        final Alumno cursoAlumno = alumnoRepository.findFirstByCursoId(event.getId());
        if (cursoAlumno != null) {
            referencedException.setKey("curso.alumno.curso.referenced");
            referencedException.addParam(cursoAlumno.getId());
            throw referencedException;
        }
    }

}
