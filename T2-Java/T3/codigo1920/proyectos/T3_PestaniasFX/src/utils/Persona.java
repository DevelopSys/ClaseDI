package utils;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Persona {

    String nombre, apellidos;
    int edad;
    boolean disponibilidad;

    SimpleStringProperty propNombre, propApellido;
    SimpleIntegerProperty propEdad;
    SimpleBooleanProperty propDisponibilidad;
    String estado;


    public String getEstado() {
        return estado;
    }

    public Persona(String nombre, String apellidos, int edad, boolean disponibilidad) {
        this.nombre = nombre;
        propNombre = new SimpleStringProperty(nombre);
        this.apellidos = apellidos;
        propApellido = new SimpleStringProperty(apellidos);
        this.edad = edad;
        propEdad = new SimpleIntegerProperty(edad);
        this.disponibilidad = disponibilidad;
        propDisponibilidad = new SimpleBooleanProperty(disponibilidad);
    }

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getPropNombre() {
        return propNombre.get();
    }

    public SimpleStringProperty propNombreProperty() {
        return propNombre;
    }

    public String getPropApellido() {
        return propApellido.get();
    }

    public SimpleStringProperty propApellidoProperty() {
        return propApellido;
    }

    public int getPropEdad() {
        return propEdad.get();
    }

    public SimpleIntegerProperty propEdadProperty() {
        return propEdad;
    }

    public boolean isPropDisponibilidad() {
        return propDisponibilidad.get();
    }

    public SimpleBooleanProperty propDisponibilidadProperty() {
        return propDisponibilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }
}
