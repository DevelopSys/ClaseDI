package model;

import java.util.ArrayList;

public class Empresa {

    private ArrayList<Trabajador> listaTrabajadores;
    private String CIF;
    private String nombre;

    public Empresa() {
    }

    public Empresa(String nombre, String CIF) {
        this.CIF = CIF;
        this.nombre = nombre;
        this.listaTrabajadores = new ArrayList<>();
    }

    public void contratarTrabajador(Trabajador trabajador){
        // una empresa solo puede contratar
        // trabajadores que no tenga ya
        // contratados solo pueden existir
        // trabajadores con diferentes nss o dni
        if(!existeTrabajador(trabajador.getNSS())){
            listaTrabajadores.add(trabajador);
            System.out.println("Emplado añadido correctamente");
        }
    }

    // otra de las posibilidades de la empresa es la de
    // buscar un trabajador
    // y mostrar sus datos
    // para ello me pide el nss del que quiero mostrar
    // los datos

    private boolean existeTrabajador(int nss){
        boolean existe = false;
        for ( Trabajador item : listaTrabajadores ) {
            if (item.getNSS() == nss){
                System.out.println("El numero ya existe en la BBDD");
                existe = true;
            }
        }

        return existe;
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
