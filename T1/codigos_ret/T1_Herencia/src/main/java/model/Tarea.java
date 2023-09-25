package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter

public abstract class Tarea {
    private int id;
    private String titulo, descripcion, fecha;
    private Prioridad prioridad;
    private boolean completada;
    private ArrayList<Tarea> listaSubtareas;

    public Tarea(int id, String titulo, String descripcion, String fecha, Prioridad prioridad) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.prioridad = prioridad;
        this.listaSubtareas = new ArrayList<>();
        //this.completada = false;
    }

    public Tarea(){
        this.listaSubtareas = new ArrayList<>();
    }

    public void agregarSubtarea(Tarea tarea){
        listaSubtareas.add(tarea);
    }

    public abstract boolean completar();
    public void mostrarDatos(){
        System.out.println("ID: "+id);
        System.out.println("Titulo: "+titulo);
        System.out.println("Descripcion: "+descripcion);
        System.out.println("Fecha: "+fecha);
        System.out.println("Prioridad: "+prioridad);
        System.out.println("Completada: "+completada);
    }
}
