package com.example.t3_listas.model;

public class Asignatura {

    public String nombre, curso;
    public int nivel;
    public String[] conocimientos;
    public Profesor profesor;


    public Asignatura() {
    }

    public Asignatura(String nombre, String curso, int nivel, String[] conocimientos, Profesor profesor) {
        this.nombre = nombre;
        this.curso = curso;
        this.nivel = nivel;
        this.conocimientos = conocimientos;
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String[] getConocimientos() {
        return conocimientos;
    }

    public void setConocimientos(String[] conocimientos) {
        this.conocimientos = conocimientos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
