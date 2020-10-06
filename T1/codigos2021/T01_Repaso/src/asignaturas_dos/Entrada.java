package asignaturas_dos;

public class Entrada {

    public static void main(String[] args) {
        Asignatura pmdm = new Asignatura(1);
        Asignatura di = new Asignatura(2);
        Asignatura ad = new Asignatura(3);

        Alumno alumno = new Alumno(pmdm,di,ad);
        //Alumno alumnoDos = new Alumno(1,2,3);

        Profesor profesor = new Profesor();

        System.out.println(alumno.toString());

        profesor.ponerNotas(alumno);
        System.out.printf("La media del alumno es %.2f%n",profesor.calcularMedia(alumno));
        System.out.println(alumno.toString());
    }
}
