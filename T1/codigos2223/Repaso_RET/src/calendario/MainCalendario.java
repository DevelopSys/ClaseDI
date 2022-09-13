package calendario;

import java.util.Calendar;
import java.util.Scanner;

public class MainCalendario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] meses = {"En","Fe","Ma","Ab","My","ju","Jl","Ag","Se","Oc","Nv","Di"};
        double pi = Math.PI;
        String saludo = "%s %s son las %d:%d del %d de %s de %d %.2f %n";
        String nombre, continuar, saludoPerso;
        Calendar calendar;
        int dia, mes, anio, hora, minutos;
        System.out.println("Indica cual es tu nombre");
        nombre = scanner.next();

        do {
            calendar = Calendar.getInstance();
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            anio = calendar.get(Calendar.YEAR);
            hora = calendar.get(Calendar.HOUR_OF_DAY);
            minutos = calendar.get(Calendar.MINUTE);

            // saludo
            if (hora > 6 && hora < 12) {
                saludoPerso = "Buenos dias";
            } else if (hora>=12 && hora<20) {
                saludoPerso = "Buenas tardes";
            } else {
                saludoPerso = "Buenas noches";
            }

            System.out.printf(saludo,saludoPerso,nombre, hora,minutos,dia,meses[mes],anio, pi);
            // repito??
            System.out.println("Quieres volver a comprobar la hora");
            continuar = scanner.next();
        } while (continuar.equalsIgnoreCase("s"));

        System.out.println("Finalizando programa");
    }
}
