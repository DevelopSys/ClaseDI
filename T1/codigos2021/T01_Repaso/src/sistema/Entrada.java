package sistema;

import java.util.Hashtable;
import java.util.Scanner;

public class Entrada {

    // Hashtable <clave,valor> nombre
    /*
    * añadir; put(clave, valor) --> Me da un booleano si lo añade
    * buscar: contains(clave) --> Me da un booleano si existe
    * obtener: get(clave) --> Me da el valor asociado
    * borrar: remove(clave) --> Borra el elemento cuya clave es la pasada
    * recorrer: lista.keys() --> Enumeration a recorrer con un while
    * recorrer: lista.values() --> Collection a recorrer con un foreach
    * modificar: remove(clave) y put(clave, nuevoValor) --> modifica el elemento cuya clave se indica con el nuevo valor
    *
    * 1. Registrar usuario
      2. Buscar usuario
      3. Listar usuario
      4. Resetear contraseña
      5. Acceder al sistema
      6. Salir
    *
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = new Sistema();
        int opcion;
        String nombre, pass;


        do {
            System.out.println("1. Registro");
            System.out.println("2. Buscar");
            System.out.println("3. Listar");
            System.out.println("4. Reseteo");
            System.out.println("5. Login");
            System.out.println("6. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Registrar");
                    System.out.println("Introduce nombre");
                    nombre = sc.next();
                    System.out.println("Introduce password");
                    pass = sc.next();
                    Persona persona = new Persona(nombre,pass);
                    sistema.registrarUsuario(persona);
                    break;
                case 2:
                    System.out.println("Buscar");
                    System.out.println("Introduce el nombre a buscar");
                    nombre = sc.next();
                    sistema.buscarUsuario(nombre);
                    break;
                case 3:
                    System.out.println("Listar");
                    sistema.listarUsuarios();
                    break;
                case 4:
                    String passNueva;
                    System.out.println("Resetear");
                    System.out.println("Introduce nombre usuario");
                    nombre = sc.next();
                    System.out.println("Introduce pass antigua");
                    pass = sc.next();
                    System.out.println("Introduce pass nueva");
                    passNueva = sc.next();
                    break;
                case 5:
                    System.out.println("Login");
                    System.out.println("Introduce nombre usuario");
                    nombre = sc.next();
                    System.out.println("Introduce pass antigua");
                    pass = sc.next();
                    sistema.logear(new Persona(nombre,pass));
                    break;
                default:
                    System.out.println("No contemplada");
            }

        } while (opcion != 6);

    }
}
