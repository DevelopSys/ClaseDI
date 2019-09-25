package trabajadores;

public class Gerente extends Trabajador implements Directivo {

    public Gerente(String nombre, String apellido, String dni, int sueldo) {
        super(nombre, apellido, dni, sueldo);
    }

    @Override
    public void calcularSalario() {

    }

    @Override
    public void mandarMensaje(String s) {

    }

    @Override
    public int emitirVoto(int v) {
        return v;
    }
}
