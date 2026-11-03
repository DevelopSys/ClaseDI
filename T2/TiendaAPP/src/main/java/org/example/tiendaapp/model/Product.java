package org.example.tiendaapp.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private long id;
    private String title;
    private String description;
    private double price;
    private double discountPercentage;
    private long stock;

    public void mostrarDatos(){
        System.out.println("id = " + id);
        System.out.println("title = " + title);
        System.out.println("price = " + price);
    }
}