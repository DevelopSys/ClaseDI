package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Tarea {

    // variables
    private int id, horasEmpleadas;
    private String titulo, descripcion;
    private Persona responsable;
    private Persona[] equipoTrabajo;
    private boolean completada;
    private ArrayList<Encargo> encargos;

    // constructores -> el vacio (desaparece cuando se escribe uno)


    public Tarea() {

    }

    public Tarea(int id, String titulo, String descripcion, Persona responsable) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.responsable = responsable;
        equipoTrabajo = new Persona[4];
        encargos = new ArrayList<>();
    }

    public Tarea(int id, String titulo, String descripcion, Persona responsable, int horasEmpleadas) {
        this.id = id;
        this.horasEmpleadas = horasEmpleadas;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.responsable = responsable;
        equipoTrabajo = new Persona[4];
        encargos = new ArrayList<>();
    }

    public void agregarPersonaEquipo(Persona persona) {
        // cuando tenga un hueco libre (null)
        // cuando el dni no este en la lista
        Persona estaPersona = estaPersona(persona.getDni());
        for (int i = 0; i < equipoTrabajo.length; i++) {
            if (equipoTrabajo[i] == null && estaPersona ==null) {
                equipoTrabajo[i] = persona;
                System.out.printf("Agregado correctamente la persona con nombre %s%n"
                        , persona.getNombre());
                return;
            }
        }
        System.out.println("No se ha podido agregar");
    }

    private Persona estaPersona(String dni) {

        for (int i = 0; i < equipoTrabajo.length; i++) {
            if (equipoTrabajo[i] != null
                    && equipoTrabajo[i].getDni().equalsIgnoreCase(dni)){
               return equipoTrabajo[i];
            }
        }
        return null;
    }
    public void mostrarEquipoTrabajo(){
        for ( Persona persona : equipoTrabajo) {
            if(persona !=null){
                persona.mostrarDatos();
                // System.out.println(persona);
            }
        }
    }

    public void eliminarPersona(String dni){
        for (int i = 0; i < equipoTrabajo.length; i++) {
            if (equipoTrabajo[i]!=null &&
                    equipoTrabajo[i].getDni().equalsIgnoreCase(dni)){
                System.out.printf("Eliminado correctamente " +
                        "con nombre %s\n",equipoTrabajo[i].getNombre());
                equipoTrabajo[i] = null;
                return;
            }
        }
        System.out.println("DNI no encontrado");
    }

    public Persona[] getEquipoTrabajo() {
        return equipoTrabajo;
    }

    public void setEquipoTrabajo(Persona[] equipoTrabajo) {
        this.equipoTrabajo = equipoTrabajo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Persona getResponsable() {
        return responsable;
    }

    public void setResponsable(Persona responsable) {
        this.responsable = responsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHorasEmpleadas() {
        return horasEmpleadas;
    }

    public void setHorasEmpleadas(int horasEmpleadas) {
        this.horasEmpleadas = horasEmpleadas;
    }

    public String getTitulo(int pin) {
        if (pin == 1234) {
            return titulo;
        }
        return null;
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

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", horasEmpleadas=" + horasEmpleadas +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completada +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarea tarea)) return false;
        return getId() == tarea.getId() && getHorasEmpleadas() == tarea.getHorasEmpleadas();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHorasEmpleadas());
    }
}

// crear una clase llamada persona que tenga los
// atributos de: nombre, apellido, dni y edad
// Todos los atributos serán necesarios

// quiero que una tarea tenga un responsable asignado
// es imposible crear una tarea si no tiene responsable

// una tarea tiene hueco para 4 personas del equipo
// inicialmente la tarea no tiene personas en el equipo asignadas

// Agregar una persona al equipo de trabajo
// Si no tengo hueco, saltara un aviso
// Si intento agregar una persona al equipo de
// trabajo con un DNI ya existente
// saltará un aviso
// en caso de agregar saltar un aviso de todo OK

// crear un metodo para mostrar todos los datos de
// las personas del equipo de trabajo
// en caso de tener una persona null no mostrará nada

// Eliminar una persona del equipo de trabajo
// para ello el metodo pedirá un dni
// en caso de tener el dni en la lista, igualara a null su posicion->aviso
// en caso de no estar en la lista, saltará un aviso

// crear un metodo para poder agregar encargos en la tarea
// no pueden existir encargos con el mismo ID
// en todos los casos se mostrará un aviso del resultado del proceso
