package trabajadores;

public class Director implements Directivo {

    String nombre, apellido, dni;

    public Director(String nombre, String apellido, String dni) {
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
