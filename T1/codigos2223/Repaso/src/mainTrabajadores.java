import clases.*;

import java.util.ArrayList;

public class mainTrabajadores {

    public static void main(String[] args) {

        Autonomo autonomo = new Autonomo("Autonomo1","Apellido1","1234A",1234, 1000,100000);

        Asalariado asalariado = new Asalariado("Asalariado1","Apellido2",
                                "1234A",1234, 1000, 600, 3000);

        Jefe jefe = new Jefe("Jefe1","Apellido3","1234A",3456,'A');

        Empresa empresa = new Empresa("Retamar","0001A");



        ArrayList<Trabajador> listaEmpresa = new ArrayList<>();
        listaEmpresa.add(asalariado);
        listaEmpresa.add(autonomo);
        listaEmpresa.add(jefe);

        for (Trabajador trabajador : listaEmpresa){
            System.out.println("Mostrando los datos del trabajador: ");
            trabajador.mostrarDatos();
            System.out.println("Calcular jubilacion");
            trabajador.calcularJubilacion();

            if(trabajador instanceof Asalariado){
                ((Asalariado)trabajador).mostrarSueldoNeto(10);
            }
        }
    }
}
