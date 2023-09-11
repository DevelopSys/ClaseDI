package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class Tarea {

    @Getter
    @Setter

    // variables
    private int id;
    private String titulo;
    private String prioridad;
    private String fecha;
    private String descripcion;

    // constructores

    public Tarea(){
        this.fecha = "01/01/20";
    }
    public Tarea(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = "01/01/20";
    }

    public Tarea(int id, String titulo, String prioridad, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.fecha = "01/01/20";
    }

    public static void metodoTarea(){
        System.out.println("Ejemplo de método para una tarea");
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", fecha='" + fecha + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
