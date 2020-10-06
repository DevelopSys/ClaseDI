package colecciones_dos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        ArrayList<Double> temperaturas = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int opcion;
        Double temperatura;

        do {
            System.out.println("1. Agregar");
            System.out.println("2. Listar");
            System.out.println("3. Maximos");
            System.out.println("4. Vaciar");
            System.out.println("5. Salir");
            System.out.println("Opcion");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("introduce temperaturas");
                    temperatura = sc.nextDouble();
                    temperaturas.add(temperatura);
                    break;
                case 2:
                    System.out.println("Listar");
                    for (Double item :temperaturas) {
                        System.out.println("Temperatura: "+item);
                    }
                    break;
                case 3:
                    System.out.println("Máximos");
                    // ordena solo!!!!
                    Collections.sort(temperaturas);
                    System.out.println("El mínimo es: "+temperaturas.get(0));
                    System.out.println("El máximo es: "+temperaturas.get(temperaturas.size()-1));


                    break;
                case 4:
                    temperaturas.clear();
                    break;
            }
        } while (opcion != 5);


    }
}
