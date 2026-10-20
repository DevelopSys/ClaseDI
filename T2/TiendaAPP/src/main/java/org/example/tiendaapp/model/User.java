package org.example.tiendaapp.model;

public class User {

    private Long id;
    private String name, surname, mail;
    private int profile;

    public User() {
    }

    public User(String name, String surname, String mail, int profile) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.profile = profile;
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

    public void setProfile(int profile) {
        this.profile = profile;
    }
}
