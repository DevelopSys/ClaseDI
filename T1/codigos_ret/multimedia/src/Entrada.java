import controller.Biblioteca;
import model.*;

import java.util.ArrayList;

public class Entrada {

    // cista -> consola

    public static void main(String[] args) {
        //Multimedia multimedia = new Multimedia();
        Biblioteca biblioteca = new Biblioteca();
        // []
        Libro libro = new Libro(1, "Libro1", "AutorLibro", 100, "papel", "1234A", 100);
        Audio audio = new Audio(2, "Audio1", "AutorAudio", 100, "LP", 150, "mp3");
        ArrayList<Persona> actores = new ArrayList<>();
        actores.add(new Persona("actor1","apellido1"));
        actores.add(new Persona("actor2","apellido1"));
        actores.add(new Persona("actor3","apellido1"));
        Video video1 = new Video(3, "Video1", "AutorVideo", 200, "LP", new Persona("Director","Apellidos"), actores);
        actores = new ArrayList<>();
        actores.add(new Persona("actor1","apellido1"));
        actores.add(new Persona("actor4","apellido1"));
        Video video2 = new Video(4, "Video2", "AutorVideo", 200, "LP", new Persona("Director","Apellidos"), actores);

        biblioteca.agregarElemento(libro);
        biblioteca.agregarElemento(audio);
        biblioteca.agregarElemento(video1);
        biblioteca.agregarElemento(video2);

        System.out.println("Busqueda por actor");
        biblioteca.listarActor("actor1");



    }
}
