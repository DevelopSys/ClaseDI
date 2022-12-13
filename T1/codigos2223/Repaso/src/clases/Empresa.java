package clases;

import interfaces.Votante;

import java.util.ArrayList;

public class Empresa {

    private ArrayList<Trabajador> listaTrabajadores;

    private String CIF, nombre;

    public Empresa(String nombre, String CIF) {

        this.nombre = nombre;
        this.CIF = CIF;
        this.listaTrabajadores = new ArrayList<>();
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

    //metodos

    public void contratarTrabajadores(Trabajador trabajador) {
        //Una empresa solo puede contratar trabajadores que no tenga ya contratados

        for (Trabajador worker : listaTrabajadores) {
            if (existeTrabajador(trabajador.getDni()) == null) {
                System.out.println("");

            }
        }
    }

    public void RegistrarVoto(Votante votante, int voto) {
        votante.votar(voto);
    }

    public void listarTrabajadores(String tipo) {

       // if (tipo.equalsIgnoreCase())
        // if (tipo.equalsIgnoreCase("todos"))

     /*   switch (tipo) {
            case "Jefe":
                break;
            case "Autonomo":
                break;

            case "Asalariado":
                break;

        }*/

    }

    public void mostrarTrabajador(String nss) {
//        if (existeTrabajador(nss) != null) {

  //      }
    }

    private Trabajador existeTrabajador(String dni) {

        Trabajador existe = null;

        for (Trabajador worker : listaTrabajadores) {
            if (worker.dni.equals(dni)) {
                existe = worker;
                System.out.println("El trabajador existe en la empresa");
                return worker;
            }
        }

        return existe;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
