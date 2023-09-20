import model.Agenda;
import model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {


        //ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        // menu con las opciones

        int id = 0;
        int opcion = 0;
        String nombre;
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();


        do {

            System.out.println("1. Agregar usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Modificar usuario");
            System.out.println("4. Borrar usuario");
            System.out.println("5. Listar usuario");
            System.out.println("6. Salir");
            System.out.println("Selecciona una opcion");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Agregando usuarios...");
                    System.out.println("Por favor introduce id");
                    id = scanner.nextInt();
                    System.out.println("Por favor introduce nombre");
                    nombre = scanner.next();
                    System.out.println("Por favor introduce apellido");
                    String apellido = scanner.next();
                    System.out.println("Por favor introduce telefono");
                    int telefono = scanner.nextInt();
                    System.out.println("Por favor introduce dni");
                    String dni = scanner.next();
                    Usuario usuario = new Usuario(id, nombre, apellido, telefono, dni);
                    if (agenda.agregarUsuario(usuario)) {
                        System.out.println("Usuario agregado con existo");
                    } else {
                        System.out.println("Fallo al agregar");
                    }
                    // he agregado el usuario?
                    break;
                case 2:
                    System.out.println("Buscando usuarios...");
                    System.out.println("Por favor introduce id");
                    id = scanner.nextInt();
                    if (!agenda.verDetalleUsuario(id)) {
                        System.out.println("El id no existe en la agenda");
                    }
                    // pide un id, y mustra sus detalles
                    break;
                case 3:
                    System.out.println("Modificando usuarios...");
                    System.out.println("Por favor introduce id");
                    id = scanner.nextInt();
                    System.out.println("Indica que quieres modificar");
                    System.out.println("1. Nombre");
                    System.out.println("2. Apellido");
                    System.out.println("3. DNI");
                    System.out.println("4. Telefono");
                    System.out.println("Indica que quieres modificar");
                    int opcionSubmenu = scanner.nextInt();
                    switch (opcionSubmenu) {
                        case 1:
                            System.out.println("Por favor introduce nombre nuevo");
                            nombre = scanner.next();
                            agenda.modificarUsuario(id, "nombre", nombre);
                            break;
                        case 2:
                            System.out.println("Por favor introduce apellido nuevo");
                            apellido = scanner.next();
                            agenda.modificarUsuario(id, "apellido", apellido);
                            break;
                        case 3:
                            System.out.println("Por favor introduce dni nuevo");
                            dni = scanner.next();
                            agenda.modificarUsuario(id, "dni", dni);
                            break;
                        case 4:
                            System.out.println("Por favor introduce telefono nuevo");
                            telefono = scanner.nextInt();
                            agenda.modificarUsuario(id, "telefono", telefono);

                            break;
                    }

                    break;
                case 4:
                    System.out.println("Borrando usuarios...");
                    System.out.println("Por favor introduce id");
                    id = scanner.nextInt();
                    if (agenda.borrarUsuario(id)) {
                        System.out.println("Borrado correctamente");
                    } else {
                        System.out.println("Fallo al borrar");
                    }
                    break;
                case 5:
                    System.out.println("Listando usuarios...");
                    if (!agenda.listarUsuarios()) {
                        System.out.println("No hay usuarios dentro de la lista");
                    }
                    break;
            }


        } while (opcion != 6);

        /*

        // TODO agregar 5 usuarios -> ok
        Scanner scanner = new Scanner(System.in);
        while (listaUsuarios.size()<5){
            // TODO pedir datos -> ok
            System.out.println("Por favor introduce id");
            int id  = scanner.nextInt();
            System.out.println("Por favor introduce nombre");
            String nombre  = scanner.next();
            System.out.println("Por favor introduce apellido");
            String apellido = scanner.next();
            System.out.println("Por favor introduce telefono");
            int telefono = scanner.nextInt();
            System.out.println("Por favor introduce dni");
            String dni = scanner.next();
            // TODO comprobar que el usuario no existe -> OK
            boolean existe = false;
            for ( Usuario item : listaUsuarios ) {
                if (item.getId() == id){
                    existe = true;
                    break;
                }
            }

            // TODO agregar usuario -> ok
            if (!existe){
                // no existe
                listaUsuarios.add(new Usuario(id, nombre, apellido,telefono, dni));
                System.out.println("Usuario agregado con existo");
                System.out.println("Usuarios en la lista "+listaUsuarios.size());
            } else {
                // existe
                System.out.println("ID repetido");
            }


        }


        // TODO listar datos usuarios -> OK
        int contador=1;
        for (Usuario item: listaUsuarios) {
            System.out.println("El usuario con ID: "+item.getId());
            System.out.println("El usuario "+contador);
            item.mostrarDatos();
            contador++;
        }

        /*listaUsuarios.add(new Usuario(1,"Borja1","Martin1",123,"123A"));
        listaUsuarios.add(new Usuario(2,"Borja2","Martin2",123,"123A"));
        listaUsuarios.add(new Usuario(3,"Borja3","Martin3",123,"123A"));
        listaUsuarios.add(new Usuario(4,"Borja4","Martin4",123,"123A"));*/
        // agregar de forma iterativa 5 usuarios
        // para ello se piden los datos por teclado: id, nom, ape
        // telf, dni
        // * si intento add un usuario que ya existe (id)
        // salta un error y no agregar el usuario
        // una vez agregados todos, mostrar por consola todos sus datos
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor introduce nombre");
        String nombre  = scanner.next();
        System.out.println("Por favor introduce apellido");
        String apellido = scanner.next();
        System.out.println("Por favor introduce telefono");
        int telefono = scanner.nextInt();
        System.out.println("Por favor introduce dni");
        String dni = scanner.next();
        Usuario usuario = new Usuario(1,nombre,apellido,telefono,dni);
        usuario.mostrarDatos();
        System.out.println(usuario);
        // Los datos del usuarios son:
        // nombre:
        // apellido:
        // telefono:
        // dni:*/

    }
}
