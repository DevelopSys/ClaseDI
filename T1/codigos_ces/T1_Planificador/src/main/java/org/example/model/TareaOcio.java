package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaOcio extends Tarea{

    private int presupuesto;
    private String ubicacion;

    public TareaOcio() {
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("presupuesto: "+presupuesto);
        System.out.println("ubicacion: "+ubicacion);
    }

    public TareaOcio(int id, String titulo, Prioridad prioridad, String descripcion, int presupuesto, String ubicacion) {
        super(id, titulo, prioridad, descripcion);
        this.presupuesto = presupuesto;
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return super.toString() + "TareaOcio{" +
                "presupuesto=" + presupuesto +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
