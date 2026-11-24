package com.example.centro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String name;
    @Column(nullable = false,length = 255)
    private String last;
    @Column(nullable = false,length = 255, unique = true)
    private String email;
    @Column
    private String studies;
    @Column
    private double salary;
    @Column
    private int phone;

    public Teacher(String name, String last, String email, String studies, double salary, int phone) {
        this.name = name;
        this.last = last;
        this.email = email;
        this.studies = studies;
        this.salary = salary;
        this.phone = phone;
    }
}
