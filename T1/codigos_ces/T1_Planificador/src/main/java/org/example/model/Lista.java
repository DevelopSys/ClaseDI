package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;


@Getter
@Setter
public class Lista extends Tarea{

    private int id;
    private ArrayList<String> listaCosas;

    public Lista(){
        listaCosas = new ArrayList<>();
    }

    public Lista(int id) {
        this.id = id;
        this.listaCosas = new ArrayList<>();
    }
}
