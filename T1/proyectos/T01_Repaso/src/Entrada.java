import java.util.Calendar;
import java.util.Scanner;

public class Entrada {


    public int variable = 1;

    public static void main(String[] args) {

        /*int nota1 = 5;
        int nota2;

        switch (nota1) {
            case 1:
                nota2 = 1;
                break;
            case 2:
                nota2 = 2;
                break;
            case 3:
                nota2 = 3;
                break;
            case 4:
                nota2 = 4;
                break;
            case 5:
                nota2 = 5;
                break;
            default:
                nota2 = 20;
                break;
        }

        System.out.println(nota2);

        int[] colNumeros = new int[3];
        int[] colNumerosDos = {1, 2, 3, 4, 5};


        for (int i = 0; i < colNumerosDos.length; i++) {
            System.out.println(colNumerosDos[i]);
        }


        for (int item : colNumerosDos) {
            System.out.println(item);
        }

        Object[] arrayTipos = {1, false, "hola"};

        for (Object item : arrayTipos) {
            if (item.getClass() == Integer.class) {

            }
        }

        System.out.println("El dato del array es: " + arrayTipos[0]);
        System.out.printf(" El dato del array es %d y es del array %s \n"
                , colNumeros[0], "array números");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor introduce tu nombre:");
        String nombre = scanner.next();
        scanner.nextLine();
        System.out.println(nombre);

        System.out.println("Por favor introduce tu ap:");
        String ap = scanner.next();
        System.out.println(ap);

        System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
*/


        Scanner introduccion = new Scanner(System.in);

        String nombre;
        String saludoHora, saludoMes = null;
        String opcionContinua;
        boolean continua;
        String[] mesesArray = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
                "Septimbre", "Octubre", "Noviembre", "Diciembre"};

        System.out.println("Por favor introduce tu nombre:");
        nombre = introduccion.next();
        introduccion.nextLine();


        do {
            int ano = Calendar.getInstance().get(Calendar.YEAR);
            int mes = Calendar.getInstance().get(Calendar.MONTH);
            int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            int hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            int minutos = Calendar.getInstance().get(Calendar.MINUTE);

            saludoMes = mesesArray[mes];

            if (hora > 6 && hora < 12) {
                saludoHora = "Buenos dias";
            } else if (hora >= 12 && hora < 20) {
                saludoHora = "Buenos tardes";
            } else {
                saludoHora = "Buenos noches";
            }

            /*switch (mes) {
                case 0:
                    saludoMes = "Enero";
                    break;
                case 1:
                    saludoMes = "Febrero";
                    break;
                case 2:
                    saludoMes = "Marzo";
                    break;
                case 3:
                    saludoMes = "Abril";
                    break;
                case 4:
                    saludoMes = "Mayo";
                    break;
                case 5:
                    saludoMes = "Junio";
                    break;
                case 6:
                    saludoMes = "Julio";
                    break;
                case 7:
                    saludoMes = "Agosto";
                    break;
                case 8:
                    saludoMes = "Septiembre";
                    break;
                case 9:
                    saludoMes = "Octubre";
                    break;
                case 10:
                    saludoMes = "Noviembre";
                    break;
                case 11:
                    saludoMes = "Diciembre";
                    break;
            }*/

            System.out.printf("%s %s son las %d:%d del %d de %s de %d \n"
                    , saludoHora, nombre, hora, minutos, dia, saludoMes, ano);
            System.out.printf("Quieres continuar: (s/n) \n");
            opcionContinua = introduccion.next();
            introduccion.nextLine();
            if (opcionContinua.toLowerCase().equals("s")) {
                continua = true;
            } else {
                continua = false;
            }

        } while (continua);

        System.out.printf("Que tengas buen día %s", nombre);


    }


}
