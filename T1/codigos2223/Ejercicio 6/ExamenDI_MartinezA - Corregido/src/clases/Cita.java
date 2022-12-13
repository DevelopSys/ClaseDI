package clases;

public class Cita {

    private int NSSPaciente;

    private String especialidad, comentario;

    private int numeroColegiatura;


    private int dia, mes;

    public Cita(int NSSPaciente, String especialidad, int numeroColegiatura, int mes, int dia,String comentairo) {
        this.NSSPaciente = NSSPaciente;
        this.especialidad = especialidad;
        this.comentario = comentairo;
        this.numeroColegiatura = numeroColegiatura;
        this.dia = dia;
        this.mes = mes;
    }

    public int getNSSPaciente() {
        return NSSPaciente;
    }

    public void setNSSPaciente(int NSSPaciente) {
        this.NSSPaciente = NSSPaciente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumeroColegiatura() {
        return numeroColegiatura;
    }

    public void setNumeroColegiatura(int numeroColegiatura) {
        this.numeroColegiatura = numeroColegiatura;
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


    public void mostrarDatos(){
        System.out.println("NSS del clases.Paciente: "+getNSSPaciente());
        System.out.println("Especialidad: "+getEspecialidad());
        System.out.println("Número de Colegiatura"+getNumeroColegiatura());
        System.out.println("Mes : "+getMes());
        System.out.println("Día : "+getDia());
        System.out.println("Comentario : "+getComentario());
    }
}
