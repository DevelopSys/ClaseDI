package model;

import java.util.ArrayList;

// crear el método que permite agregar un encargo
// los encargos deben tener ID unico -> PONER AVISOS
// crear el método que permite eliminar un encargo
// para ello se pide el id del encargo y se quita de la lista -> PONER AVISOS

/*
Listar todos los encargos de una tarea
 */

/*
Buscar un encargo por id y mostrar sus datos
 */

/*
Completar un encargo -> pasar su variable completada a true
 */

/*
Mostrar un encargo que estan completados
 */

/*
Completar una tarea -> Una tarea quedará completa si todos sus encargos
estan completos
 */

/*
Crear los metodos de:
asignar a un encargo un responsable
Para moder asignar un responsable al encargo, previamente debe estar como integrande del
equipo
 */

/*
Cambiar responsable de tarea
 */

/*
Mostrar tareas por responsbale -> DNI
 */

abstract public class Tarea {

    // una tarea tiene asociadas una serie de personas
    // cuando se crea la tarea es necesario pedir cuantas personas (NO QUE PERSONAS)
    // encargaran de la tarea

    // variables
    private String titulo, descripcion;
    private boolean prioritario, completada;
    private Persona[] encargados;
    private ArrayList<Encargo> listaTareas;

    // constructores
    public Tarea() {

    }

    public Tarea(String titulo, String descripcion, boolean prioritario,
                 int numeroPersonas) {
        // completada = false;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioritario = prioritario;
        encargados = new Persona[numeroPersonas];
        listaTareas = new ArrayList<>();
    }

    public Tarea(String titulo, String descripcion, int numeroPersonas) {
        // completada = false;
        // prioritario = false
        this.titulo = titulo;
        this.descripcion = descripcion;
        encargados = new Persona[numeroPersonas];
        listaTareas = new ArrayList<>();
    }

    // enviarRecordatorio -> totalmente diferente en TPro TPer
    public abstract void enviarRecordatorio();

    // metodos -> getter / setter

    // cada tarea puede asignar una persona
    // solo se podrá asignar una persona si hay hueco disponible
    // cada vez que se asigne una persona, se deberá colocar en el primer hueco
    // disponible
    // si no hay hueco, saltar un aviso,
    // no podrás agregar dos personas que tengan el mismo DNI

    // en una tarea se pueden quitar responsables. Solo podre quitar una tarea si el DNI
    // que me indicas esta dentro de la lista de responsables. Mostrar aviso tanto para
    // proceso OK como proceso no OK

    public void asignarResponsable(Persona persona) {
        for (int i = 0; i < encargados.length; i++) {
            if (encargados[i] == null && !estaDNI(persona.getDni())) {
                encargados[i] = persona;
                System.out.println("Persona agregada correctamente");
                return;
            }
        }
        System.out.println("No hay hueco disponible, tarea completa");
    }

    public void eliminarResponsable(String dni) {
        for (Persona persona : encargados) {
            if (persona != null && persona.getDni().equalsIgnoreCase(dni)) {
                persona = null;
                System.out.println("Persona eliminada correctamente");
                return;
            }
        }
        System.out.printf("La persona con DNI %s no esta en esta tarea%n", dni);
    }

    // mostrar los datos de todos los usuarios que son responsables de dicha tarea
    // en caso de no tener ninguna avisar
    // en caso de tener huecos disponibles, avisar de cuantos

    public void mostrarResponsables() {
        int numeroHuecos = 0;
        for (Persona persona : encargados) {
            if (persona == null) {
                numeroHuecos++;
            } else {
                System.out.println(persona);
            }
        }

        if (numeroHuecos == encargados.length) {
            System.out.println("No hay resposonsables asignados");
        } else if (numeroHuecos > 0) {
            System.out.printf("Hay %d huecos disponibles%n", numeroHuecos);
        } else {
            System.out.println("Todos los responsables estan ubicados");
        }


    }

    private boolean estaDNI(String dni) {
        for (Persona persona : encargados) {
            if (persona != null && persona.getDni().equalsIgnoreCase(dni)) {
                return true;
            }
        }
        return false;
    }

    private Encargo estaEncargo(int id) {

        for (Encargo encargo : listaTareas) {
            if (encargo.getId() == id) return encargo;
        }
        return null;
    }

    public void agregarEncargo(Encargo encargo) {
        if (estaEncargo(encargo.getId()) != null) {
            System.out.println("Error en el proceso, no se puede agregar");
        } else {
            listaTareas.add(encargo);
            System.out.println("Agregado correctamente");
        }
    }

    public void borrarEncargo(int id) {
        if (estaEncargo(id) != null) {
            listaTareas.remove(estaEncargo(id));
            System.out.println("Borrado correctamente");
        } else {
            System.out.println("No esta en la lista el id especificado");
        }
    }

    public boolean borrarEncargo1(int id) {
        return listaTareas.remove(estaEncargo(id));
    }

    public void listarEncargos(){
        for (Encargo item : listaTareas) {
            item.mostrarDatos();
        }
    }

    public void listarEncargosCompletados(){
        for (Encargo encargo: listaTareas) {
            if(encargo.isCompletada()){
                encargo.mostrarDatos();
            }
        }
    }

    public void buscarEncargoId(int id){
        if (estaEncargo(id)!=null)
            estaEncargo(id).mostrarDatos();
        else
            System.out.println("El id no se enscuentra en la lista");
    }

    public void completarEncargo(int id){
        if (estaEncargo(id)!=null && !estaEncargo(id).isCompletada()){
            estaEncargo(id).setCompletada(true);
            System.out.println("Encargo completado correctamente");
        } else {
            System.out.println("El encargo no se puede completar, " +
                    "no esta en la lista o ya esta completado");
        }
    }
    public void completarTarea(){
        for (Encargo encargo: listaTareas) {
            if (!encargo.isCompletada()){
                System.out.println("No se puede completar la tarea");
                return;
            }
        }
        completada = true;
        System.out.println("tarea completada con exito");
    }

    public Persona[] getEncargados() {
        return encargados;
    }

    public void setEncargados(Persona[] encargados) {
        this.encargados = encargados;
    }

    public ArrayList<Encargo> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(ArrayList<Encargo> listaTareas) {
        this.listaTareas = listaTareas;
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


// creamos un encargo.
// Los encargos tienen una propiedad llamada descripcion,
// una propiedad llamda id y una propiedad llamada completa
