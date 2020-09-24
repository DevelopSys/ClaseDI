package asignaturas;

public class Asignatura {

    // attr
    private int identificador;
    private double calificacion;

    // const
    public Asignatura(int id){
        this.identificador = id;
    }

    // métodos
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}
