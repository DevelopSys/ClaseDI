import java.util.Calendar;
import java.util.Scanner;

public class MainRapaso {

    // atributos - propiedades - variables
    // constructores
    // métodos
    // getter setter
    // toString
    // TODO escribo algo

    /*
    * */
    /**
     *
     */



    public static void main(String[] args) {
        String nombre; // null
        int edad; // 0
        boolean confirmar; // false
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce nombre");
        nombre = scanner.next();
        System.out.println("Introduce edad");
        edad = scanner.nextInt();
        System.out.printf("Bienvenido %s tienes %d\n",nombre,edad);

        // OPERADORES

        // aritmeticos
        // + - * / % -
        // uninarios
        // ++ --
        // asignacion
        // =
        // asignacion y aritmeticos
        // += -= *= /= %=
        // num1 = 8
        // num2 = 9;
        // num1 += num2 --> num1 = 8+9 --> num1 = num1 + num2
        // 4%2 = 0 --> par/impar , posiciones
        // relacionales
        // > >= < <= == !=
        // logicos
        // AND (&&) -> V Cuando todas las condiciones son True
        // OR (||) -> V Cuando una de las condiciones es True
        // ternario
        // condicion ? cuando_true : cuando_false
        // condicion & cuando_true
        // ESTRUCTURAS DE CONTRO
        // if
        edad = 18;
        if (edad >= 18){
            edad = 2;
            System.out.println("Eres mayor de edad");
        } else if (edad>=14 && edad<18){
            System.out.println("Casi mayourlegal");
        }else {
            System.out.println("Eres menor de edad");
        }

        // switch
        // String int char
        // Object
        edad = 1;
        switch (edad){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
        }

        // while --> 0 a n

        edad = 10;
        while (edad<18){
            System.out.println("Todavia no eres mayor de edad");
            // modificar la condicion
            edad++;
        }

        do{
            System.out.println("Todavia no eres mayor de edad");
            edad++;
        }while (edad<18);
        // do while --> 1 a n

        // for
        // 0 1 2 3 4 5 6 7 8 9 10
        //int[] numeros = {1,2,3,4,5,6,7,8,9,10};
        for (int i = 10; i > -1; i--) {
            // ejecucion
            //System.out.println(numeros[i]);
        }

<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        // recorridos completos
        int[] numeros = {1,2,3,4,5,6,7,8,9,10};
        for (int item: numeros) {
            System.out.println(item);
            if (item != 9)break;
=======
=======
>>>>>>> Stashed changes
        //for ( : ) {

>>>>>>> Stashed changes
=======
        //for ( : ) {

>>>>>>> Stashed changes
        }

        Calendar calendar = Calendar.getInstance();
        calendar.get(Calendar.DAY_OF_MONTH);

        new Scanner(System.in).nextInt();







    }



