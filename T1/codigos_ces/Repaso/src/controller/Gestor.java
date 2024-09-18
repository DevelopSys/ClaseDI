package controller;

import model.Tarea;

import java.util.ArrayList;
import java.util.Objects;

public class Gestor {

    private ArrayList<Tarea> tareas;
    int contador;

    public Gestor() {
        this.tareas = new ArrayList();
        // contador = 0
    }

    // tipo, tipo de listado
    // 0-> todas
    // 1-> prioridad
    // 2-> completadas
    // valor -> tipo de prioridad {1-baja,2-media,3-alta}
    public void listarTareas(int tipo, int valor) {
        for (Tarea item : tareas) {
            if (tipo == 0) {
                System.out.println(item);
            } else if (tipo == 1 && item.getPrioridad().getValor() == valor) {
                    System.out.println(item);
            } else if (tipo == 2 && item.isCompletada()){
                System.out.println(item);
            }
        }

    }

    public Tarea borrarTarea(int id){
        // null o Tarea
        Tarea tareaEncontrada = buscarTarea(id);
        if (tareaEncontrada!=null){
            tareas.remove(tareaEncontrada);
        }
        return tareaEncontrada;
    }

    public void actualizarTarea(int id, String descripcion){
        Tarea tareaEncontrada = buscarTarea(id);
        if(tareaEncontrada!=null){
            tareaEncontrada.setDescripcion(descripcion);
            System.out.println("Modificada correctamente");
        } else {
            System.out.println("Error al modificar");
        }
    }

    public void completarTarea(int id){
        Tarea tareaEncontrada = buscarTarea(id);
        if (!tareaEncontrada.isCompletada() && tareaEncontrada !=null){
            tareaEncontrada.setCompletada(true);
            System.out.println("Tarea completada correctamente");
        }
    }

    public boolean agragarTarea(Tarea tarea){
        // duplicada???
        contador++;
        tarea.setId(contador);
        if (buscarTarea(tarea.getId())==null){
            tareas.add(tarea);
            return true;
        } else {
            // quita el ++ del contador
            contador--;
            return false;
        }
        // poner el id a la tarea

    }

    private Tarea buscarTarea(int id) {
        Tarea tareaEncontrada = null;
        for (Tarea item : tareas) {
            if (item.getId() == id) {
                tareaEncontrada = item;
                break;
            }
        }
        return tareaEncontrada;
    }

    // CREAR LOS METODOS QUE PERMITAN
    // Agregar tareas -> con IDs unicos
    // Listar tareas
    // todas
    // por prioridad
    // completadas - no completadas
    // completar tareas
    // indicas el id y cambias el estado,
    // siempre que el estado no este completado
    // Modificar tareas
    // indicas el id y modificas la descripcion


}
