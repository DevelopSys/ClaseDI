package array;

import java.util.Arrays;
import java.util.Scanner;

public class MainArray {

    /*
    * Agregar al menú las siguientes opciones:
    * - Buscar un elemento: pedir al usuairo un elemento a buscar
    *  y mostrar la posición en la que se enciuentra (el primero que se encuentre)
    * - Sustituir elemento: pedira el elemento que quieres sustituir y por el numero que
    *   quieres sustituir (todos)
    * - Calcular max y min
    * - Quitar errores de array no relleno
    * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = null; // 0
        int opcion = 0;

        do {
            System.out.println("1. Rellenar array");
            System.out.println("2. Listar array");
            System.out.println("3. Ordenar array");
            System.out.println("4. Vaciar array");
            System.out.println("5. Rellenar array");
            System.out.println("Que opción quieres hacer");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    if (numeros != null) {
                        System.out.println("El array ya está relleno, ¿queres rellenarlo otra vez?");
                        String constestacion = scanner.next();
                        if (constestacion.equalsIgnoreCase("s")) {

                            // un array con 50 posiciones rellenas
                            numeros = new MainArray().rellenarArray();
                        }
                    } else {
                        // un array con 50 posiciones rellenas
                        numeros = new MainArray().rellenarArray();
                    }
                    break;
                case 2:
                    for (int i = 0; i < numeros.length; i++) {
                        System.out.printf("Elemento %d: %d%n",i+1,numeros[i]);
                    }
                    System.out.println("Listado finalizado");
                    break;
                case 3:
                    Arrays.sort(numeros);
                    System.out.println("Ordenación completa");
                    break;
                case 4:
                    numeros = null;
                    System.out.println("Vaciado completo");
                    break;
                case 5:
                    System.out.println("Finalizando ejercicio");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 5);
    }

    public int[] rellenarArray() {
        int[] numerosAux = new int[50];
        for (int i = 0; i < 50; i++) {
            numerosAux[i] = (int) (Math.random() * 201);
        }
        return numerosAux;
    }
}
