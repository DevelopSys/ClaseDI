package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;


@Getter
@Setter
public abstract class Tarea implements Gestionable{
    // variables
    private int id;
    private String titulo;
    private Prioridad prioridad;
    private String fecha;
    private String descripcion;
    private boolean completada;
    private ArrayList<Tarea> listaTareas;

    // constructores

    public Tarea(){
        this.fecha = "01/01/20";
        this.prioridad = Prioridad.Baja;
        listaTareas = new ArrayList<>();
    }
    public Tarea(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = "01/01/20";
        this.prioridad = Prioridad.Baja;
        listaTareas = new ArrayList<>();
    }

    public Tarea(String titulo, String fecha, String descripcion, boolean completada) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.completada = completada;
    }

    public Tarea(int id, String titulo, Prioridad prioridad, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.fecha = "01/01/20";
        listaTareas = new ArrayList<>();
    }

    @Override
    public void verDetalle() {

    }

    public void mostrarDatos(){
        System.out.println("id: "+id);
        System.out.println("titulo: "+titulo);
        System.out.println("desc: "+descripcion);
        System.out.println("prior: "+prioridad);
        System.out.println("fecha: "+fecha);
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
