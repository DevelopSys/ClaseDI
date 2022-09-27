package model;

public abstract class Trabajador extends Persona {

    protected final int NSS;

    public Trabajador(String nombre, String apellido, String dni, int NSS){
        super(nombre, apellido, dni);
        this.NSS = NSS;
    }

    public abstract void calcularJubilacion();

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("NSS: "+NSS);
    }

    public int getNSS() {
        return NSS;
    }
}
