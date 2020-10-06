import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Concesionario concesionario = new Concesionario();
        int opcion;

        System.out.println("Intro id");
        int id = 0;
        System.out.println("Intro pass");
        String pass = "";
        if (concesionario.realizarLogin(id, pass)){
            //todo todo lo de antes
        };

        do {
            System.out.println("1. Ver coches");
            System.out.println("2. Buscar coche");
            System.out.println("3. Vender coche");
            System.out.println("4. Ver salario");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    concesionario.listarCoches();
                    break;
                case 2:
                    System.out.println("Introduce matricula");
                    String matricula = scanner.next();
                    concesionario.buscarCoche(matricula);
                    break;
                case 3:
                    System.out.println("Introduce marca a vender");
                    String marca = scanner.next();
                    double precio = concesionario.obtenerCosteMarca(marca);
                    if (precio > 10500) {
                        concesionario.getTrabajadores().get(0)
                                .setSueldo(concesionario.getTrabajadores().get(0).getSueldo()+ (precio*0.10));
                    }
                    break;
                case 4:
                    System.out.println(concesionario.getTrabajadores().get(0).toString());
                    break;
            }

        } while (opcion != 5);
    }
}
