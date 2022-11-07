package com.pestanias.pestanias.model;

public class UsuarioJSON {

    private String title, first, last, email, imagen, phone;

    public UsuarioJSON(String title, String first, String last, String email, String imagen, String phone) {
        this.title = title;
        this.first = first;
        this.last = last;
        this.email = email;
        this.imagen = imagen;
        this.phone = phone;
    }

    public void mostrarDatos(){
        System.out.printf("Nombre: %s %s %s%n",title,first,last);
        System.out.printf("Email: %s %n",email);
        System.out.printf("Phone: %s %n",phone);
        System.out.printf("Image: %s %n",imagen);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s",title,first,last);
    }
}
