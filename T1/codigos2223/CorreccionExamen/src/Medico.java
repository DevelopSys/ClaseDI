import java.util.ArrayList;

public class Medico extends Persona{

    private int nColegiado;
    private String especialidad;
    private ArrayList<String> listaCitas;
    // 9-10
    // 10-9


    public Medico( String nombre, String especialidad,String apellido, String dni,int nColegiado) {
        super(dni, nombre, apellido);
        this.nColegiado = nColegiado;
        this.especialidad = especialidad;
    }

    public int getnColegiado() {
        return nColegiado;
    }

    public void regitrarCita(int dia,int mes){
        listaCitas.add(dia+"/"+mes);
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("NColegiado: "+nColegiado);
        System.out.println("Especialidad: "+especialidad);
        if (!listaCitas.isEmpty()){
            System.out.println("Citas  registradas: "+especialidad);
            for (String item:listaCitas) {
                // 9/10 --> ["9","10"]
                System.out.println("\tDia "+item.split("/")[0]);
                System.out.println("\tMes "+item.split("/")[1]);
            }

        }
    }

    public void setnColegiado(int nColegiado) {
        this.nColegiado = nColegiado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<String> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(ArrayList<String> listaCitas) {
        this.listaCitas = listaCitas;
    }
}
