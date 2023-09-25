package model;

public final class TareaOcio extends Tarea {

    private String ubicacion;
    private double presupuesto;

    public TareaOcio() {
    }

    public TareaOcio(int id, String titulo, String descripcion, String fecha, Prioridad prioridad, String ubicacion, double presupuesto) {
        super(id, titulo, descripcion, fecha, prioridad);
        this.ubicacion = ubicacion;
        this.presupuesto = presupuesto;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Ubicacion "+ubicacion);
        System.out.println("Presupuesto "+presupuesto);
    }

    public void metodoTareaOcio(){
        System.out.println("Esto es un método exclusivo de la t ocio");
    }

    @Override
    public boolean completar() {
        System.out.println("La tarea de ocio se va a completar de forma automatica");
        if (presupuesto < 50) {
            setCompletada(true);
            return true;
        } else {
            return false;
        }
    }
}
