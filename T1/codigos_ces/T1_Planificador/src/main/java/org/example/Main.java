package org.example;


import org.example.model.Tarea;

public class Main {
    public static void main(String[] args) {
        Tarea tareaInicial = new Tarea();
        // id = 0;
        // titulo = null;
        // prioridad = null;
        // fecha = 1/1/20;
        // descripcion = null;
        System.out.println(tareaInicial);
        Tarea tareaSecundaria = new Tarea(1,"TArea secundaria");
        // id = 1;
        // titulo = Tarea secundaria;
        // prioridad = null;
        // fecha = 1/1/20;
        // descripcion = null;
        System.out.println(tareaSecundaria);

    }
}