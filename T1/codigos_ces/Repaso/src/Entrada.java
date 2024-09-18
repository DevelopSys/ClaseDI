import controller.Gestor;
import model.Tarea;
import utils.Prioridad;

import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0, prioridad = 0, valor = 0, tipo = 0;
        String titulo, descripcion;
        Gestor gestor = new Gestor();

        do {

            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Borrar tareas");
            System.out.println("4. Modificar tarea");
            System.out.println("5. Salir");
            System.out.println("Que quieres hacer");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Vas a agregar una tarea");
                    System.out.println("Introduce el titulo de la tarea");
                    titulo = scanner.next();
                    System.out.println("Introduce el titulo de la descripcion");
                    descripcion = scanner.next();
                    System.out.println("Introduce la prioridad (1-baja 2-media 3-alta)");
                    prioridad = scanner.nextInt();
                    if (gestor.agragarTarea(new Tarea(titulo, descripcion, prioridad))) {
                        System.out.println("Tarea agregada correctamente");
                    } else {
                        System.out.println("Error al agregar");
                    }
                    break;
                case 2:
                    System.out.println("Indica que tipo de listado queres (0-todas, 1- prioridad, 2-completadas");
                    int opcionListado = scanner.nextInt();
                    int valorPrioridad=-1;
                    if (opcionListado ==1){
                        System.out.println("Dime el valor que quieres buscar 1-baja 2-media, 3-alta");
                        opcionListado = scanner.nextInt();
                    }
                    gestor.listarTareas(opcionListado,valorPrioridad);
                    break;
                case 3:
                    System.out.println("Indica el ID de la tarea que quieres borrar");
                    int idBorrado = scanner.nextInt();
                    Tarea tareaBorrada = gestor.borrarTarea(idBorrado);
                    if (tareaBorrada!=null){
                        System.out.printf("Tarea con titulo %s, borrada correctamente%n",tareaBorrada.getTitulo());
                    } else {
                        System.out.println("Error al borrar");
                    }

                    break;
                case 4:
                    System.out.println("Indica la nueva descripcion");
                    String descripcionModiicar = scanner.nextLine();
                    System.out.println("Indica el ID de la tarea que quieres moddicar");
                    int idMofidificar = scanner.nextInt();
                    gestor.actualizarTarea(idMofidificar,descripcionModiicar);
                    break;
            }

        } while (opcion != 5);


        /*ArrayList<Tarea> lista = new ArrayList<>();
        Tarea tarea = new Tarea("Titulo tarea 1", "descripcion tarea 1", 1);
        tarea.setId(1);
        lista.add(tarea);

        tarea = new Tarea("Titulo tarea 2", "descripcion tarea 2", 3);
        tarea.setId(2);
        lista.add(tarea);

        tarea = new Tarea("Titulo tarea 3", "descripcion tarea 2", 2);
        tarea.setId(3);
        lista.add(tarea);

        //Tarea tareaObtenida = lista.get(1);
        //System.out.println(tareaObtenida.getTitulo());
        //System.out.println(tareaObtenida.getPrioridad().getColor());*/
        /*for (Tarea item : lista){
            if (item.getPrioridad().getValor() == 1){
                System.out.println(item.getTitulo());
                // solo quero sacar la primera -> break
            }
        }*/


        // borrar todas las tareas que tienen prioridad baja

        /*for ( Tarea item : lista){
            if (item.getPrioridad().getValor() == 1){
                lista.remove(item);
            }
        }*/

        /*for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getPrioridad().getValor() == 1) {
                lista.remove(i);
            }
        }

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getPrioridad().getValor() == 1) {
                lista.get(i).setPrioridad(Prioridad.baja);
            }
        }*/


    }
}
