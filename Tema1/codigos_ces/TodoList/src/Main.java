import model.Persona;
import model.Tarea;

public class Main {

    public static void main(String[] args) {
        Tarea tarea = new Tarea("Practica DI",
                "Esta practica de DI es hacer un programa todolist",
                true,
                2);
        tarea.asignarResponsable(new Persona("123A","Nombre1","Apellido1",23));
        tarea.asignarResponsable(new Persona("123A","Nombre1","Apellido1",23));
        tarea.asignarResponsable(new Persona("123A","Nombre1","Apellido1",23));
        

    }
}
