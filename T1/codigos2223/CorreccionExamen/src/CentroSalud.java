import java.util.ArrayList;

public class CentroSalud {

    private ArrayList<Medico> listaMedicos;
    private ArrayList<Paciente> listaPacientes;

    public CentroSalud() {
        listaMedicos = new ArrayList<>();
        listaPacientes = new ArrayList<>();

    }

    private void contratarMedicos() {
        listaMedicos.add(new Medico("Nick", "traumatología", "Rivera", "001", 001));
        listaMedicos.add(new Medico("Hannibal", "digestivo", "Lecter", "002", 002));
        listaMedicos.add(new Medico("Sam", "psiquiatría", "Owens", "003", 003));
        listaMedicos.add(new Medico("Martin", "general", "Brenner", "004", 004));
        listaMedicos.add(new Medico("Stephen", "cirugía", "Strange", "005", 005));

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

}
