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
            if (equipoTrabajo[i] == null && estaPersona == null) {
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
                    && equipoTrabajo[i].getDni().equalsIgnoreCase(dni)) {
                return equipoTrabajo[i];
            }
        }
        return null;
    }

    public void mostrarEquipoTrabajo() {
        for (Persona persona : equipoTrabajo) {
            if (persona != null) {
                persona.mostrarDatos();
                // System.out.println(persona);
            }
        }
    }

    public void eliminarPersona(String dni) {
        for (int i = 0; i < equipoTrabajo.length; i++) {
            if (equipoTrabajo[i] != null &&
                    equipoTrabajo[i].getDni().equalsIgnoreCase(dni)) {
                System.out.printf("Eliminado correctamente " +
                        "con nombre %s\n", equipoTrabajo[i].getNombre());
                equipoTrabajo[i] = null;
                return;
            }
        }
        System.out.println("DNI no encontrado");
    }

    // realizar el metodo que me permite agregar un encargo a la lista.
    // no se podrán meter encargos con id duplicado
    public void agregarEncargo(Encargo encargo) {
        if (estaEncargo(encargo.getId()) == null){
            System.out.println("Agregado encargo correctamente");
            encargos.add(encargo);
        } else {
            System.out.println("Ya tienes un id metido en la lista");
        }
    }

    // realizar un metodo que muestre la informacion de todos los encargos de la tarea
        // en caso de estar vacia, saltar un aviso de no se encuentran encargos
    public void mostrarEncargos(){
        if (!encargos.isEmpty()) {
            for ( Encargo item: encargos ) {
                System.out.println(item);
            }
        } else {
            System.out.println("Vacia, no hay nada");
        }
    }

    // realizar un metodo que muestre la informacion de UNO encargo. Para ello se pasa
        // el id y se muestra la info del encargo correspondiente
        // en caso de no estar, se muestra un aviso

    public void mostrarEncargo(int id){
        Encargo encargoEncontrado = estaEncargo(id);
        if(encargoEncontrado!=null){
            System.out.println(encargoEncontrado);
        } else {
            System.out.println("No hay encargo con ese ID");
        }
    }

    // crear un metodo que elimine un encargo, para ello me dara el id
        // y eliminará el encargo con ese ID

    public void eliminarEncargo(int id){
        Encargo encargoEncontrado = estaEncargo(id);
        if(encargoEncontrado!=null){
            encargos.remove(encargoEncontrado);
        } else {
            System.out.println("No hay encargo con ese ID");
        }
    }

    // crear un metodo que permita completar un encargo, Para eñlo se pedira un id
        // y dicho encargo quedará completado

    public void completarEncargo(int id){
        Encargo encargoEncontrado = estaEncargo(id);
        if(encargoEncontrado!=null){
            encargoEncontrado.setRealizado(true);
        } else {
            System.out.println("No hay encargo con ese ID");
        }
    }

    // realizar un metodo que permita completar una tarea
        // una tarea estara completa cuando todos sus encargos estan completos

    // mostrar encargos pendientes
        // se mostrara la informacion de los encargos asociados a una tarea
        // que no esta completos

    private Encargo estaEncargo(int id) {

        for (Encargo encargo: encargos) {
            if (encargo.getId() == id){
                return encargo;
            }
        }
        // System.out.println("No se ha encontrado el encargo");
        return null;
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

    public ArrayList<Encargo> getEncargos() {
        return encargos;
    }

    public void setEncargos(ArrayList<Encargo> encargos) {
        this.encargos = encargos;
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
