package model;

public class TareaEspecializada extends Tarea  {

    // ELEMENTOS PRIVADOS NO SE ARRASTRAN -> GETTER SETTER
    private String condicionEspecial;

    public TareaEspecializada(){}

    @Override
    public void metodoEjecutar() {
        System.out.println("Ejecutando el metodo especial desde una tarea Especializada");
    }

    public void metodoEspecializado(){
        System.out.println("Metodo que esta especializado");
    }

    public TareaEspecializada( String titulo, String descripcion, int prioridad, String condicionEspecial ){
        //super(titulo);
        super(titulo,descripcion,prioridad);
        this.condicionEspecial = condicionEspecial;
        //super();
    }

    public String getCondicionEspecial() {
        return condicionEspecial;
    }

    public void setCondicionEspecial(String condicionEspecial) {
        this.condicionEspecial = condicionEspecial;
    }
}
