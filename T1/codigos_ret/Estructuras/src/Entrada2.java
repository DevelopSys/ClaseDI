import java.util.Scanner;

public class Entrada2 {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Por favor introduce el primer numero");
        int numero = lectura.nextInt();
        System.out.println("El numero leido es "+numero+"como resultado");
        System.out.println("Ahora pasame una palabra");
        String palabra = lectura.next();
        System.out.println("La palabra leida es "+palabra);
        double numeroDecimal = 3.423123123;
        System.out.printf("El numero leido es %d y la palabra es %s\n" +
                "El decimal es %.2f",numero,palabra,numeroDecimal);


        // new Entrada2().primerEjercicio();
        // new Entrada2().segundoEjercicio();
        // int aletario = (int)(Math.random()*11); // 0-10
        // 0
    }

    public void primerEjercicio(){

    }
    public void segundoEjercicio(){

    }



}
