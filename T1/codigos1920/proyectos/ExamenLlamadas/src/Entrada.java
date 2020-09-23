import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Centralita centralita = new Centralita();
        int opcion = 0;
        do {

            System.out.println("1. Locales");
            System.out.println("2. Nacionales");
            System.out.println("3. Internacionales");
            System.out.println("4. Calculo");
            System.out.println("5. Listar");
            System.out.println("6. Exportar");
            System.out.println("7. Salir");
            System.out.println("Intro opcion");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    int nOrigen = teclado.nextInt();
                    int nDestino = teclado.nextInt();
                    int duracion = teclado.nextInt();
                    Llamada lLocal = new LlamadaLocal(nOrigen, nOrigen, duracion);
                    centralita.registarLlamada(lLocal);
                    break;
                case 2:
                    int nOrigenNa = teclado.nextInt();
                    int nDestinoNa = teclado.nextInt();
                    int duracionNa = teclado.nextInt();
                    Llamada lNacional = new LlamadaNacional(nOrigenNa, nDestinoNa, duracionNa);
                    centralita.registarLlamada(lNacional);
                    break;
                case 3:
                    int nOrigenIn = teclado.nextInt();
                    int nDestinoIn = teclado.nextInt();
                    int duracionIn = teclado.nextInt();
                    String franja = teclado.next();
                    Llamada llamadaIn = new LlamadaInternacional(nOrigenIn, nDestinoIn, duracionIn, franja);
                    centralita.registarLlamada(llamadaIn);
                    break;
                case 4:
                    centralita.calcularCostes();
                    break;
                case 5:
                    centralita.mostrarDatos();
                    break;
                case 6:
                    centralita.exportarDatos();
                    break;
                case 7:
                    System.out.printf("Saliendo %n");
                    break;
                default:
                    System.out.printf("Caso no contemplado %n");
                    break;
            }


        } while (opcion != 7);
    }
}
