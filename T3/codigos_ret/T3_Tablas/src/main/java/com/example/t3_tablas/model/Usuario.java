package com.example.t3_tablas.model;

public class Usuario {

    private String first, last, email,country,gender,thumbnail;
    private String phone;


    public Usuario(String first, String last, String email,
                   String country, String gender, String thumbnail, String phone) {
        this.first = first;
        this.last = last;
        this.email = email;
        this.country = country;
        this.gender = gender;
        this.thumbnail = thumbnail;
        this.phone = phone;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
