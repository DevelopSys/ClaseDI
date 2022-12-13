package clases;

public final class Asalariado extends Trabajador {

    private int numeroPagas;

    private double costeSS, sueldo;

    public Asalariado(String nombre, String apellido, String dni, int NSS, int numeroPagas, double costeSS, double sueldo) {
        super(nombre, apellido, dni, NSS);

        this.costeSS = costeSS;
        this.numeroPagas = numeroPagas;
        this.sueldo = sueldo;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Sueldo: " + sueldo);
        System.out.println("Numero de Pagas: " + numeroPagas);
        System.out.println("Coste SS: " + costeSS);
    }

    public void mostrarSueldoNeto(int retencion){
        double retencionReal = this.sueldo * retencion/100;

        double saldoAnualNeto = this.sueldo - retencionReal;
        double sueldoMensualNeto = saldoAnualNeto/this.numeroPagas;

        System.out.println("Anual Bruto: "+ sueldo);
        System.out.println("Anual Neto: "+ saldoAnualNeto);
        System.out.println("Mensual Neto: "+ sueldoMensualNeto);
    }

    @Override
    public void calcularJubilacion() {

        System.out.println("Calculando la jubilacion del asalariado...");
        double calculo = (sueldo*numeroPagas)/50 * ((int)(Math.random()*3)+1);
        System.out.println("La jubilacion que se le queda es "+calculo);
    }



    public int getNumeroPagas() {
        return numeroPagas;
    }

    public void setNumeroPagas(int numeroPagas) {
        this.numeroPagas = numeroPagas;
    }

    public double getCosteSS() {
        return costeSS;
    }

    public void setCosteSS(double costeSS) {
        this.costeSS = costeSS;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
