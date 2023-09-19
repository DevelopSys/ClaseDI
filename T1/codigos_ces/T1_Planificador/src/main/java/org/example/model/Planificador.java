package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.database.GestionDB;
import org.example.database.ScehemeDB;

import java.sql.*;
import java.util.ArrayList;

@Getter
@Setter
public class Planificador {

    private ArrayList<Gestionable> listaTareas;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public Planificador() {

        connection = new GestionDB().getConnection();
        listaTareas = new ArrayList<>();
    }

    public boolean existeId(int id) {

        if (listaTareas.size() == 0) {
            return false;
        } else {

            for (Gestionable item : listaTareas) {

                if (item.getId() == id) {
                    return true;
                }
            }
            return false;
        }


    }

    public void addGestionableSQL(Gestionable gestionable) {

        // Tarea
        try {
            statement = connection.createStatement();
            if (gestionable instanceof Tarea) {
                // agregar a base de datos
                String sql = "INSERT into %s (%s, %s, %s, %s) VALUES" +
                        "('%s','%s','%s',%b)";
                statement.execute(String.format(sql, ScehemeDB.TABLA
                        , ScehemeDB.COL_TITULO, ScehemeDB.COL_DES, ScehemeDB.COL_FECHA, ScehemeDB.COL_COMPL
                            , ((Tarea) gestionable).getTitulo(), ((Tarea) gestionable).getDescripcion(),
                            ((Tarea) gestionable).getFecha(), ((Tarea) gestionable).isCompletada()));
                //"INSERT INTO tareas (titulo, descripcion, fecha, completada)"
            } else if (gestionable instanceof Lista) {
                //gestionable.
                // INSERT INTO tareas (id, id)
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Lista
    }

    public boolean addGestionable(Gestionable tarea) {
        return listaTareas.add(tarea);
    }

    public boolean addLista(Lista lista) {
        return listaTareas.add(lista);
    }

    public void listarTareas() {
        /*for (Tarea item : listaTareas) {
            item.mostrarDatos();
        }*/
    }

    // hacer un método que permita filtrar tareas por un tipo de prioridad
    public void filtrarTareas(Prioridad prioridad) {
        /*for (Tarea tarea : listaTareas) {
            if (tarea.getPrioridad() == prioridad) {
                System.out.println(tarea);
            }
        }*/
    }
}
