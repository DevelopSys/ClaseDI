package clases;

public class Entrada {

    public static void main(String[] args) {
        //System.out.println("Lo que sea");
        //Persona persona = new Persona();
        //Persona personaDatos = new Persona("Borja","Martin","1234567A");
        //System.out.println(personaDatos.toString());
        //personaDatos.hablar("Hola que ase");
        Trabajador trabajador = new Trabajador("Borja","Martin","12345678Q",1234,12);
        Alumno alumno = new Alumno("Aasd","asd","asd",123);
        Jefe jefe = new Jefe("dfghj","dfghj","dfghj",123);

        trabajador.metodoGenerico();
        alumno.metodoGenerico();
        jefe.metodoGenerico();

        /*Jefe jefe1 = new Jefe("dfghj","dfghj","dfghj",123);
        Persona jefe2 = new Jefe("dfghj","dfghj","dfghj",123);
        Empleado jefe3 = new Jefe("dfghj","dfghj","dfghj",123);
        Object jefe4 = new Jefe("dfghj","dfghj","dfghj",123);*/

        Persona[] personas = {alumno,trabajador,jefe};
        Empleado[] empresa = {jefe,trabajador};

        for (Empleado item :empresa) {
            if (item instanceof Jefe){
                ((Jefe)item).mandar();
            } else if (item instanceof Trabajador){
                ((Trabajador)item).trabajar();
            }
        }






    }
}
