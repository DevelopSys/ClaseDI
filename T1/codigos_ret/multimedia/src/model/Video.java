package model;

import java.util.ArrayList;

public class Video extends Multimedia{

    private Persona director;
    private ArrayList<Persona> actores;

    public Video(int id, String titulo, String autor, int tamanio, String formato, Persona director, ArrayList<Persona> actores) {
        super(id, titulo, autor, tamanio, formato);
        this.director = director;
        this.actores = actores;
    }


    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        director.mostrarDatos();
        System.out.println("Los actores son");
        for (Persona persona: actores ) {
            persona.mostrarDatos();
        }
    }

    @Override
    public int calificar() {
        return 0;
    }

    public Persona getDirector() {
        return director;
    }

    public void setDirector(Persona director) {
        this.director = director;
    }

    public ArrayList<Persona> getActores() {
        return actores;
    }

    public void setActores(ArrayList<Persona> actores) {
        this.actores = actores;
    }
}
