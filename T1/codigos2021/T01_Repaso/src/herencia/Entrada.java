package herencia;

public class Entrada {

    public static void main(String[] args) {
        // Persona persona = new Persona("Borja","Martin","123456789A");
        Persona trabajador = new Trabajador("Borja","Martin","12345678A",3000,10);
        Alumno alumno = new Alumno("Pepe","Martin","12345678X",5.6);

        trabajador.metodoGenerico();
        alumno.metodoGenerico();
        Trabajador trabajador1 = (Trabajador)trabajador;
        System.out.println(trabajador1.getSueldo());
    }
}
