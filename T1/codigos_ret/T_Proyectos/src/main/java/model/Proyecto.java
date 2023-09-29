package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Proyecto {

    String titulo, desc, contenido;
    ArrayList<Alumno> listaParticipantes;
    Profesor profesorResponsable;

    public Proyecto() {
        listaParticipantes = new ArrayList<>();
    }

    public Proyecto(String titulo, String desc, String contenido, Profesor profesorResponsable) {
        this.titulo = titulo;
        this.desc = desc;
        this.contenido = contenido;
        this.profesorResponsable = profesorResponsable;
        listaParticipantes = new ArrayList<>();
    }

    public void mostrarDatos() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Titulo: " + desc);
        System.out.println("Titulo: " + contenido);
        System.out.println("Profesor asociado: ");
        profesorResponsable.mostrarDatos();
        System.out.println("Participantes: ");

        for (Alumno item : listaParticipantes) {
            item.mostrarDatos();
        }
    }
}
