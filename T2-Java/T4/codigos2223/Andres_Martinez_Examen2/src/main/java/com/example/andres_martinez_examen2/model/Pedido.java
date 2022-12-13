package com.example.andres_martinez_examen2.model;

import java.util.ArrayList;

public class Pedido {

    int id;
    Cliente cliente;
    ArrayList<Pizza> pizzas;

    public Pedido(int id, Cliente cliente, ArrayList<Pizza> pizzas) {
        this.id = id;
        this.cliente = cliente;
        this.pizzas = pizzas;
    }

    void mostrarDatos(){
        System.out.println("Pedido "+this.id+": ");
        System.out.println("Cliente: "+this.cliente.getNombre());
        System.out.println();
        System.out.println("Pizzas: ");
        System.out.println();
        for (int i = 0; i < pizzas.size(); i++) {
            pizzas.get(i).mostrarDatos();
        }
        System.out.println("Total: "+calcularTotal());
        System.out.println("Entregado.");
    }


    int calcularTotal(){

        int total = 0;

        for (int i = 0; i < pizzas.size() ; i++) {
            total = total + i;
        }

        return total;
    }
    
}
