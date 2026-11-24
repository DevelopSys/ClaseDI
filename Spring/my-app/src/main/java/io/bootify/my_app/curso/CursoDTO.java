package io.bootify.my_app.curso;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CursoDTO {

    private Long id;

    @Size(max = 255)
    private String name;

}
