package model;

import utils.Prioridad;

public abstract class Tarea {

    private int id;
    private String titulo;
    private String descripcion;
    private boolean completada;
    private Prioridad prioridad;

    public Tarea(){}
    public Tarea(String titulo){
        this.titulo = titulo;
        this.prioridad = Prioridad.baja;
    }
    public Tarea(String titulo, String descripcion, int prioridad) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        switch (prioridad) {
            case 1:
                this.prioridad = Prioridad.baja;
                break;
            case 2:
                this.prioridad = Prioridad.media;
                break;
            case 3:
                this.prioridad = Prioridad.alta;
                break;
            default:
                this.prioridad = Prioridad.baja;

        }

        // como accedo al color de la tarea

    }

    public abstract void metodoEjecutar();
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


    public void mostrar() {
        System.out.println("Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completada +
                ", prioridad=" + prioridad +
                '}');
    }
}
