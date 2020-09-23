package clases;

public class Jefe extends Persona implements Empleado {

    int beneficio;

    public Jefe(String nombre, String apellido, String dni, int beneficio) {
        super(nombre, apellido, dni);
        this.beneficio = beneficio;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    @Override
    public void metodoGenerico() {
        System.out.println("soy generico desde jefe");
    }

    public void metodoDeJefe(){
        System.out.println("Soy un metodo solo de jefe");
    };

    public void mandar(){
        System.out.println("Voy a mandar");
    }

    @Override
    public void fichar() {

    }

    @Override
    public int cobrar() {
        return 0;
    }

    @Override
    public String porDefecto() {

        return "Soy un Jefe";
    }
}
