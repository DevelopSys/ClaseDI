package utils;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Usuario {

    //String nombre, apellido, correo;

    SimpleStringProperty nombre, apellido, correo;
    SimpleIntegerProperty telefono;

    public Usuario(String nombre, String apellido, String correo, int telefono) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.correo = new SimpleStringProperty(correo);
        this.telefono = new SimpleIntegerProperty(telefono);
    }

    public int getTelefono() {
        return telefono.get();
    }

    public SimpleIntegerProperty telefonoProperty() {
        return telefono;
    }

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public String getApellido() {
        return apellido.get();
    }

    public SimpleStringProperty apellidoProperty() {
        return apellido;
    }

    public String getCorreo() {
        return correo.get();
    }

    public SimpleStringProperty correoProperty() {
        return correo;
    }
}
