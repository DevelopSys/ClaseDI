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
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 50)
    private String sign;
    @Column
    private int time;
    @Column
    private int level;

    public Course(String name, String sign, int time, int level) {
        this.name = name;
        this.sign = sign;
        this.time = time;
        this.level = level;
    }
}
