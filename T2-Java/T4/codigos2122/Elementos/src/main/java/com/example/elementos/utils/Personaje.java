package com.example.elementos.utils;

public class Personaje {


    private String nombre, poder;
    private int ataque, defensa, concetracion;

    public Personaje(String nombre, String poder, int ataque, int defensa, int concetracion) {
        this.nombre = nombre;
        this.poder = poder;
        this.ataque = ataque;
        this.defensa = defensa;
        this.concetracion = concetracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getConcetracion() {
        return concetracion;
    }

    public void setConcetracion(int concetracion) {
        this.concetracion = concetracion;
    }
}
