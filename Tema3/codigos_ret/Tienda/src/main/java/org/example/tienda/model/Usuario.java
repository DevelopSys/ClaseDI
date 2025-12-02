package org.example.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private int id;
    private String nombre, correo, pass;
    private int idPerfil;

    public Usuario(String nombre, String correo, String pass,
                   int idPerfil) {
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
        this.idPerfil = idPerfil;
    }
}
