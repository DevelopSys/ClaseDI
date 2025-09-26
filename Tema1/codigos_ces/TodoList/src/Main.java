import model.*;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        /*Tarea tarea = new Tarea("Practica DI",
                "Esta practica de DI es hacer un programa todolist",
                true,
                2);*/
        // tarea.asignarResponsable(new Persona("123A","Nombre1","Apellido1",23));
        // tarea.asignarResponsable(new Persona("123A","Nombre1","Apellido1",23));
        // tarea.asignarResponsable(new Persona("123A","Nombre1","Apellido1",23));
        /*tarea.agregarEncargo(new Encargo(1,"Planificar la entrega"));
        tarea.agregarEncargo(new Encargo(2,"Codiicar la practica"));
        tarea.agregarEncargo(new Encargo(3,"Grabar video"));
        tarea.agregarEncargo(new Encargo(4,"Entregar practica"));
        tarea.completarEncargo(1);
        tarea.completarEncargo(2);
        tarea.completarEncargo(3);
        tarea.completarEncargo(4);*/
        // tarea.listarEncargos();
        //tarea.completarTarea();
        // tarea.buscarEncargoId(9);
        // tarea.listarEncargosCompletados();

        TareaProfesional tareaProfesional = new TareaProfesional("TareaP1",
                "descripcion", true,
                5, 100000, new Date());
        tareaProfesional.asignarResponsable(new Persona("123A", "Borja", "Martin", 12));
        tareaProfesional.asignarResponsable(new Persona("123B", "Juan", "Martin", 12));
        tareaProfesional.agregarEncargo(new Encargo(1,"ejemplo"));
        tareaProfesional.agregarEncargo(new Encargo(2,"ejemplo"));
        tareaProfesional.agregarEncargo(new Encargo(3,"ejemplo"));
        tareaProfesional.agregarEncargo(new Encargo(4,"ejemplo"));
        TareaPersonal tareaPersonal = new TareaPersonal("TareaPe2", "descripcion", 2,
                "Alcorcon");

        ArrayList<Tarea> tareas = new ArrayList<>();
        tareas.add(tareaPersonal);
        tareas.add(tareaProfesional);
        for (Tarea tarea1 : tareas) {
            tarea1.enviarRecordatorio();
        }
    }
}
