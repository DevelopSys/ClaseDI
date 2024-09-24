package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coche {

    // variables -> privadas -> encapsulamiento
    private String  matricula,marca, modelo;
    private int cv;
    private double arreglos;
    // constructor -> 0 a n
        // siempre hay 1 constructor vacio (hasta que escriba un consctructor)

    public Coche(String matricula, String marca, String modelo, int cv) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
    }

    public void mostrarDatos(){
        System.out.println("matricula = " + matricula);
        System.out.println("marca = " + marca);
        System.out.println("modelo = " + modelo);
        System.out.println("cv = " + cv);
        System.out.println("arreglos = " + arreglos);
    }

}
