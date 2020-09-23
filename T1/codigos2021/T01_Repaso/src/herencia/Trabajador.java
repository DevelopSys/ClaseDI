package herencia;

public final class Trabajador extends Persona {

    private int sueldo, numeroHoras;

    public Trabajador(){

    }

    public Trabajador(String nombre, String apellido, String dni, int sueldo, int numeroHoras) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
        this.numeroHoras = numeroHoras;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    @Override
    public void metodoGenerico() {
        System.out.println("Soy un trabajador");
    }
}
