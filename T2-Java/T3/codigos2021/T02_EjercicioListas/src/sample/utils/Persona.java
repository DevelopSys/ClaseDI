package sample.utils;

public final class Persona {

    private String nombre, apellido, estado;
    private int telefono;
    private boolean disponibilidad;

    public Persona(String nombre, String apellido, String estado, int telefono, boolean disponibilidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.telefono = telefono;
        this.disponibilidad = disponibilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return getNombre() +" "+getApellido();
    }
}
