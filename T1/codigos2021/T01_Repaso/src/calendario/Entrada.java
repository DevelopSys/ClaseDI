package calendario;

import java.util.Calendar;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombre;
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH);
        int anio = calendario.get(Calendar.YEAR);
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        String[] meses = {"E","F","M","A","MY","J","JL","AG","S","O","N","D"};
        System.out.println("Introduce tu nombre");
        nombre = teclado.next();
        String saludo;
        String patron = "%s %s %n " +
                "Son las %d:%d del %d de %s de %d";

        if (hora>6 && hora<12){
            saludo = "Buenos dias";
        } else if (hora<20){
            saludo = "Buenas tardes";
        } else {
            saludo = "Buenas noches";
        }


        System.out.printf(patron, saludo,
                nombre, hora, minutos, dia, meses[mes], anio);


    }
}
