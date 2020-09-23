package trabajadores;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Entrada {

    public static void main(String[] args) {


        Empresa empresa = new Empresa();
        Trabajador autonomo = new Autonomo("NAut","AAut","123",1);
        Trabajador asalariado = new Asalariado("NAs","AAs","1234",1,15);
        Asalariado asalariadoDos = new Asalariado("NAs","AAs","12345",1,15);
        empresa.registrarTrabajador(asalariado);
        empresa.registrarTrabajador(autonomo);
        empresa.registrarTrabajador(asalariadoDos);
        Gerente gerente = new Gerente("NGe","AGe","12333",123);
        empresa.registrarTrabajador(gerente);
        Socio socio = new Socio("NSocio","ASocio","123asd");
        Directivo director = new Director("NDirector","ADirector","123123123123");
        // Trabajador directorDos = new Directivo();
        // empresa.registrarTrabajador(socio);
        // empresa.registrarTrabajador(director);
        asalariadoDos.metodoPropio();
        empresa.registarVoto(socio.emitirVoto(5));
        empresa.registarVoto(director.emitirVoto(6));
        empresa.registarVoto(gerente.emitirVoto(8));
        Asalariado asalariadoTres = new Asalariado("NAs","AAs",
                "12345",1,15);
        asalariadoTres.monstarDatos();




    }
}
