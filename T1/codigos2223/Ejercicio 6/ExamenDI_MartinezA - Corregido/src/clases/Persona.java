package clases;

public class Persona {

    private String nombre, apellido, DNI;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void mostrarDatos() {

        System.out.println("Nombre: "+ nombre);
        System.out.println("Apellido: "+apellido);
        System.out.println("DNI: "+ DNI);
    }
}
