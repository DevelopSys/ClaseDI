package calendario;

import java.util.Calendar;
import java.util.Scanner;

public class MainCalendario {

    public static void main(String[] args) {
        String nombre, continuar="S";
        Calendar calendario;
        int hora, minutos, mes, anio, dia;
        String saludo = "%s %s son las %d:%d del %d de %s de %d%n";
        String tipoSaludo;
        String[] meses = {"Enero","Febrero", "Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Oct","Nov","Dic"} ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("introduce tu nombre");
        nombre = scanner.next();

        do {
            calendario = Calendar.getInstance();
            hora =calendario.get(Calendar.HOUR_OF_DAY);
            minutos =calendario.get(Calendar.MINUTE);
            dia =calendario.get(Calendar.DAY_OF_MONTH);
            anio =calendario.get(Calendar.YEAR);
            mes =calendario.get(Calendar.MONTH);


            if (hora >=6 && hora<12){
                tipoSaludo = "Buenos dias";
            } else if (hora>=12 && hora<20){
                tipoSaludo = "Buenas tardes";
            } else {
                tipoSaludo = "Buenas noches";
            }

            System.out.printf(saludo,tipoSaludo,nombre,hora,minutos,dia,meses[mes],anio);
            System.out.println("Quieres volver a comprobar");
            continuar = scanner.next();

        }while (continuar.equalsIgnoreCase("s"));

        System.out.println("Que tengas buen día");




    }

}
