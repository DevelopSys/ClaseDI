package utils;

public class Persona {

    String nombre, apellido, correo;
    char[] pass;
    int edad;

    public Persona(String nombre, String apellido, String correo, char[] pass, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.pass = pass;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public char[] getPass() {
        return pass;
    }

    public int getEdad() {
        return edad;
    }
}
