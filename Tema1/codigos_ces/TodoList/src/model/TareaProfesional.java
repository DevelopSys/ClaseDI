package model;

import java.util.ArrayList;
import java.util.Date;

public class TareaProfesional extends Tarea{

    /*
    private String titulo, descripcion;
    private boolean prioritario, completada;
    private Persona[] encargados;
    private ArrayList<Encargo> listaTareas;
     */
    private int presupuesto;
    private Date fechaLimite;


    public TareaProfesional(){}

    @Override
    public void enviarRecordatorio() {
        // se imprime por consola, a cada uno de los responbles el mensaje
            // Borja, recuerda terminar las tareas asociadas a esta tarea
            // Borja, recuerda terminar las tareas asociadas a esta tarea

        for ( Persona persona : getEncargados() ) {
            if (persona !=null){
                System.out.printf("%s recuerda que completar %d tareas pendientes\n"
                        ,persona.getNombre(),getListaTareas().size());
            }

        }

    }

    public TareaProfesional(String titulo, String descripcion, int numeroPersonas,
                            int presupuesto, Date fechaLimite){
        super(titulo,descripcion,numeroPersonas);
        this.fechaLimite = fechaLimite;
        this.presupuesto = presupuesto;
    }

    public TareaProfesional(String titulo, String descripcion, boolean prioritario,
                            int numeroPersonas, int presupuesto, Date fechaLimite) {
        super(titulo, descripcion, prioritario, numeroPersonas);
        this.presupuesto = presupuesto;
        this.fechaLimite = fechaLimite;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    @Override
    public String toString() {
        return super.toString()+" TareaProfesional{" +
                "presupuesto=" + presupuesto +
                ", fechaLimite=" + fechaLimite +
                '}';
    }
}
