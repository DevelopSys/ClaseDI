package trabajadores;

import java.util.ArrayList;

public class Autonomo extends Trabajador {


    // double sueldoMes
    ArrayList<Trabajador> listaTrabajadores = new ArrayList();

    public Autonomo(String nombre, String apellido, String dni, int sueldo) {
        super(nombre, apellido, dni, sueldo);
    }

    @Override
    public void calcularSalario() {
        sueldoMes = sueldo/12;
    }

    @Override
    public void monstarDatos() {
        super.monstarDatos();
    }
    public void registrarTrabajador(Trabajador t){
        listaTrabajadores.add(t);
    }
}
