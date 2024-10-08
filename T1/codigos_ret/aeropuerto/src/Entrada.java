import controller.Aeropuerto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));
        // scanner.nextLine();
        Aeropuerto aeropuerto = new Aeropuerto();
        int opcion = scanner.nextInt();

        do {
            System.out.println("1. Agregar vuelo");
            System.out.println("2. Listar vehiculos");
            System.out.println("3. Buscar por avion");
            System.out.println("4. Cancelar vuelo");
            System.out.println("5. Listar todos los vuelos");
            System.out.println("6. Salir");
            System.out.println("Que quieres hacer");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    // aeropuerto.agregarVuelo();
                    break;
                case 2:
                    aeropuerto.listarVehiculos();
                    break;
                case 3:
                    aeropuerto.listarVuelosAvion("1234A");
                    break;
                case 4:
                    aeropuerto.cancelarVuelo(4);
                    break;
                case 5:
                    aeropuerto.listarVuelos();
                    break;
                case 6:
                    System.out.println("Saliendo");
                    break;
            }
        } while (opcion!=6);
    }

}
