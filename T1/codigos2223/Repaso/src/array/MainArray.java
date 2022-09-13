package array;

import java.util.Arrays;
import java.util.Scanner;

public class MainArray {

    /*
     * Agregar al menú las siguientes opciones:
     * - Buscar un elemento: pedir al usuairo un elemento a buscar
     *  y mostrar la posición en la que se enciuentra (el primero que se encuentre)
     * - Sustituir elemento: pedirá el elemento que quieres sustituir y por el número que
     *   quieres sustituir (todos)
     * - Calcular max y min
     * - Quitar errores de array no relleno
     * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = null; // 0
        int opcion = 0;
        int posicion = 0;

        do {
            System.out.println("1. Rellenar array");
            System.out.println("2. Listar array");
            System.out.println("3. Ordenar array");
            System.out.println("4. Vaciar array");
            System.out.println("5. Rellenar array");
            System.out.println("6. Max / Min");
            System.out.println("7. Busqueda");
            System.out.println("8. Sustitución");
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
                    if (new MainArray().isVacioArray(numeros)) {
                        System.out.println("Array nulo, no se puede ejecutar");
                    } else {
                        for (int i = 0; i < numeros.length; i++) {
                            System.out.printf("Elemento %d: %d%n", i + 1, numeros[i]);
                        }
                        System.out.println("Listado finalizado");
                    }
                    break;
                case 3:
                    if (new MainArray().isVacioArray(numeros)) {
                        System.out.println("Array es nulo, no se puede ejecutar");
                    } else {
                        Arrays.sort(numeros);
                        System.out.println("Ordenación completa");
                    }

                    break;
                case 4:
                    numeros = null;
                    System.out.println("Vaciado completo");
                    break;
                case 5:
                    System.out.println("Finalizando ejercicio");
                    break;
                case 6:
                    //int max = -1, min = 201;
                    if (new MainArray().isVacioArray(numeros)) {
                        System.out.println("Array vacio");
                    } else {
                        /*for (int i = 0; i < numeros.length; i++) {
                            if (numeros[i] > max) {
                                max = numeros[i];
                            }
                            if (numeros[i] < min) {
                                min = numeros[i];
                            }
                        }
                        System.out.println("Maximo "+max);
                        System.out.println("Minimo "+min);*/
                        int[] cloneNumeros = numeros.clone();
                        Arrays.sort(cloneNumeros);
                        int max = cloneNumeros[cloneNumeros.length - 1];
                        int min = cloneNumeros[0];
                        System.out.println("Max " + max);
                        System.out.println("Min " + min);

                    }

                    break;
                case 7:

                    if (new MainArray().isVacioArray(numeros)) {
                        System.out.println("El array está vacío");
                    } else {
                        System.out.println("Que número quieres buscar");
                        int numeroBusqueda = scanner.nextInt();
                        /*for (int i = 0; i < numeros.length; i++) {
                            if (numeros[i] == numeroBusqueda){
                                System.out.println("Numero encontrado en la posición "+i+1);
                                break;
                            }
                        }*/
                        posicion = 1;
                        for (int item : numeros) {
                            if (item == numeroBusqueda) {
                                System.out.println("Número encontrado en la posición " + posicion);
                                break;
                            }
                            posicion++;
                        }

                    }
                    break;
                case 8:
                    int numeroBusqueda, numeroSustituir, numerosSustituidos = 0;
                    if (new MainArray().isVacioArray(numeros)) {

                        System.out.println("Array vacio");
                    } else {
                        System.out.println("Que número quieres buscar");
                        numeroBusqueda = scanner.nextInt();
                        System.out.println("Por que número quieres sustituir");
                        numeroSustituir = scanner.nextInt();

                        for (int i = 0; i < numeros.length; i++) {
                            if (numeros[i] == numeroBusqueda) {
                                numeros[i] = numeroSustituir;
                                numerosSustituidos++;
                            }
                        }
                        if (numerosSustituidos > 0) {
                            System.out.println("Numeros sustituidos: " + numerosSustituidos);
                        } else {
                            System.out.println("No se han encontrado numeros");
                        }

                    }
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

    public void recorrerArray(int[] numeros, boolean sustituir) {
        for (int i = 0; i < numeros.length; i++) {

        }
    }

    public boolean isVacioArray(int[] arrayNumeros) {
        // si el array que pasa es nulo se retorna true
        // si el array que pasa no es nulo se retorna false
        return arrayNumeros == null;
    }
}
