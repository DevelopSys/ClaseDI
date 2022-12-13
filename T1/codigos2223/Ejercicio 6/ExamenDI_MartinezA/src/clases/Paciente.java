package clases;

import java.util.ArrayList;

public class Paciente extends Persona{

    private int NSS;

    private ArrayList<Cita> citasPacientes = new ArrayList<Cita>();

    public Paciente(String nombre, String apellido, String DNI, int NSS) {
        super(nombre, apellido, DNI);
        this.NSS = NSS;
    }

    public int getNSS() {
        return NSS;
    }

    public void setNSS(int NSS) {
        this.NSS = NSS;
    }

    public void crearCita(Cita cita){
        citasPacientes.add(cita);
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Numero NSS :"+NSS);
    }

    public void mostrarCitas(){

        if (citasPacientes==null)
            System.out.println("No hay citas pendientes.");
        else for (int i = 0; i < citasPacientes.size(); i++) {
            System.out.println("clases.Cita "+i+" :\n");
            citasPacientes.get(i).mostrarDatos();
        }
    }
}
