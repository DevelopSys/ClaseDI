package model;

public class TareaPersonal extends Tarea implements FuncionalidadCompartida{
    @Override
    public void enviarRecordatorio() {
        System.out.println("Enviar un recordatorio para reservar sitio en "+ubicacion);
    }

    private String ubicacion;

    public TareaPersonal(){}

    public  TareaPersonal(String titulo, String descripcion, boolean prioritario,
                          int numeroPersonas, String ubicacion){
        super(titulo, descripcion, prioritario, numeroPersonas);
        this.ubicacion = ubicacion;
    }

    public TareaPersonal(String titulo, String descripcion, int numeroPersonas, String ubicacion){
        super(titulo,descripcion,numeroPersonas);
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void mostrarDatos(){
        // super.toString()
        // super.mostrarDatos()
    }

    @Override
    public String toString() {
        return super.toString()+ "TareaPersonal{" +
                "ubicacion='" + ubicacion + '\'' +
                '}';
    }


    @Override
    public void metodoComun1() {
        System.out.println("Funcionalidad 1 desde la clase Personal");
    }

    @Override
    public void metodoComun2() {
        System.out.println("Funcionalidad 2 desde la clase Personal");
    }

    @Override
    public void metodoComun3() {
        System.out.println("Funcionalidad 3 desde la clase Personal");
    }
}
