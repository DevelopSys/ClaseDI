package asignaturas;

public class Alumno {

    private Asignatura asignaturaUno, asignaturaDos, asignaturaTres;

    public Alumno(Asignatura a1, Asignatura a2, Asignatura a3) {
        this.asignaturaUno = a1;
        this.asignaturaDos = a2;
        this.asignaturaTres = a3;
    }

    public Alumno(int id1, int id2, int id3) {
        this.asignaturaUno = new Asignatura(id1);
        this.asignaturaDos = new Asignatura(id2);
        this.asignaturaTres = new Asignatura(id3);
    }

    public void verNotas() {
        System.out.printf("Asignatura %s: %.2f%n" +
                        "Asignatura %s: %.2f%n" +
                        "Asignatura %s: %.2f%n"
                , getAsignaturaUno().getIdentificador(), getAsignaturaUno().getCalificacion()
                , getAsignaturaDos().getIdentificador(), getAsignaturaDos().getCalificacion()
                , getAsignaturaTres().getIdentificador(), getAsignaturaTres().getCalificacion());
    }

    public Asignatura getAsignaturaUno() {
        return asignaturaUno;
    }

    public void setAsignaturaUno(Asignatura asignaturaUno) {
        this.asignaturaUno = asignaturaUno;
    }

    public Asignatura getAsignaturaDos() {
        return asignaturaDos;
    }

    public void setAsignaturaDos(Asignatura asignaturaDos) {
        this.asignaturaDos = asignaturaDos;
    }

    public Asignatura getAsignaturaTres() {
        return asignaturaTres;
    }

    public void setAsignaturaTres(Asignatura asignaturaTres) {
        this.asignaturaTres = asignaturaTres;
    }
}
