package arrays;

import java.util.Random;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // pedir al usuario la cantidad de nuemeros que quiereo guardar 20
        System.out.println("Cuantos nº quieres generar");
        int cantidad = scanner.nextInt();
        //  pedir al usuario rango inicial y final de los aleatorios (10 - 50)
        System.out.println("Cual es el nº minimo a generar");
        int min = scanner.nextInt();
        System.out.println("Cual es el nº maximo a generar");
        int max = scanner.nextInt();
        // un array donde tengo n 0s
        int rango = max-min;
        // generar tantos aleatorios como se haya indicado
        int[] numeros = new int[cantidad];

        // guardo los datos
        for (int i = 0; i < cantidad; i++) {
            // i = 0
            // 30 - 80 -> 50
            //
            int aleatorio = (int) (Math.random()*(rango+1))+min;
            numeros[i] = aleatorio;
        }

        // comprobar cuantos de los guardados son par
        // impar , positivos , negativos, suma, media
        int suma = 0,numPositivos=0, numPares=0, numNegativos=0;
        for ( int item  : numeros ){
            if (item%2==0) numPares++;
            if (item<=0) {
                numNegativos++;
            } else{
                numPositivos++;
            }
            suma+=item;
        }

        System.out.println("La suma de los numeros es: "+suma);
        System.out.println("La cantidad de negativos es: "+numNegativos);
        System.out.println("La cantidad de positivos es: "+numPositivos);
        System.out.println("La media es: "+(double)suma/numeros.length);

        // EL SORTEO DE LA CHAMPION
        // generar el sorteo de champion
        // crear dos arrays de string con los nombre de 8 equipos
        // hacer el sorteo, imprimiendo cada uno de los empaarejamientos
        // UN EQUIPO NO PUEDE JUGAR DOS PARTIDOS
        // barcelona - monaco
        // liverpool - barcelona

        String[] bombo1 = {"madrid","barcelona","atleti","milan","city", "borusia"};
        String[] bombo2 = {"monaco","red bull","inter","manchester","bayern", "psg"};
        // array adicional

        System.out.printf("%s vs %s%n",bombo2[1],bombo1[2]);
        System.out.printf("%s vs %s%n",bombo2[1],bombo1[2]);
    }
}
