package model;

public class Asalariado extends Trabajador{


    private double irpf;
    private int nPagas;

    public Asalariado(){}

    public Asalariado(String dni, String nombre, String apellido, int edad, String correo, int telefono, int nss, double salario, double irpf, int nPagas) {
        super(dni, nombre, apellido, edad, correo, telefono, nss, salario);
        this.irpf = irpf;
        this.nPagas = nPagas;
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("irpf = " + irpf);
        System.out.println("nPagas = " + nPagas);
    }

    @Override
    public double calcularSalarioNeto() {
        return getSalario() - (getSalario()*irpf);
    }

    public void calculoNetoMensual(){
        double netoMes = calcularSalarioNeto()/nPagas;
        System.out.println("netoMes = " + netoMes);
    }
}
