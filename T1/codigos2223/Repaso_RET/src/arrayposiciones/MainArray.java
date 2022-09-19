package arrayposiciones;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class MainArray {

    public static void main(String[] args) {
        //int numero = (int) (Math.random() *200)+1;
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        int[] numeros = null;
        do {

            System.out.println("1. Rellenar");
            System.out.println("2. Listar");
            System.out.println("3. Ordenar");
            System.out.println("4. Vaciar");
            System.out.println("5. Buscar");
            System.out.println("6. Sustituir");
            System.out.println("7. Max y Min");
            System.out.println("8. Salir");
            System.out.println("Indica que quiere hacer");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (!new MainArray().isArrayVacio(numeros)) {
                        System.out.println("Quieres volver a rellenar");
                        String opcionRellenar = scanner.next();
                        if (opcionRellenar.equalsIgnoreCase("s")) {
                            numeros = new MainArray().rellenarArray();
                        } else {
                            System.out.println("Array relleno previamente");
                        }
                    } else {
                        numeros = new MainArray().rellenarArray();
                    }
                    break;
                case 2:
                    /*for (int i = 0; i < numeros.length; i++) {
                        System.out.printf("Elemento %d: %d%n",i+1,numeros[i]);
                    }*/
                    int posicion = 1;
                    for (int item : numeros) {
                        System.out.printf("Elemento %d: %d%n", posicion, item);
                        posicion++;
                    }
                    break;
                case 3:
                    Arrays.sort(numeros);
                    break;
                case 4:
                    numeros = null;
                    break;
                case 5:
                    if (numeros != null){
                        System.out.println("Que numero quieres busacr");
                        int numeroBuscar = scanner.nextInt();
                        boolean encontrado=false;
                        for (int i = 0; i < numeros.length; i++) {
                            if (numeroBuscar == numeros[i]){
                                System.out.println("Encontrado en la posicion "+i+1);
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado){
                            System.out.println("No se ha encontrado el nmero");
                        }

                    }
                    break;
                case 6:
                    int numeroBuscar, numeroSustituir;
                    System.out.println("Introduce el numero que quieres buscar");
                    numeroBuscar = scanner.nextInt();
                    System.out.println("Introduce el numero por el que quieres sustituir");
                    numeroSustituir = scanner.nextInt();

                    for (int i = 0; i < numeros.length; i++) {
                        if (numeroBuscar == numeros[i]){
                            numeros[i] = numeroSustituir;
                        }
                    }

                    break;
                case 7:
                    int[] clone = numeros.clone();
                    Arrays.sort(clone);
                    System.out.println("El max es "+clone[clone.length-1]);
                    System.out.println("El min es "+clone[0]);
                    clone = null;
                    break;
            }

            try {
                Thread.sleep(3000);
            } catch (Exception wertyuio) {
                throw new RuntimeException(wertyuio);
            }
        } while (opcion != 8);
    }

    public int[] rellenarArray() {
        int[] numeros = new int[50];
        for (int i = 0; i < 50; i++) {
            numeros[i] = (int) (Math.random() * 201);
        }
        return numeros;
    }
    public boolean isArrayVacio(int[] numerosComprobar){
        boolean isVacio = numerosComprobar == null;
        return isVacio;
    }
}
