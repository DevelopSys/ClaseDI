import model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

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
