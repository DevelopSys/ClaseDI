package clases;

import javax.sound.midi.Soundbank;
import java.util.Hashtable;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {


        /*
         * 1. Regsitrar coche
         * 2. Desregistrar coche
         * 3. Listar registrados
         * 4. Meter coche en garaje
         * 5. Sacar coche del garaje
         * 6. Trabajar con coches
         * 6.1 Acelerar coche
         * 6.2 Decelerar coche
         * 7. Salir
         */

        Scanner teclado = new Scanner(System.in);
        //Hashtable<String,Coche> garaje = new Hashtable();
        Garaje garaje = new Garaje();
        int opcion = 0;
        do {
            System.out.println("1. Registrar coche");
            System.out.println("2. Desregistrar coche");
            System.out.println("3. Listar coches");
            System.out.println("4. Meter coche");
            System.out.println("5. Sacar coche");
            System.out.println("6. Trabajar con coches");
            System.out.println("Introduce opción a trabajar:");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    String matricula, marca, modelo;
                    int cv, bastidor;
                    System.out.println("Qué matricula?");
                    matricula = teclado.next();
                    if (!garaje.estaCoche(matricula)) {
                        // Solo lo pido si no está el coche
                        System.out.println("Qué marca?");
                        marca = teclado.next();
                        System.out.println("Qué modelo?");
                        modelo = teclado.next();
                        System.out.println("Qué bastidor?");
                        bastidor = teclado.nextInt();
                        System.out.println("Cuantos cv?");
                        cv = teclado.nextInt();
                        Coche coche = new Coche(matricula, marca, modelo, cv, bastidor);
                        garaje.agregarCoche(coche);
                    } else {
                        System.out.println("No puedo porque existe");
                    }
                    // Solo lo pido si no está el coche
                    break;
                case 2:
                    String matriculaEliminar;
                    System.out.println("Introduce la matrícula del coche que quiere eliminar");
                    matriculaEliminar = teclado.next();
                    if (!garaje.estaCoche(matriculaEliminar)) {
                        System.out.println("No se puede eliminar porque no existe");
                    } else {
                        garaje.eliminarCoche(matriculaEliminar);
                    }
                    break;

                case 3:
                    if (!garaje.getListadoCoches().isEmpty()) {
                        garaje.listarCoches();

                    } else {
                        System.out.println("El garaje está vació");
                    }
                    break;

                case 4:
                    System.out.println("Que coche quieres aparcar");
                    String matriculaAparcar = teclado.next();
                    if (garaje.estaCoche(matriculaAparcar) && !garaje.getListadoCoches().get(matriculaAparcar).isAparcado()
                    && garaje.getListadoCoches().get(matriculaAparcar).getVelocidad()==0) {
                        garaje.aparcarCoche(matriculaAparcar);
                    } else if (garaje.estaCoche(matriculaAparcar)) {
                        System.out.println("El coche ya está dentro");
                    } else {
                        System.out.println("El coche no está registrado");
                    }
                    break;
                case 5:
                    System.out.println("Que coche quieres sacar");
                    String matriculaSacar = teclado.next();
                    if (garaje.estaCoche(matriculaSacar) && garaje.getListadoCoches().get(matriculaSacar).isAparcado()) {
                        garaje.sacarCoche(matriculaSacar);
                    } else if (garaje.estaCoche(matriculaSacar)) {
                        System.out.println("El coche ya está fuera");
                    } else {
                        System.out.println("El coche no está registrado");
                    }
                    break;
                case 6:

                    int opcionCoche;
                    int velocidad;
                    Coche cocheEncontrado;
                    String matriculaTrabajar;
                    System.out.println("Menú de trabajo con coches");
                    System.out.println("1 Acelerar coche");
                    System.out.println("2 Decelerar coche");
                    System.out.println("3 Listar coches aparcados");
                    System.out.println("4 Listar coches fuera");

                    System.out.println("Introduce una opción:");
                    opcionCoche = teclado.nextInt();
                    switch (opcionCoche) {
                        case 1:
                            System.out.println("Introduce la matrícula del coche");
                            matriculaTrabajar = teclado.next();
                            cocheEncontrado = garaje.getListadoCoches().get(matriculaTrabajar);
                            if (cocheEncontrado != null && !cocheEncontrado.isAparcado()) {
                                System.out.println("Qué velocidad quieres acelerar");
                                velocidad = teclado.nextInt();
                                cocheEncontrado.acelerar(velocidad);
                            } else System.out.println("No se ha podido acelerar");
                            break;
                        case 2:
                            System.out.println("Introduce la matrícula del coche");
                            matriculaTrabajar = teclado.next();
                            cocheEncontrado = garaje.getListadoCoches().get(matriculaTrabajar);
                            if (cocheEncontrado != null && !cocheEncontrado.isAparcado()) {
                                System.out.println("Qué velocidad quieres acelerar");
                                velocidad = teclado.nextInt();
                                if (cocheEncontrado.getVelocidad() > velocidad) {
                                    cocheEncontrado.decelerar(velocidad);
                                } else {
                                    cocheEncontrado.setVelocidad(0);
                                }
                            }
                            break;
                        case 3:
                            garaje.listarAparcados(true);
                            break;
                        case 4:
                            garaje.listarAparcados(false);
                            break;
                        default:
                            System.out.println("Te has confundido");
                            break;
                    }
                    break;
                case 7:
                    System.out.println("Salir");
                    break;
                default:
                    break;
            }


        }
        while (opcion != 7);


    }
}
