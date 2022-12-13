package clases;

public final class Autonomo extends Trabajador {

    private int cuotaSS, totalFactura;

    public Autonomo(String nombre, String apellido, String dni, int NSS, int cuotaSS, int totalFactura) {
        super(nombre, apellido, dni, NSS);
        this.cuotaSS = cuotaSS;
        this.totalFactura = totalFactura;
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

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Cuota SS: " + cuotaSS);
        System.out.println("Total Factura: " + totalFactura);
    }

    @Override
    public void calcularJubilacion() {
        System.out.println("Calculando Jubilacion del Autonomo...");
        System.out.println("Tu jubilacion es " + cuotaSS / 2);
    }
}
