package model;

import utils.Prioridad;

public class Tarea {

    private int id;
    private String titulo;
    private String descripcion;
    private boolean completada;
    private Prioridad prioridad;

    public Tarea(){}
    public Tarea(String titulo, String descripcion, int prioridad) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        switch (prioridad) {
            case 0:
                this.prioridad = Prioridad.baja;
                break;
            case 1:
                this.prioridad = Prioridad.media;
                break;
            case 2:
                this.prioridad = Prioridad.alta;
                break;
            default:
                this.prioridad = Prioridad.baja;

        }

        // como accedo al color de la tarea

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }
}
