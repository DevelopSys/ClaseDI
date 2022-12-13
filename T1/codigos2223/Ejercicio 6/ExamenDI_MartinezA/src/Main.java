import clases.Medico;
import clases.Paciente;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Main main = new Main();

        ArrayList<Medico> medicos = new ArrayList<Medico>();

        Scanner scanner = new Scanner(System.in);

        medicos.add(new Medico("Nick", "Rivera", "traumatología", "001", 001));
        medicos.add(new Medico("Hannibal", "Lecter", "digestivo", "002", 002));
        medicos.add(new Medico("Sam", "Owens", "psiquiatría", "003", 003));
        medicos.add(new Medico("Martin", "Brenner", "general", "004", 004));
        medicos.add(new Medico("Strephen", "Strange", "cirugía", "005", 005));


        int op1 = 0;
        double precio = 0;

        System.out.println("Bienvenido a la tienda virtual supermercados Exito");
        System.out.println("seleccione una categoria de su interes.");


        do {

            System.out.println("1 - Registrar Paciente");
            System.out.println("2 - PedirCita");
            System.out.println("3 - Listar Medicos");
            System.out.println("4 - Listar Citas Pendientes");


            op1 = Integer.parseInt(scanner.next());


            switch (op1) {
                case 1: main.registrarPaciente();
                    break;


            }

        } while (scanner.hasNext());

    }

    public void registrarPaciente(){

        String nombre = scanner.next("Introduzca su nombre: ");
        String apellidos = scanner.next("Introduzca su apellido: ");
        String dni = scanner.next("Introduzca su DNI: ");
        int NSS = scanner.nextInt(Integer.parseInt("Introduzca su NSS: "));
            if(!pacienteExists(NSS))
                System.out.println("El paciente ya está registrado.");
            else
                pacientes.add(new Paciente(nombre, apellidos, dni, NSS));
    }

    public void pedirCita(){
     int NSS = scanner.nextInt(Integer.parseInt("Introduzca el NSS del paciente: "));


    }

    public boolean pacienteExists(int NSS){
        if (pacientes == null)
            return true;
        else for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getNSS() == NSS)
                return false;
        }
        return true;
    }
}
