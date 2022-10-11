public class Entrada {


    public static void main(String[] args) {
        CentroSalud centroSalud = new CentroSalud();
        centroSalud.contratarMedicos();

        centroSalud.registraPaciente(new Paciente( "dni",  "nombre",  "apellido",123));
        centroSalud.registraPaciente(new Paciente( "dni",  "nombre",  "apellido",234));
        centroSalud.registraPaciente(new Paciente( "dni",  "nombre",  "apellido",345));
        centroSalud.registraPaciente(new Paciente( "dni",  "nombre",  "apellido",456));

        centroSalud.registrarCita(123,1,1,002,"digestivo","comentario");
        centroSalud.registrarCita(123,1,1,003,"psiquiatría","comentario");
        centroSalud.registrarCita(123,1,1,003,"psiquiatría","comentario");

    }


}
