import model.*;

import java.util.ArrayList;

public class MainTrabajadores {

    public static void main(String[] args) {



        Autonomo autonomo = new Autonomo("Autono1","Apellido1","1234A",
                1234,1000,10000);
        Asalariado asalariado = new Asalariado("Asalariado1", "Apellido2",
                "2345A",2345, 15,600,3000);
        Jefe jefe = new Jefe("Jefe1","Apelldo3","3456A",3456,
                'A');
        Empresa empresa = new Empresa("Retamar","0001A");

        empresa.contratarTrabajador(asalariado);
        empresa.contratarTrabajador(autonomo);
        empresa.contratarTrabajador(jefe);


        /*ArrayList<Trabajador> listaEmpresa = new ArrayList<>();
        listaEmpresa.add(asalariado);
        listaEmpresa.add(autonomo);
        listaEmpresa.add(jefe);

        for ( Trabajador trabajador : listaEmpresa ) {
            System.out.println("Mostrando los datos del trabajador");
            trabajador.mostrarDatos();
            System.out.println("Calcular jubilación");
            trabajador.calcularJubilacion();

            if (trabajador instanceof Asalariado){
                ((Asalariado)trabajador).mostrarSuledoNeto(10);
            }

        }*/

    }
}
