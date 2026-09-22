package model;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {
    // private static Long serialVersionUID = 1234L;
    private String name, surname, email, dni;

    public Person(){}

    public Person(String name, String surname, String email, String dni) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dni = dni;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
