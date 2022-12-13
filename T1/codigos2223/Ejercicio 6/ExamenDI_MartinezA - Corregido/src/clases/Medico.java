package clases;

import java.util.ArrayList;

public class Medico extends Persona {

    private int numeroC;

    private String especialidad;

    ArrayList<Cita> citasMedico = new ArrayList<Cita>();

    public Medico(String nombre, String apellido,String especialidad, String DNI, int numeroColegiado ) {
        super(nombre, apellido, DNI);
        this.numeroC = numeroColegiado;
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumeroColegiado() {
        return numeroC;
    }

    public void setNumeroColegiado(int numeroColegiado) {
        this.numeroC = numeroColegiado;
    }

    public boolean crearCita(Cita cita) {

        Cita aux = cita;

        int dia= cita.getDia();

        int mes = cita.getMes();

        if (isDisponible(mes,dia)) {
            this.citasMedico.add(cita);
            return true;
        }
        else  System.out.println("No hay disponibilidad para el día seleccionado");

        return false;
    }

    public boolean isDisponible(int mes, int dia) {

        if (citasMedico == null)
            return true;
        else for (int i = 0; i < citasMedico.size(); i++) {
            if (citasMedico.get(i).getMes() == mes && citasMedico.get(i).getDia() == dia)
                return false;
        }

        return true;

    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Especialidad :"+this.especialidad);
        System.out.println("Numero de Colegiatura: "+this.numeroC);
    }
}
