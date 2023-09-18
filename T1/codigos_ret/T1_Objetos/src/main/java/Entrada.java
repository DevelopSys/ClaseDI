import model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        listaUsuarios.add(new Usuario(1,"Borja1","Martin1",123,"123A"));
        listaUsuarios.add(new Usuario(2,"Borja2","Martin2",123,"123A"));
        listaUsuarios.add(new Usuario(3,"Borja3","Martin3",123,"123A"));
        listaUsuarios.add(new Usuario(4,"Borja4","Martin4",123,"123A"));

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
