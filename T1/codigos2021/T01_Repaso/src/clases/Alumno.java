package clases;

public class Alumno extends Persona {

    int media;

    public Alumno(String nombre, String apellido, String dni, int media) {
        super(nombre, apellido, dni);
        this.media = media;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    @Override
    public void metodoGenerico() {
        System.out.println("soy generico desde alumno");
    }
}
