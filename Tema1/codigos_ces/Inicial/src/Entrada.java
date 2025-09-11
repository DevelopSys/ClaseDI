import java.util.Scanner;

public class Entrada {

    // variable
    public static void main(String[] args) {

        //variable
        Scanner lector = new Scanner(System.in);
        System.out.println("Primer programa de repaso");
        // variable -> guardar valor que será utilizado
        final String DNI = "123123A";
        System.out.println("Introduce tu nombre");
        String nombre = lector.next();
        String correo; // null
        System.out.println("Introduce tu edad");
        int edad = lector.nextInt();
        System.out.printf("Mi nombre es %s y tengo %d años%n"
                ,nombre,edad);

        



    }
}
