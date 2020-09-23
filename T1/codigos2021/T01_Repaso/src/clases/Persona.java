package clases;

public abstract class Persona {

    // atributos
    String nombre, apellido,dni;

    // constructor


    public Persona() {
    }

    public Persona(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    // metodos

    public abstract void metodoGenerico();

    public void comer(){
        System.out.println("He comido");
    }

    public void caminar(){
        System.out.println("He caminado");
    }

    public void hablar(String palabra){
        System.out.println(palabra);
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

    public String getDni() {
        return dni;
    }


    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
