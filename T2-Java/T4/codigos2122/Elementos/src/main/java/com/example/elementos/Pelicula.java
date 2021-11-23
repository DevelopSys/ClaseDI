package com.example.elementos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pelicula {

    private String titulo, imagen, descripcion, fecha, idioma;
    private StringProperty propTitulo, propFecha, propIdioma;
    private IntegerProperty propId;
    private int id;

    public Pelicula(String titulo, String imagen, int id, String descripcion) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.id = id;
        this.descripcion = descripcion;

    }

    public Pelicula (int id, String titulo, String fecha, String idioma){
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.idioma = idioma;
        propFecha = new SimpleStringProperty(fecha);
        propIdioma = new SimpleStringProperty(idioma);
        propTitulo = new SimpleStringProperty(titulo);
        propId = new SimpleIntegerProperty(id);
    }

    public String getPropTitulo() {
        return propTitulo.get();
    }

    public StringProperty propTituloProperty() {
        return propTitulo;
    }

    public void setPropTitulo(String propTitulo) {
        this.propTitulo.set(propTitulo);
    }

    public String getPropFecha() {
        return propFecha.get();
    }

    public StringProperty propFechaProperty() {
        return propFecha;
    }

    public void setPropFecha(String propFecha) {
        this.propFecha.set(propFecha);
    }

    public String getPropIdioma() {
        return propIdioma.get();
    }

    public StringProperty propIdiomaProperty() {
        return propIdioma;
    }

    public void setPropIdioma(String propIdioma) {
        this.propIdioma.set(propIdioma);
    }

    public int getPropId() {
        return propId.get();
    }

    public IntegerProperty propIdProperty() {
        return propId;
    }

    public void setPropId(int propId) {
        this.propId.set(propId);
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
