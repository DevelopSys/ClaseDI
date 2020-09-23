package colecciones;

import java.util.ArrayList;

public class Entrada {

    public static void main(String[] args) {
        int[] numeros = new int[8];
        int[] numeroElementos = {1,2,3,4,5,6,7,8,9};
        numeros[0] = 1;
        int[][] matriz = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        matriz[0][1]= 4;

        /*for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }

        for (int i = 0; i < matriz.length; i++) {
            // recorre las filas
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println(matriz[i][j]);
            }
        }

        for (int item: numeros) {
            System.out.println(item);
        }*/

        /*for (int[] item :matriz) {
            //System.out.println(item);
            for (int itemFinal: item) {
                System.out.println(itemFinal);
            }
            System.out.println("Salto de linea");
        }*/

        // ArrayList - HashTable

        // ArrayList --> List
        ArrayList<String> listaPalabras = new ArrayList();
        // numeros de elementos
        System.out.println(listaPalabras.size());
        // añado elementos
        listaPalabras.add("Palabra1");
        listaPalabras.add("Palabra2");
        listaPalabras.add("Palabra3");
        listaPalabras.add("Palabra4");
        System.out.println(listaPalabras.size());
        listaPalabras.remove(1);
        System.out.println(listaPalabras.size());
        System.out.println(listaPalabras.get(1));

        for (String palabra: listaPalabras) {
            if (palabra.equals("Palabra3")){
                System.out.println("Encontado");
            }
        }










    }
}
