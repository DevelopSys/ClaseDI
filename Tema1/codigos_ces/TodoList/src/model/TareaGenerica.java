package model;

public class TareaGenerica extends Tarea{

    String dato;

    public TareaGenerica() {

    }

    public TareaGenerica(String titulo, String descripcion, boolean prioritario, int numeroPersonas, String dato) {
        super(titulo, descripcion, prioritario, numeroPersonas);
        this.dato = dato;
    }

    public TareaGenerica(String titulo, String descripcion, int numeroPersonas, String dato) {
        super(titulo, descripcion, numeroPersonas);
        this.dato = dato;
    }

    @Override
    public void enviarRecordatorio() {
        System.out.println("Aviso de manera generica");
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
}
