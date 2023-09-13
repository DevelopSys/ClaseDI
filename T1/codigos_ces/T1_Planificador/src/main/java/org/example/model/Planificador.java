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

    public boolean existeId(int id) {

        if (listaTareas.size() == 0) {
            return false;
        } else {
            for (Tarea item : listaTareas) {
                if (item.getId() == id) {
                    return true;
                }
            }
            return false;
        }


    }

    public boolean addTarea(Tarea tarea) {
        return listaTareas.add(tarea);
    }

    public void listarTareas() {
        for (Tarea item : listaTareas) {
            item.mostrarDatos();
        }
    }

    // hacer un método que permita filtrar tareas por un tipo de prioridad
    public void filtrarTareas(Prioridad prioridad) {
        for (Tarea tarea : listaTareas) {
            if (tarea.getPrioridad() == prioridad) {
                System.out.println(tarea);
            }
        }
    }
}
