package trabajadores;

public class Socio implements Directivo{

    String nombre, apellido, dni;

    public Socio(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public void mandarMensaje(String s) {

    }

    @Override
    public int emitirVoto(int v) {
        return v;
    }

}
