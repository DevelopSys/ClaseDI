package model;

abstract public class Trabajador extends Persona{

    private String correo;
    private int telefono,nss;
    private double salario;

    public Trabajador() {
    }

    public Trabajador(String dni, String nombre, String apellido, int edad, String correo, int telefono, int nss, double salario) {
        super(dni, nombre, apellido, edad);
        this.correo = correo;
        this.telefono = telefono;
        this.nss = nss;
        this.salario = salario;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("correo = " + correo);
        System.out.println("telefono = " + telefono);
        System.out.println("nss = " + nss);
        System.out.println("salario = " + salario);
    }

    abstract public double calcularSalarioNeto();

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
