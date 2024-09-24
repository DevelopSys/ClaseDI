package controller;

import lombok.Getter;
import lombok.Setter;
import model.Coche;

import java.util.ArrayList;

@Getter
@Setter
public class Garaje {

    private ArrayList<Coche> listaCoches;
    private double caja;
    public Garaje(){
        listaCoches = new ArrayList<>();
    }

    // funcionalidad -> agregar listar buscar retirar_coche ver caja

}
