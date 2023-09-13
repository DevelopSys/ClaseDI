package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaTrabajo extends Tarea {
    public String proyecto;

    public TareaTrabajo() {
        super();
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("proy: "+proyecto);
    }

    public TareaTrabajo(int id, String titulo, Prioridad prioridad, String descripcion, String proyecto) {
        super(id, titulo, prioridad, descripcion);
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return super.toString() + " proyecto " + proyecto;

    }
}
