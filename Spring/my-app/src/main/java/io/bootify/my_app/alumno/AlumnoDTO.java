package io.bootify.my_app.alumno;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AlumnoDTO {

    private Long id;

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String mail;

    private Long curso;

}
