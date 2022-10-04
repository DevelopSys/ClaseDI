public class CitaPaciente {

    private int dia, mes;
    // MEDICO --> especialidad
    private String comentario;
    private Medico medico;

    public CitaPaciente(int dia, int mes, String comentario, Medico medico) {
        this.dia = dia;
        this.mes = mes;
        this.comentario = comentario;
        this.medico = medico;
    }

    public void mostrarDatos(){
        System.out.println("Dia: "+dia);
        System.out.println("Mes: "+mes);
        System.out.println("Comentario: "+comentario);
        System.out.println("Medico: "+medico.getNombre());
        System.out.println("Especialidad: "+medico.getEspecialidad());
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
