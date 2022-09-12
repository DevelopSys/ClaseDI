import java.io.BufferedReader;
import java.util.Scanner;

public class Main {

    // atributos propiedades
    private static String nombre = "Borja"; // null
    public static int edad; // 0
    // las "siempre" variables son privadas o protected
    public static boolean comienzo = true;

    // métodos o funciones

    // constructor

    // una sola linea
    /*
    * tantas lineas como quiera
    * */

    // TODO: tengo que hacer algo

    /**
     * Comentarios de documentacion
     * @param args es el array de String de entrada
     * @return void en este caso no retorna nada
     * @author Borja Martin
     * @version 1.0
     */
    public static void main(String[] args) {
        //System.out.println("ejemplo inicial de repaso");
        //System.out.println(args[0]);
        //System.out.println(nombre);
        //System.out.println(new Main().nombre);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la edad: ");
        edad = scanner.nextInt();
        System.out.println("Intro nombre");
        nombre = scanner.next();
        System.out.println(edad);
        System.out.println(nombre);

        // aritmeticos
        // + - * / % -
        // 4 % 2 = 0 --> par o posiciones
        // asignacion
        // =
        // aritmeticos - asignacion
        // += -= *= /= %=
        // num1 = 40
        // num2 = 5
        // num1 += num2 --> 40 + 5 --> num1 // num1 = num1 + num2
        // unarios
        // ++ --
        // lógicos
        // && (AND) --> V cuando las n condiciones sean V
        // || (OR) --> V cuando una de las condiciones sea V
        // ( C1-f || C2-v ) && (C3-v && C4-f) --> V && F -> F
        // comparación
        // > >= < <= ! == (===)
        // ternario
        // condicion ? cuando es true : cuando es false
        // condicion & cuando es true

        // Esctructuras de control
        // if --> gerenerales a especificos
        /*if (!true){

        } else if (false){

        }

        if (false) {

        } else {

        }*/


        // String char int
        // util cuando hay 3 decisiones
        int numero =1;
        switch (numero){
            case 1:
              break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }

        // while --> 0 veces a n
        numero = 10;
        while (numero>=10){
            if (numero== 5){
                break;
            }
            System.out.println("Ejecucion");
            // modificar algo de la condicion

            numero--;
        //numero-=numero;
        }

        // ejecutadas 1 a n veces
        do{

        }while (numero<=10);

        // for - foreach
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }

        // recorridos completos
        //int[] numeros = {1,2,3,4,5,6,7,8,9,10};
        //int[] numeros = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++)
        {
            numeros[i] = (int) (Math.random() *11);
        }

        for ( int item: numeros ) {
            System.out.println(item);
        }



    }

    // getter y setter
    // para el acceso a las variables por encapsulamiento

    /**
     * @return String retorna el valor del nombre
     */
    public String getNombre() {
        // ademas de devolver le suma uno al valor
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public static boolean isComienzo() {
        return comienzo;
    }

    public static void setComienzo(boolean comienzo) {
        Main.comienzo = comienzo;
    }
}
