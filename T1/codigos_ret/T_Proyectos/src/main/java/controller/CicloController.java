package controller;

import database.GestionDB;
import lombok.NoArgsConstructor;
import model.Alumno;
import model.Profesor;
import model.Proyecto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@NoArgsConstructor
public class CicloController {

    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Profesor> listaProfesores;
    private ArrayList<Proyecto> listaProyectos;

    public CicloController() {
        listaAlumnos = new ArrayList<>();
        listaProfesores = new ArrayList<>();
        listaProyectos = new ArrayList<>();
    }

    public void addAlumno(Alumno alumno) {
        if (existeAlumno(alumno.getDni()) == null) {
            listaAlumnos.add(alumno);
        } else {
            System.out.println("El alumno existe, no se puede agregar");
        }
    }

    public Alumno existeAlumno(String dni) {

        for (Alumno item : listaAlumnos) {
            if (item.getDni().equalsIgnoreCase(dni)) {
                return item;
            }
        }
        return null;

    }

    public void addProfesor(Profesor profesor) {
        if (existeProfesor(profesor.getDni()) == null) {
            listaProfesores.add(profesor);
        } else {
            System.out.println("El profesor existe, no se puede agregar");
        }
    }

    public Profesor existeProfesor(String dni) {

        for (Profesor item : listaProfesores) {
            if (item.getDni().equalsIgnoreCase(dni)) {
                return item;
            }
        }
        return null;

    }

    public void listarProyectos() {
        for (Proyecto item : listaProyectos) {
            item.mostrarDatos();
        }
    }

    public void addProyecto(Proyecto proyecto) {
        // 1 a 3 integrantes
        // 1 profesor
        listaProyectos.add(proyecto);
    }

    public void exportarDatos() {
        Connection connection = new GestionDB().getConnection();
        try {
            Statement st = connection.createStatement();
            for (Alumno item : listaAlumnos) {
                st.execute(String.format("INSERT into alumnos (nombre, apellido, dni)" +
                        " VALUES ('%s','%s','%s')",
                        item.getNombre(), item.getApellido(), item.getDni()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
