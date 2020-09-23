package figuras;

import figuras.Circulo;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion1, opcion2;

        do{
            System.out.println("1. Trabajo con circulos");
            System.out.println("2. Trabajo con rectangulos");
            System.out.println("3. Trabajo con triángulos");
            System.out.println("4. Salir");
            System.out.println("Selecciona opción (1-4)");
            opcion1 = teclado.nextInt();
            switch (opcion1){
                case 1:
                    System.out.println("Trabjo con Circulos");
                    System.out.println("1. Calcular diámetro");
                    System.out.println("2. Calcular área");
                    System.out.println("Selecciona opción (1-2)");
                    teclado.nextLine();
                    opcion2 = teclado.nextInt();
                    int x,y,radio;
                    System.out.println("Introduce x");
                    x = teclado.nextInt();
                    System.out.println("Introduce y");
                    y = teclado.nextInt();
                    System.out.println("Introduce radio");
                    radio = teclado.nextInt();
                    Circulo circulo = new Circulo(x,y,radio);
                    switch (opcion2){
                        case 1:
                            circulo.calcularDiametro();
                            System.out.println(circulo.getDiametro());
                            break;
                        case 2:
                            System.out.println(circulo.calcularArea());
                            break;
                        default:
                            System.out.println("Desconicido");
                    }

                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:

            }

        }while(opcion1!=4);





    }
}
