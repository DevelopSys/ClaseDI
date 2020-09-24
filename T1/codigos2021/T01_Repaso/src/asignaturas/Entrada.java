package asignaturas;

public class Entrada {

    public static void main(String[] args) {
        Asignatura pmdm = new Asignatura(1);
        Asignatura di = new Asignatura(2);
        Asignatura ad = new Asignatura(3);

        Alumno alumnoDam = new Alumno(pmdm, di, ad);
        //Alumno alumnoDam2 = new Alumno(1,2,3);

        Profesor profesor = new Profesor();
        alumnoDam.verNotas();
        profesor.ponerNotas(alumnoDam);
        System.out.println("Me han dado las notas!!!");
        alumnoDam.verNotas();
        System.out.println(profesor.calcularMedia(alumnoDam));
    }
}
