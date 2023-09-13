package org.example;


import org.example.model.*;

public class Main {
    public static void main(String[] args) {
        // Crear un menu para poder agregar tareas al planificador
            // 1. Agregar tarea: no se  pueden agregar tareas que
                // tenga id que ya esten en la lista
                // 1. Ocio -> datos
                // 2. Trabajo -> datos
            // 2. Listar tareas
            // 3. Modificar tarea: id -> nueva descripcion nueva prioridad
        Tarea tareaInicial1 = new Tarea(1, "tarea1");
        Tarea tareaInicial2 = new Tarea(2, "tarea1");
        ;
        Tarea tareaInicial3 = new Tarea(3, "tarea1");
        ;
        Tarea tareaSecundaria1 = new Tarea(4, "TArea secundaria1", Prioridad.Media, "2/10/21");
        Tarea tareaSecundaria2 = new Tarea(5, "TArea secundaria2", Prioridad.Media, "2/10/21");
        Tarea tareaSecundaria3 = new Tarea(6, "TArea secundaria3", Prioridad.Media, "2/10/21");
        Tarea tareaSecundaria4 = new Tarea(7, "TArea secundaria4", Prioridad.Alta, "2/10/21");
        Tarea tareaSecundaria5 = new Tarea(8, "TArea secundaria5", Prioridad.Alta, "2/10/21");
        Tarea tareaSecundaria6 = new Tarea(9, "TArea secundaria6", Prioridad.Alta, "2/10/21");
        //System.out.println(tareaTrabajo);




        Planificador planificador = new Planificador();
        planificador.addTarea(tareaInicial1);
        planificador.addTarea(tareaInicial2);
        planificador.addTarea(tareaInicial3);
        planificador.addTarea(tareaSecundaria1);
        planificador.addTarea(tareaSecundaria2);
        planificador.addTarea(tareaSecundaria3);
        planificador.addTarea(tareaSecundaria4);
        planificador.addTarea(tareaSecundaria5);
        planificador.addTarea(tareaSecundaria6);
        //planificador.filtrarTareas(Prioridad.Alta);


    }
}