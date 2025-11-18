package org.example.formularioapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private String nombre, apellido, correo, genero;
    private int edad;
    private boolean disponibilidad;

    @Override
    public String toString() {
        return nombre+" "+apellido;
    }
}
