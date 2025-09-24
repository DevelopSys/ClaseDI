import model.Encargo;
import model.Persona;
import model.Tarea;

public class Main {

    public static void main(String[] args) {
        Tarea tarea = new Tarea("Practica DI",
                "Esta practica de DI es hacer un programa todolist",
                true,
                2);
        // tarea.asignarResponsable(new Persona("123A","Nombre1","Apellido1",23));
        // tarea.asignarResponsable(new Persona("123A","Nombre1","Apellido1",23));
        // tarea.asignarResponsable(new Persona("123A","Nombre1","Apellido1",23));
        tarea.agregarEncargo(new Encargo(1,"Planificar la entrega"));
        tarea.agregarEncargo(new Encargo(2,"Codiicar la practica"));
        tarea.agregarEncargo(new Encargo(3,"Grabar video"));
        tarea.agregarEncargo(new Encargo(4,"Entregar practica"));


        

    }
}
