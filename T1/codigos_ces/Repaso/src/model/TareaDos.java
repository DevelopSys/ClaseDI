package model;

public class TareaDos extends Tarea implements Reunion{

    private int coste;

    public TareaDos(String titulo, String descripcion, int prioridad, int coste) {
        super(titulo, descripcion, prioridad);
        this.coste = coste;
    }

    @Override
    public void metodoEjecutar() {

    }


    public void mostrar(int cosa) {
        System.out.println("Coste: "+coste);
        super.mostrar();
    }

    @Override
    public void mostrar() {
        System.out.println("Coste: "+coste);
        super.mostrar();
    }

    @Override
    public void metodoComun() {
        
    }
}
