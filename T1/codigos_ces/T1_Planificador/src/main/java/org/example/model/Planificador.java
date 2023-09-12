package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Planificador {

    private ArrayList<Tarea> listaTareas;

    public Planificador() {
        listaTareas = new ArrayList<>();
    }

    public boolean addTarea(Tarea tarea) {
        return listaTareas.add(tarea);
    }

    // hacer un método que permita filtrar tareas por un tipo de prioridad
    public void filtrarTareas(Prioridad prioridad) {
        for ( Tarea tarea : listaTareas){
            if (tarea.getPrioridad() == prioridad){
                System.out.println(tarea);
            }
        }
    }
}
