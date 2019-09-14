import java.util.Arrays;
import java.util.Scanner;

public class ArrayRelleno {

    public static void main(String[] args) {

        Scanner lecturaNumero;
        int opcion;
        int[] numeros = new int[50];


        do {

            System.out.println("1. Rellenar array");
            System.out.println("2. Listar array");
            System.out.println("3. Ordenar array");
            System.out.println("4. Vaciar array");
            System.out.println("5. Salir");
            System.out.println("Que deseas hacer?");
            lecturaNumero = new Scanner(System.in);
            opcion = lecturaNumero.nextInt();


            switch (opcion) {
                case 1:
                    System.out.println("Rellenando Array...");
                    int suma = 0;
                    for (int item : numeros) {
                        suma += item;
                    }

                    if (suma == 0) {
                        for (int i = 0; i < numeros.length; i++) {
                            numeros[i] = (int) (Math.random() * 200);
                        }
                    } else {
                        System.out.println("El array ya se ha rellenado, ¿quieres continuar?");
                        String continuar = new Scanner(System.in).next();
                        System.out.println(continuar);
                        if (continuar.toLowerCase().equals("s")){
                            for (int i = 0; i < numeros.length; i++) {
                                numeros[i] = (int) (Math.random() * 200);
                            }
                        }else {
                            System.out.println("Operación cancelada");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Listando Array...");
                    int contador = 1;
                    for (int item : numeros
                    ) {
                        System.out.printf("Elemento %d: %d \n", contador, item);
                        contador++;
                    }
                    break;
                case 3:
                    System.out.println("Ordenando Array...");
                    Arrays.sort(numeros);
                    break;
                case 4:
                    System.out.println("Vaciando Array...");
                    numeros = new int[50];
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Creo que te has confundido");
                    break;
            }

        } while (opcion != 5);


    }
}
