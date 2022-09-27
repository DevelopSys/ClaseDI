package model;

public final class Autonomo extends Trabajador {

    private int cuotaSS, totalFactura;

    public Autonomo(String nombre, String apellido, String dni, int NSS, int cuotaSS, int totalFactura) {
        super(nombre, apellido, dni, NSS);
        this.totalFactura = totalFactura;
        this.cuotaSS = cuotaSS;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Cuota SS " + cuotaSS);
        System.out.println("Total factura " + totalFactura);
    }

    @Override
    public void calcularJubilacion() {
        System.out.println("Calculando jubilación del autonomo");
        System.out.println("Tu jubilación es " + cuotaSS / 2);
    }

    public int getCuotaSS() {
        return cuotaSS;
    }

    public void setCuotaSS(int cuotaSS) {
        this.cuotaSS = cuotaSS;
    }

    public int getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(int totalFactura) {
        this.totalFactura = totalFactura;
    }
}
