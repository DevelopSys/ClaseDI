import java.util.Scanner;

public class SentenciasControl {

    // variables
    // constructores -> ()
    // metodos

    // fun nombre():retorno{
    // }

    public void sentenciasCondicionales() {
        int nota = 10;
        char letra = 'A';
        String palabra = "asdasd";
        switch (letra) {
            case 1:
                break;
            case 4:
                break;
            case 8:
                break;
            default:
        }

    }

    public void sentenciasRepeticion() {
        int[] elementos = {1, 2, 3, 4, 5, 6, 7};
        int[][] elementosMulti = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        String[] palabras = {"asd", "qwe", "zxc"};
        Object[] cosas = {1, true, '2', "asdasd"};

        /*for (int i = 0; i < elementos.length; i++) {
            System.out.println(elementos[i]);
        }*/
        /*
        for (int numero : elementos) {
            System.out.println(numero);
            if (numero % 2 == 0) {
                break;
            }
        }*/

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Indica opcion a ejecutar");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("seleccionada opcion 1");
                    break;
                case 2:
                    System.out.println("seleccionada opcion 2");
                    break;
                case 3:
                    System.out.println("seleccionada opcion 3");
                    break;
                default:
                    System.out.println("Opcion no contemplada. Terminado programa");
                    break;
            }
        }while (opcion != 4);

    }

    public void tablasMultiplicar() {
        // tablas de multiplicar del 0 al 10
        // Tabla del 0
        //      0*0=0
        //      0*1=0
        // Tabla del 1
        //      0*1=0
        //      1*1=1

        int[] elementos = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < elementos.length; i++) {
            System.out.println("Tabla de multiplicar del " + elementos[i]);
            for (int j = 0; j < elementos.length; j++) {
                System.out.printf("%d * %d = %d%n",
                        elementos[i], elementos[j], elementos[i] * elementos[j]);
            }
        }
    }

}
