package sample.utils;

import javafx.beans.InvalidationListener;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class PersonaTabla {

    String nombre, apellido;
    int edad;
    boolean disponibilidad;
    StringProperty nombrePropiedad, apellidoPropiedad;
    IntegerProperty edadPropiedad;
    BooleanProperty disponibilidadPropiedad;

    public PersonaTabla(String nombre, String apellido, int edad, boolean disponibilidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getNombrePropiedad() {
        return nombrePropiedad.get();
    }

    public StringProperty nombrePropiedadProperty() {
        return nombrePropiedad;
    }

    public void setNombrePropiedad(String nombrePropiedad) {
        this.nombrePropiedad.set(nombrePropiedad);
    }

    public String getApellidoPropiedad() {
        return apellidoPropiedad.get();
    }

    public StringProperty apellidoPropiedadProperty() {
        return apellidoPropiedad;
    }

    public void setApellidoPropiedad(String apellidoPropiedad) {
        this.apellidoPropiedad.set(apellidoPropiedad);
    }

    public int getEdadPropiedad() {
        return edadPropiedad.get();
    }

    public IntegerProperty edadPropiedadProperty() {
        return edadPropiedad;
    }

    public void setEdadPropiedad(int edadPropiedad) {
        this.edadPropiedad.set(edadPropiedad);
    }

    public boolean isDisponibilidadPropiedad() {
        return disponibilidadPropiedad.get();
    }

    public BooleanProperty disponibilidadPropiedadProperty() {
        return disponibilidadPropiedad;
    }

    public void setDisponibilidadPropiedad(boolean disponibilidadPropiedad) {
        this.disponibilidadPropiedad.set(disponibilidadPropiedad);
    }
}
