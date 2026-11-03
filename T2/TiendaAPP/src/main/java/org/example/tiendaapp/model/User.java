package org.example.tiendaapp.model;

import java.util.ArrayList;

public class User {

    private Long id;
    private String name, surname, mail, password;
    private int profile;
    private ArrayList<Product> products;

    public User() {
    }

    public User(String name, String surname, String mail, String password, int profile) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
        this.profile = profile;
        products = new ArrayList<>();
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void clearList(){
        products.clear();
    }

    public double getTotal(){
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getProfile() {
        return profile;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return name + " "+surname;
    }
}
