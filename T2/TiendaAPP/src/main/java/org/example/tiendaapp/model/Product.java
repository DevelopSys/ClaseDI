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
}