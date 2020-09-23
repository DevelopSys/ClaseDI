import java.util.Arrays;
import java.util.Scanner;

public class ArrayOrdenado {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] numeros = new int[50];
        Integer[] numerosObj = new Integer[50];
        int opcionSeleccionada = 0;

        do {

            System.out.println("1.Rellenar");
            System.out.println("2.Listar");
            System.out.println("3.Ordenar");
            System.out.println("4.Vaciar");
            System.out.println("5.Salir");
            System.out.printf("Introduce opción");
            opcionSeleccionada = teclado.nextInt();
            teclado.nextLine();

            switch (opcionSeleccionada) {
                case 1:
                    int suma = 0;
                    System.out.println("Opción añadir");
                    for (int item: numeros){
                        suma = suma + item;
                    }

                    if (suma>0){
                        System.out.printf("El aray esta ya relleno");
                    }
                    else {
                        for (int i = 0; i < 50; i++) {
                            numeros[i] = (int) (Math.random() * 200) + 1;
                        }

                    }

                    break;
                case 2:
                    int con=1;
                    System.out.println("Opción listar");
                    for (int item: numeros) {
                        System.out.printf("Elemento %d:%d \n",con,item);
                        con++;
                    }
                    break;
                case 3:
                    System.out.println("Opción ordenar");
                    Arrays.sort(numeros);
                    break;
                case 4:
                    System.out.println("Opción vaciar");
                    numeros = new int[50];
                    //numeros = null;
                    break;
                default:
                    break;
            }


        } while (opcionSeleccionada != 5);

        System.out.printf("Saliendo");
    }

}
