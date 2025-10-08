import model.Asalariado;
import model.Autonomo;
import model.Persona;
import model.Trabajador;

public class Main {

    public static void main(String[] args) {
        //Persona persona = new Persona("123A","Borja","Martin",41);
        // persona.mostrarDatos();

        /*Trabajador trabajador = new Trabajador("123A", "Borja", "Martin", 41,
                "borja@gmail.com", 123123, 123123, 20000.0);
        trabajador.mostrarDatos();*/

        Asalariado asalariado = new Asalariado("123A", "Borja", "Martin", 41,
                "borja@gmail.com", 123123, 123123, 20000.0,0.5,14);
        Autonomo autonomo = new Autonomo("123A", "Borja", "Martin", 41,
                "borja@gmail.com", 123123, 123123, 20000.0,500);
        // autonomo.aplicarDescuento(50);
        // autonomo.aplicarDescuento(10);
        autonomo.calcularSalarioNeto();
        // autonomo.mostrarDatos();
    }
}
