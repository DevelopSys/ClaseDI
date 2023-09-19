package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;


@Getter
@Setter
public class Lista implements Gestionable {

    private int id;
    private ArrayList<String> listaCosas;

    public Lista() {
        listaCosas = new ArrayList<>();
    }

    public Lista(int id) {
        this.id = id;
        this.listaCosas = new ArrayList<>();
    }

    @Override
    public void verDetalle() {
        System.out.println("EL id es: " + id);
        if (listaCosas.size() > 0) {
            System.out.println("La lista de cosas son:");
            for (String item : listaCosas) {
                System.out.println(item);
            }
        }

    }
}
