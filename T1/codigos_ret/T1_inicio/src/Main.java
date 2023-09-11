import java.util.Calendar;
import java.util.Scanner;

public class Main {

    // variables
    // primitivas: int, double, float, boolean
    // complejas (null): String, Integer, Double, Float, Coche
    // private: encapsulamiento

    // constructores (1 a n)
    // metodos: sin retorno (retorna el obj implicito)
    // metodos
    // acciones. public void nombre (param){}
    public void ejercicioUno() {

        // saludo personalizado
        System.out.println("Esto es una salida por consola " +
                "" + "ejemplo " +
                "" + "texto concatenado " +
                "" + "otracosa");
        System.out.print("Esto es una salida por consola son salto\n");
        System.out.printf("Esto es una salida formateada %s %d %.2f %b %n", "asd", 2, 1.0, false);
        // Cual es tu nombre
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.next();

        Calendar calendar = Calendar.getInstance();
        calendar.get(Calendar.YEAR);

        // Buenos dias (6-11:59) - Buenas tardes (12 - 19:59) - Buenas noches + nombre
        // Son las 17:56 del 11 - Septiembre - 2023

    }

    private String getNombreMes(int mes){
        String[] meses = new String[]{"E","F","M","A","MY","J","JL","A","S","OC","N","D"};
        String mesPalabra="";
        switch (mes) {
            case 0:
                mesPalabra = "Enero";
                break;
            case 1:
                mesPalabra = "Febrero";
                break;
            case 2:
                mesPalabra = "Marzo";
                break;
            case 3:
                mesPalabra = "Abril";
                break;
            case 4:
                mesPalabra = "Mayo";
                break;
            case 5:
                mesPalabra = "Junio";
                break;
            case 6:
                mesPalabra = "Julio";
                break;
            case 7:
                mesPalabra = "Agosto";
                break;
            case 8:
                mesPalabra = "Septiembre";
                break;
            case 9:
                mesPalabra = "Octubre";
                break;
            case 10:
                mesPalabra = "Noviembre";
                break;
            case 11:
                mesPalabra = "Diciembre";
                break;
        }
        //return mesPalabra;
        return meses[mes];
    }
    public void correccionSaludo() {
        // Buenos dias (6-11:59) - Buenas tardes (12 - 19:59) - Buenas noches + nombre
        // Son las 17:56 del 11 - Septiembre - 2023
        Scanner scanner = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();
        System.out.println("Por favor introduce tu nombre");
        String nombre = scanner.next();
        String saludoHora = null;
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        int minutos = calendar.get(Calendar.MINUTE);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH);
        int anio = calendar.get(Calendar.YEAR);

        if (hora >= 6 && hora < 12) {
            saludoHora = "Buenos dias";
        } else if (hora >= 12 && hora < 20) {
            saludoHora = "Buenas tardes";
        } else {
            saludoHora = "Buenas noches";
        }



        System.out.printf("%s %s\n", saludoHora, nombre);
        System.out.printf("Son las %d:%d del %d-%s-%d\n", hora, minutos, dia, getNombreMes(mes), anio);

    }

    public static void main(String[] args) {
        //new Main().ejercicioUno();
        new Main().correccionSaludo();
    }

}