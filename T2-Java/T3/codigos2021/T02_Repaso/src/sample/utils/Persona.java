package sample.utils;

public class Persona {

    String nombre, apellido, direccion;

    public Persona(String nombre, String apellido, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return
                nombre + '\'' + apellido;
    }
}
