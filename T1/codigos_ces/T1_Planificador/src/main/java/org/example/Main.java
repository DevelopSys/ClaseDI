package org.example;


import org.example.database.GestionDB;
import org.example.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Planificador planificador = new Planificador();
        //planificador.addGestionableSQLPS(new TareaOcio("TOcio","FOcio","DOcio",true));
        planificador.getAllTareas();

        /*Gestionable gestionable = new TareaOcio();
        gestionable.getId();
        GestionDB gestionDB = new GestionDB();
        Connection connection = gestionDB.getConnection();

        try {
            System.out.println(connection.getCatalog());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Statement statement = connection.createStatement();
            statement.executeq
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/




        /*Scanner lecturaTeclado = new Scanner(System.in);
        int opcion, opcion2, presupuesto, id;
        String titulo, descripcion, fecha, ubicacion, proyecto;
        Prioridad prioridad = null;
        Planificador planificador = new Planificador();

        do {
            System.out.println("1. Agregar");
            System.out.println("2. Listar");
            System.out.println("3. Modifica");
            System.out.println("4. Salir");
            System.out.println("Indica que opcion quieres realizar");
            opcion = lecturaTeclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Agregar tarea. ¿De que tipo? 1. Ocio 2. Trabajo");
                    opcion2 = lecturaTeclado.nextInt();
                    switch (opcion2) {
                        case 1:
                            System.out.println("Indica id");
                            id = lecturaTeclado.nextInt();
                            // comprobar el id
                            if (!planificador.existeId(id)) {
                                System.out.println("Indica titulo");
                                titulo = lecturaTeclado.next();
                                System.out.println("Indica desc");
                                descripcion = lecturaTeclado.next();
                                System.out.println("Indica fecha");
                                fecha = lecturaTeclado.next();
                                System.out.println("Indica ubicacion");
                                ubicacion = lecturaTeclado.next();
                                System.out.println("Indica presupuesto");
                                presupuesto = lecturaTeclado.nextInt();
                                System.out.println("Indica prioridad: 1. baja 2. media 3. alta");
                                int opcionPrior = lecturaTeclado.nextInt();
                                switch (opcionPrior) {
                                    case 1:
                                        prioridad = Prioridad.Baja;
                                        break;
                                    case 2:
                                        prioridad = Prioridad.Media;
                                        break;
                                    case 3:
                                        prioridad = Prioridad.Alta;
                                        break;
                                }
                                TareaOcio tareaOcio = new TareaOcio(id, titulo, prioridad, descripcion, presupuesto, ubicacion);
                                //planificador.addTarea(tareaOcio);
                            } else {
                                System.out.println("El id ya existe");
                            }

                            break;
                        case 2:
                            break;
                    }
                    break;
                case 2:
                    planificador.listarTareas();
                    break;
                case 3:
                    break;
            }

        } while (opcion != 4);
*/
    }
}