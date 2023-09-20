package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Usuario {

    // propiedades - attr
    private int id;
    private String nombre, apellido;
    private int telefono;
    private String dni;

    // metodos - constructores


    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void mostrarDatos(){
        System.out.println("Los datos del usuario son");
        System.out.println("\tNombre: "+getNombre());
        System.out.println("\tApellido: "+getApellido());
        System.out.println("\tDNI: "+getDni());
        System.out.println("\tTelefono: "+getTelefono());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono=" + telefono +
                ", dni='" + dni + '\'' +
                '}';
    }
}
