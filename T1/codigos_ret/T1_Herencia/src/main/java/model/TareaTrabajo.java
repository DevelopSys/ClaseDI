package model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class TareaTrabajo extends Tarea {

    private String proyecto;

    public TareaTrabajo(int id, String titulo, String descripcion, String fecha, Prioridad prioridad, String proyecto) {
        super(id, titulo, descripcion, fecha, prioridad);
        this.proyecto = proyecto;
    }

    public void metodoTareaTrabajo(){
        System.out.println("Esto es un método exclusivo de la t trabajo");
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Proyecto "+proyecto);
    }

    @Override
    public boolean completar() {
        if (proyecto.length() > 10) {
            setCompletada(true);
            return true;
        } else {
            return false;
        }
    }
}
