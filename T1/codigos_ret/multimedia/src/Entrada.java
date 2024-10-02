import model.*;

import java.util.ArrayList;

public class Entrada {

    // cista -> consola

    public static void main(String[] args) {
        //Multimedia multimedia = new Multimedia();

        Libro libro = new Libro(1, "Libro1", "AutorLibro", 100, "papel", "1234A", 100);
        Audio audio = new Audio(2, "Audio1", "AutorAudio", 100, "LP", 150, "mp3");
        ArrayList<Persona> actores = new ArrayList<>();
        actores.add(new Persona("Actor1", "Apellido1"));
        actores.add(new Persona("Actor2", "Apellido1"));
        actores.add(new Persona("Actor3", "Apellido1"));
        actores.add(new Persona("Actor4", "Apellido1"));
        Video video = new Video(1, "Video1", "AutorVideo", 100,
                "LP", new Persona("Director", "ADirector"), actores);
        // video.mostrarDatos();
        ArrayList<Multimedia> listadoBiblioteca = new ArrayList<>();
        listadoBiblioteca.add(libro);
        listadoBiblioteca.add(libro);
        listadoBiblioteca.add(libro);
        listadoBiblioteca.add(libro);
        listadoBiblioteca.add(libro);
        listadoBiblioteca.add(audio);
        listadoBiblioteca.add(video);

        for ( Multimedia item: listadoBiblioteca ) {
            if (item instanceof Audio && item instanceof Multimedia){
                System.out.println(" La calificacion del elemento es "+item.calificar());
            }
        }


    }
}
