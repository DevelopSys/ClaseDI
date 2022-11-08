package com.example.repaso_ret.model;

public class Equipo {

    private String nombre, image, campo;

    public Equipo(String nombre, String image, String campo) {
        this.nombre = nombre;
        this.image = image;
        this.campo = campo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
