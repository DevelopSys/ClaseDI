package herencia;

public final class Alumno extends Persona {

    private double mediaAcademica;

    public Alumno(String nombre, String apellido, String dni, double mediaAcademica) {
        super(nombre, apellido, dni);
        this.mediaAcademica = mediaAcademica;
    }

    public double getMediaAcademica() {
        return mediaAcademica;
    }

    public void setMediaAcademica(double mediaAcademica) {
        this.mediaAcademica = mediaAcademica;
    }

    @Override
    public void metodoGenerico() {
        System.out.println("Soy un alumno");
    }
}
