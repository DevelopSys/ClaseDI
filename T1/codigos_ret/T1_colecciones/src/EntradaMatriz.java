public class EntradaMatriz {

    public static void main(String[] args) {
        //int[][] numerosMatriz = new int[3][3];
        int[][] numerosMatriz = new int[][]{{1, 2, 3, 4}
                , {5, 6, 7, 8}
                , {9, 10, 11, 12}};
        for ( int[] items : numerosMatriz ) {
            for ( int item: items ) {
                System.out.println(item);
            }
        }

        for (int i = 0; i < numerosMatriz.length; i++) {
            for (int j = 0; j < numerosMatriz[i].length; j++) {
                System.out.print(numerosMatriz[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println(numerosMatriz[2][2]);

        // mostrar todos los numeros por consola

    }
}
