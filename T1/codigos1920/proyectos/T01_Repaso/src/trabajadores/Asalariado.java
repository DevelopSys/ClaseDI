package trabajadores;

import java.awt.*;

public class Asalariado extends Trabajador {

    private int pagas;

    public Asalariado(String nombre, String apellido, String dni, int sueldo, int pagas) {
        super(nombre, apellido, dni, sueldo);
        this.pagas = pagas;
        calcularSalario();

    }

    @Override
    public void calcularSalario() {
        sueldoMes = this.sueldo / this.pagas;
    }

    @Override
    public void monstarDatos() {
        super.monstarDatos();
        System.out.printf("Pagas %d \n",pagas);
    }
    public void metodoPropio(){
        System.out.println("Método solo de los asalariados");
    }
}
