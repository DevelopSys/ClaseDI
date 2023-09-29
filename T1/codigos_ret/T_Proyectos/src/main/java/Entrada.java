import controller.CicloController;
import model.Alumno;
import model.Profesor;
import model.Proyecto;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        CicloController controller = new CicloController();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("1- Agregar al");
            System.out.println("2- Agregar pr");
            System.out.println("3- Agregar proy");
            System.out.println("4- Listar proye");
            System.out.println("5- Exportar");
            System.out.println("Indica eleccion");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    Alumno alumno = new Alumno("Borja", "Martin", "123A");
                    controller.addAlumno(alumno);
                    break;
                case 2:
                    Profesor profesor = new Profesor("Borja", "Martin", "123A", "Programacion");
                    controller.addProfesor(profesor);
                    break;
                case 3:
                    System.out.println("Dime el titulo del proyecto");
                    String titulo = scanner.next();
                    System.out.println("Dime la descripcion del proyecto");
                    String descripcion = scanner.next();
                    System.out.println("Dime el contenido del proyecto");
                    String contenido = scanner.next();
                    Profesor profesor1 = null;
                    do {
                        System.out.println("Dime el profesor del responsable del proyecto");
                        String dni = scanner.next();
                        profesor1 = controller.existeProfesor(dni);
                    } while (profesor1 == null);

                    String continuar = "";
                    Proyecto proyecto = new Proyecto(titulo, descripcion, contenido, profesor1);
                    int integrantes = 0;
                    do {
                        Alumno alumno1 = null;
                        do {
                            System.out.println("Dime dni del participante");
                            String dniParticipante = scanner.next();
                            alumno1 = controller.existeAlumno(dniParticipante);
                        } while (alumno1 == null);
                        proyecto.getListaParticipantes().add(alumno1);
                        integrantes++;
                        System.out.println("Quieres meter mas participantes (S/N)");
                        continuar = scanner.next();

                    } while (continuar.equalsIgnoreCase("s") || integrantes < 3);

                    break;
                case 4:
                    controller.listarProyectos();
                    break;
                case 5:
                    controller.exportarDatos();
                    break;
            }

        } while (opcion != 6);

    }
}
