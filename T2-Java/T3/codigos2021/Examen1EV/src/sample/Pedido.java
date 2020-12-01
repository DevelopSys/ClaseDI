package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Pedido {

    private String nombre, localidad, producto;
    private  int telefono, numero;
    private SimpleStringProperty nombreProp, localidadProp, productoProp;
    private SimpleIntegerProperty telefonoProp, numeroProp;

    public Pedido(String nombre, String localidad, String producto, int telefono, int numero) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.producto = producto;
        this.telefono = telefono;
        this.numero = numero;
        this.localidadProp = new SimpleStringProperty(localidad);
        this.nombreProp = new SimpleStringProperty(nombre);
        this.productoProp = new SimpleStringProperty(producto);
        this.numeroProp = new SimpleIntegerProperty(numero);
        this.telefonoProp = new SimpleIntegerProperty(telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombreProp() {
        return nombreProp.get();
    }

    public SimpleStringProperty nombrePropProperty() {
        return nombreProp;
    }

    public void setNombreProp(String nombreProp) {
        this.nombreProp.set(nombreProp);
    }

    public String getLocalidadProp() {
        return localidadProp.get();
    }

    public SimpleStringProperty localidadPropProperty() {
        return localidadProp;
    }

    public void setLocalidadProp(String localidadProp) {
        this.localidadProp.set(localidadProp);
    }

    public String getProductoProp() {
        return productoProp.get();
    }

    public SimpleStringProperty productoPropProperty() {
        return productoProp;
    }

    public void setProductoProp(String productoProp) {
        this.productoProp.set(productoProp);
    }

    public int getTelefonoProp() {
        return telefonoProp.get();
    }

    public SimpleIntegerProperty telefonoPropProperty() {
        return telefonoProp;
    }

    public void setTelefonoProp(int telefonoProp) {
        this.telefonoProp.set(telefonoProp);
    }

    public int getNumeroProp() {
        return numeroProp.get();
    }

    public SimpleIntegerProperty numeroPropProperty() {
        return numeroProp;
    }

    public void setNumeroProp(int numeroProp) {
        this.numeroProp.set(numeroProp);
    }
}
