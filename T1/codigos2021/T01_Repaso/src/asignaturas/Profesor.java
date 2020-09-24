package asignaturas;

public class Profesor {

    public void ponerNotas(Alumno alumno){
        alumno.getAsignaturaUno().setCalificacion((int)(Math.random()*10));
        alumno.getAsignaturaDos().setCalificacion((int)(Math.random()*10));
        alumno.getAsignaturaTres().setCalificacion((int)(Math.random()*10));
    }

    public double calcularMedia(Alumno alumno){

        double media = (alumno.getAsignaturaUno().getCalificacion() +
                alumno.getAsignaturaDos().getCalificacion() +
                alumno.getAsignaturaTres().getCalificacion())/3;
        return media;
    }
}
