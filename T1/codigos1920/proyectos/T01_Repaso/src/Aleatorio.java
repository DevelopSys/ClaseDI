import java.util.Scanner;

public class Aleatorio {

    public static void main(String[] args) {

        int numeroAd;
        int intentos=0, intento;
        boolean adivinado;
        Scanner teclado = new Scanner(System.in);


        numeroAd = (int) (Math.random() * 10);



        do{
            System.out.printf("Introduce el intento");
            intento = teclado.nextInt();

            if (intento == numeroAd) {
                System.out.println("Adivinado");
                adivinado = true;
            } else {
                System.out.println("Prueba otra vez");
                adivinado = false;
            }

            intento++;

        }while (!adivinado);


    }
}
