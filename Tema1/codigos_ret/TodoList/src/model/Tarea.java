package model;

import java.util.Objects;

public class Tarea {

    // variables
    private int id, horasEmpleadas;
    private String titulo, descripcion;
    private Persona responsable;
    private Persona[] equipoTrabajo;
    private boolean completada;

    // constructores -> el vacio (desaparece cuando se escribe uno)


    public Tarea() {

    }

    public Tarea(int id, String titulo, String descripcion, Persona responsable) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.responsable = responsable;
        equipoTrabajo = new Persona[4];
    }

    public Tarea(int id, String titulo, String descripcion, Persona responsable,int horasEmpleadas) {
        this.id = id;
        this.horasEmpleadas = horasEmpleadas;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.responsable = responsable;
        equipoTrabajo = new Persona[4];
    }

    public Persona[] getEquipoTrabajo() {
        return equipoTrabajo;
    }

    public void setEquipoTrabajo(Persona[] equipoTrabajo) {
        this.equipoTrabajo = equipoTrabajo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Persona getResponsable() {
        return responsable;
    }

    public void setResponsable(Persona responsable) {
        this.responsable = responsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHorasEmpleadas() {
        return horasEmpleadas;
    }

    public void setHorasEmpleadas(int horasEmpleadas) {
        this.horasEmpleadas = horasEmpleadas;
    }

    public String getTitulo(int pin) {
        if (pin == 1234) {
            return titulo;
        }
        return null;
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

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", horasEmpleadas=" + horasEmpleadas +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completada +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarea tarea)) return false;
        return getId() == tarea.getId() && getHorasEmpleadas() == tarea.getHorasEmpleadas();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHorasEmpleadas());
    }
}

// crear una clase llamada persona que tenga los
// atributos de: nombre, apellido, dni y edad
// Todos los atributos serán necesarios

// quiero que una tarea tenga un responsable asignado
// es imposible crear una tarea si no tiene responsable

// una tarea tiene hueco para 4 personas del equipo
// inicialmente la tarea no tiene personas en el equipo asignadas
