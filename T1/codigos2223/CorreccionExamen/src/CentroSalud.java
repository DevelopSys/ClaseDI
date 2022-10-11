import java.util.ArrayList;

public class CentroSalud {

    private ArrayList<Medico> listaMedicos;
    private ArrayList<Paciente> listaPacientes;

    public CentroSalud() {
        listaMedicos = new ArrayList<>();
        listaPacientes = new ArrayList<>();


    }

    public void contratarMedicos() {
        listaMedicos.add(new Medico("Nick", "traumatología", "Rivera", "001", 001));
        listaMedicos.add(new Medico("Hannibal", "digestivo", "Lecter", "002", 002));
        listaMedicos.add(new Medico("Sam", "psiquiatría", "Owens", "003", 003));
        listaMedicos.add(new Medico("Martin", "general", "Brenner", "004", 004));
        listaMedicos.add(new Medico("Stephen", "cirugía", "Strange", "005", 005));

    }

    public void registrarCita(int nss, int dia, int mes, int nColegiado, String especialidad, String comentario){
        // busco paciente
        Paciente paciente = existePaciente(nss);
        Medico medico = existeMedico(nColegiado);
        if (paciente!=null && medico!=null && medico.isDisponible(dia,mes) &&
                medico.getEspecialidad().equals(especialidad)){
            medico.regitrarCita(dia,mes);
            paciente.registrarCita(mes,dia,medico,comentario);
        } else {
            System.out.println("Problema a la hora de registrar la cita");
        }
    }

    public void listarMedicos(){
        for ( Medico item :listaMedicos) {
            item.mostrarDatos();
        }
    }

    public void listarEspecialidad(String especialidad){
        for (  Medico item: listaMedicos ) {
            if (item.getEspecialidad()
                    .equalsIgnoreCase(especialidad)){
                item.mostrarDatos();
            }
        }
    }

    public void registraPaciente(Paciente paciente){
        if (existePaciente(paciente.getNSS())== null){
            listaPacientes.add(paciente);
        } else {
            System.out.println("El paciente existe");
        }

    }

    private Paciente existePaciente(int nss){

        Paciente pacienteExiste = null;

        for (Paciente item :listaPacientes) {
            if (item.getNSS() == nss){
                pacienteExiste = item;
                return pacienteExiste;
            }
        }

        return pacienteExiste;
    }

    private Medico existeMedico(int nColegiado){

        Medico medicoExiste = null;

        for (Medico item :listaMedicos) {
            if (item.getnColegiado() == nColegiado){
                medicoExiste = item;
                return medicoExiste;
            }
        }

        return medicoExiste;
    }

}
