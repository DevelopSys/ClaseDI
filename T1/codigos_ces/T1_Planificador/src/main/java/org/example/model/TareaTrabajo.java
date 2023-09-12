package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaTrabajo extends Tarea{
    private String proyecto;

    public TareaTrabajo(){
        super();
    }
    public TareaTrabajo(int id, String titulo, Prioridad prioridad, String descripcion, String proyecto) {
        super(id, titulo, prioridad, descripcion);
        this.proyecto = proyecto;
    }
}
