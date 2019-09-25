package trabajadores;

import java.util.ArrayList;

public class Empresa {

    ArrayList<Trabajador> listaTrabajadores;
    int votos;

    public Empresa() {
        this.listaTrabajadores = new ArrayList();
    }

    public void registrarTrabajador(Trabajador trabajador) {
        if (!existeTrabajador(trabajador.getDni())) {
            listaTrabajadores.add(trabajador);
        } else {
            System.out.printf("El trabajador ya existe \n");
        }
    }

    public void listarTrabajadores(){
        for (Trabajador item : listaTrabajadores){
            item.monstarDatos();
        }
    }

    public void mostrarUnTrabajador(String dni){
        for (Trabajador item : listaTrabajadores){
            if (item.getDni().equals(dni)){
                item.monstarDatos();
            }
        }
    }

    public boolean existeTrabajador(String dni) {
        for (Trabajador item : listaTrabajadores) {
            if (item.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }

    public void registarVoto(int voto){
        this.votos += voto;
    }

}
