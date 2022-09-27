package model;

import java.util.ArrayList;

public class Empresa {

    private ArrayList<Trabajador> listaTrabajadores;
    private String CIF;
    private String nombre;
    private int resultadoVotos = 0;

    public Empresa() {
    }

    public Empresa(String nombre, String CIF) {
        this.CIF = CIF;
        this.nombre = nombre;
        this.listaTrabajadores = new ArrayList<>();
    }

    public void registrarVoto(Votante votante, int voto){
        resultadoVotos+= votante.votar(voto);
        // listaTrabajadores --> Personas
        // todos los votantes voten, aleatorio entre 1 y 10
        for (Persona item: listaTrabajadores) {

            if(item instanceof Votante){
                ((Votante) item).votar()
            }
        }
    }

    public void contratarTrabajador(Trabajador trabajador) {
        // una empresa solo puede contratar
        // trabajadores que no tenga ya
        // contratados solo pueden existir
        // trabajadores con diferentes nss o dni
        if (existeTrabajador(trabajador.getNSS()) == null) {
            listaTrabajadores.add(trabajador);
            System.out.println("Emplado añadido correctamente");
        }
    }

    // listar trabajadores, pero se puede diferenciar
    // por el tipo que se quiere
    // mostrar: asalariado, jefe, autonomos, todos


    public void buscarTrabajador(int nss) {
        if (existeTrabajador(nss) != null) {
            existeTrabajador(nss).mostrarDatos();
        } else {
            System.out.println("El numero no existe");
        }
    }

    // otra de las posibilidades de la empresa es la de
    // buscar un trabajador
    // y mostrar sus datos
    // para ello me pide el nss del que quiero mostrar
    // los datos

    private Trabajador existeTrabajador(int nss) {
        Trabajador existe = null;
        for (Trabajador item : listaTrabajadores) {
            if (item.getNSS() == nss) {
                System.out.println("El numero ya existe en la BBDD");
                existe = item;
                return existe;
            }
        }
        return existe;
    }

    public void listarTrabajadores(String clase) {

        for (Trabajador item : listaTrabajadores) {

            if (item.getClass().getSimpleName()
                    .equalsIgnoreCase(clase)) {
                item.mostrarDatos();
            } else {
                item.mostrarDatos();
            }

            /*switch (clase){
                case "Jefe":
                    if (item instanceof Jefe){
                        item.mostrarDatos();
                    }
                    break;
                case "Autonomo":
                    break;
                case "Asalariado":
                    break;
            }*/

        }

    }

    public ArrayList<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(ArrayList<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "listaTrabajadores=" + listaTrabajadores +
                ", CIF='" + CIF + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
