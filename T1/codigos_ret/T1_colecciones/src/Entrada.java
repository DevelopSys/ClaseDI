import com.sun.tools.javac.Main;

import javax.swing.*;
import java.util.Scanner;

public class Entrada {

    public void correccionEjercicio(){
        Scanner lectura = new Scanner(System.in);
        int[] numeros;
        System.out.println("Cuantos numeros vas a generar");
        int numeroNumeros = lectura.nextInt();
        System.out.println("Cual es el número más grande a generar");
        int numeroFinal = lectura.nextInt();
        numeros = generarArray(numeroNumeros,numeroFinal);
        realizarCalculos(numeros);
    }

    public void realizarCalculos(int[] numerosParam){
        int nPares=0, nImpares=0, total=0;
        double media=0.0;
        for ( int item : numerosParam ) {
            if (item%2==0) {
                nPares++;
            } else {
                nImpares++;
            }
            total+=item;
        }
        media = (double) total/numerosParam.length;
        System.out.println("Numero pares "+nPares);
        System.out.println("Numero impares "+nImpares);
        System.out.println("Sumatorio "+total);
        System.out.println("Media "+media);
    }

    public int[] generarArray(int numeroNumeros, int numeroMax){
        int[] numeros = new int[numeroNumeros];
        for (int i = 0; i < numeroNumeros; i++) {
           // relleno el array
            numeros[i]=(int)(Math.random()*(numeroMax+1));
        }
        return numeros;
    }

    public static void main(String[] args) {


        new Entrada().correccionEjercicio();
        // el programa deberá pedir el numero de numeros que quiero generar
        // 20
        // el programa me pedirá el número más grande a generar
        // 70
        // generar 20 numeros entre el 0 y el 70 y guardarlos en un array
        // indicar cuandos son pares, son impares, el sumatorio y la media

        /*int[] numeros = new int[]{1,2,3,41,3123,14,123,123};
        //14
        // 50 - 100
        System.out.println((int)(Math.random()*51)+50);

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i]==14){
                System.out.println("Encontrado");
            }
        }
        // 0 0 0 0 0 0 0 0 0
        String[] palabras = new String[10];
        // null
        final Object[] cosas = new Object[]{"2",2,true,"hola"};
        cosas[0] = "2";
        System.out.println(cosas[3]);
        cosas[3] = 2;*/
    }
}
