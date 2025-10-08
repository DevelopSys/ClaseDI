package model;

public class Autonomo extends Trabajador{

    private double cuotasSS;

    public Autonomo() {
    }

    public Autonomo(String dni, String nombre, String apellido, int edad, String correo, int telefono, int nss, double salario, double cuotasSS) {
        super(dni, nombre, apellido, edad, correo, telefono, nss, salario);
        this.cuotasSS = cuotasSS;
    }

    @Override
    public double calcularSalarioNeto() {
        double salarioNeto = getSalario() - cuotasSS*12;
        System.out.println("salarioNeto = " + salarioNeto);
        return salarioNeto;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("cuotasSS = " + cuotasSS);
    }

    public void aplicarDescuento(int descuento){
        // 250
        // 50/100 -> 0.5
        cuotasSS = cuotasSS - (cuotasSS * (double) descuento/100);
    }

    public double getCuotasSS() {
        return cuotasSS;
    }

    public void setCuotasSS(double cuotasSS) {
        this.cuotasSS = cuotasSS;
    }
}
