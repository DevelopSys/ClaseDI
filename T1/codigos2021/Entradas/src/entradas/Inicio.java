package entradas;

import java.util.Scanner;

public class Inicio {

    public static void main(String[] args) {
        VentaEntradas ventaEntradas = new VentaEntradas();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;


        do {

            System.out.println("1. Mostrar entradas");
            System.out.println("2. Vender entrada");
            System.out.println("3. Salir");
            System.out.println("Introduce la opción (1-3)");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // TODO Mostrar entradas
                    System.out.printf("El número de entradas disponibles es: %d%n",ventaEntradas.getNumeroEntradas());
                    System.out.printf("El número de entradas generales es: %d%n",ventaEntradas.getEntradasGenerales());
                    System.out.printf("El número de entradas compra-venta es: %d%n",ventaEntradas.getEntradasComVen());
                    System.out.printf("El número de entradas vip es: %d%n",ventaEntradas.getEntradasVip());
                    break;
                case 2:
                    // TODO Vender entradas;
                    int tipo, cantidad;
                    System.out.println("Que tipo de entrada quieres (1General ,2C-V ó 3VIP");
                    tipo = scanner.nextInt();
                    System.out.println("Cuantas entradas quieres");
                    cantidad = scanner.nextInt();
                    ventaEntradas.vendeEntrada(tipo,cantidad);
                    break;
                default:
                    System.out.println("opción no reconocida");
            }
        } while (opcion != 3);


    }
}
