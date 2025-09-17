package model;

public class Tarea {

    // una tarea tiene asociadas una serie de personas
    // cuando se crea la tarea es necesario pedir cuantas personas (NO QUE PERSONAS)
    // encargaran de la tarea

    // variables
    private String titulo,descripcion;
    private boolean prioritario, completada;
    private Persona[] encargados;

    // constructores
    public Tarea(){

    }
    public Tarea(String titulo, String descripcion, boolean prioritario, int numeroPersonas){
        // completada = false;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioritario = prioritario;
        encargados = new Persona[numeroPersonas];
    }

    public Tarea(String titulo, String descripcion, int numeroPersonas){
        // completada = false;
        // prioritario = false
        this.titulo = titulo;
        this.descripcion = descripcion;
        encargados = new Persona[numeroPersonas];
    }

    // metodos -> getter / setter

    // cada tarea puede asignar una persona
    // solo se podrá asignar una persona si hay hueco disponible
    // cada vez que se asigne una persona, se deberá colocar en el primer hueco
    // disponible
    // si no hay hueco, saltar un aviso,
    // no podrás agregar dos personas que tengan el mismo DNI

    public void asignarResponsable(Persona persona){
        for (int i = 0; i < encargados.length; i++) {
            if (encargados[i]==null && !estaDNI(persona.getDni())){
                encargados[i]=persona;
                System.out.println("Persona agregada correctamente");
                return;
            }
        }
        System.out.println("No hay hueco disponible, tarea completa");
    }
    private boolean estaDNI(String dni){
        for ( Persona persona : encargados ) {
            if (persona != null && persona.getDni().equalsIgnoreCase(dni)){
                return true;
            }
        }
        return false;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isPrioritario() {
        return prioritario;
    }

    public void setPrioritario(boolean prioritario) {
        this.prioritario = prioritario;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", prioritario=" + prioritario +
                ", completada=" + completada +
                '}';
    }
}
