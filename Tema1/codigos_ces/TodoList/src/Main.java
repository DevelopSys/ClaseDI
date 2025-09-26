import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
                5, 100000, new Date(2025, 9, 10));
        int dia = 2;
        int mes = 2;
        int anio = 2020;
        Date date = new Date(anio, mes, dia);
        System.out.println("Indica la fecha a introducir (dd/MM/yyyy)");
        String fecha = "20/02/2024";
        dia = Integer.parseInt(fecha.split("/")[0]);
        mes = Integer.parseInt(fecha.split("/")[1]);
        anio = Integer.parseInt(fecha.split("/")[2]);

        LocalDate localDate = LocalDate.of(2025, 4, 20);
        tareaProfesional.asignarResponsable(new Persona("123A", "Borja", "Martin", 12));
        tareaProfesional.asignarResponsable(new Persona("123B", "Juan", "Martin", 12));
        tareaProfesional.agregarEncargo(new Encargo(1, "ejemplo"));
        tareaProfesional.agregarEncargo(new Encargo(2, "ejemplo"));
        tareaProfesional.agregarEncargo(new Encargo(3, "ejemplo"));
        tareaProfesional.agregarEncargo(new Encargo(4, "ejemplo"));
        TareaPersonal tareaPersonal = new TareaPersonal("TareaPe2", "descripcion", 2,
                "Alcorcon");



        TareaGenerica tareaGenerica = new TareaGenerica("TareaPe2", "descripcion", 2,
                "Dato generico");



        ArrayList<Tarea> tareas = new ArrayList<>();
        tareas.add(tareaPersonal);
        tareas.add(tareaProfesional);
        tareas.add(tareaGenerica);
        for (Tarea tarea1 : tareas) {
            tarea1.enviarRecordatorio();
            // metodo 1 metodo 2 metodo 3
            if (tarea1 instanceof Tarea){
                ((FuncionalidadCompartida) tarea1).metodoComun1();
            }

        }
    }
}
