package clases;

public final class Trabajador extends Persona implements Empleado{
    private int sueldo, numeroHoras;

    public Trabajador() {
    }

    @Override
    public void metodoGenerico() {
        System.out.println("soy generico desde trabajador");
    }

    public Trabajador(String nombre, String apellido, String dni, int sueldo, int numeroHoras) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
        this.numeroHoras = numeroHoras;
    }

    @Override
    public void caminar() {
        System.out.println("Soy un trabajador que trabaja caminando");
    }

    public void caminar(int pasos){
        System.out.println("Los pasos caminados hoy son "+pasos);
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
    public void fichar() {

    }

    public void trabajar(){
        System.out.println("voy a trabajar");
    }

    @Override
    public int cobrar() {
        return 0;
    }

    @Override
    public String porDefecto() {
        return "Soy un trabajador";
    }
}
