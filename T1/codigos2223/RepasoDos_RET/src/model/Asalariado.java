package model;

public final class Asalariado extends Trabajador{

    // PROPIEDADES
    // CONST
    // MET
    // @OVERRIDE
    // GET SET
    // TO STRING

    private int numeroPagas;
    private int costeSS;
    private int sueldo;

    public Asalariado(String nombre, String apellido, String dni, int NSS, int numeroPagas,
    int costeSS, int sueldo) {
        super(nombre, apellido, dni, NSS);
        this.costeSS = costeSS;
        this.numeroPagas = numeroPagas;
        this.sueldo = sueldo;
    }

    public void mostrarSuledoNeto(int retencion){
        double retencionReal = this.sueldo  * retencion/100;
        double saldoAnualNeto = this.sueldo -retencionReal;
        double saldoMensualNeto = saldoAnualNeto/this.numeroPagas;

        System.out.println("Anual bruto: "+sueldo);
        System.out.println("Anual neto: "+saldoAnualNeto);
        System.out.println("Mensual neto: "+saldoMensualNeto);
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Sueldo: "+sueldo);
        System.out.println("Pagas: "+numeroPagas);
        System.out.println("Coste SS: "+costeSS);
    }

    @Override
    public void calcularJubilacion() {
        System.out.println("Calculando la jubilación del asalariado....");
        double calculo = (sueldo*numeroPagas)/50 * (int)((Math.random() * 3)+1);
        System.out.println("La jubilacion que se le queda es "+calculo);
    }

    public int getNumeroPagas() {
        return numeroPagas;
    }

    public void setNumeroPagas(int numeroPagas) {
        this.numeroPagas = numeroPagas;
    }

    public int getCosteSS() {
        return costeSS;
    }

    public void setCosteSS(int costeSS) {
        this.costeSS = costeSS;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
}
