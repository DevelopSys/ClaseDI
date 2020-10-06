import java.util.ArrayList;

public class Concesionario {

    private ArrayList<Trabajador> trabajadores;
    private ArrayList<Coche> coches;

    public Concesionario() {
        trabajadores = new ArrayList<>();
        coches = new ArrayList<>();
        trabajadores.add(new Trabajador(1, "Roberto", "1234A", "1234"));
        trabajadores.add(new Trabajador(2, "Jose", "1234A", "1234"));
        coches.add(new Particular("Ford", "1234", 10000, 100));
        coches.add(new Particular("Open", "2345", 15000, 100));
        coches.add(new Comercial("Mercedes", "3456", 20000, 100));
        coches.add(new Comercial("Audi", "4567", 30000, 100));
    }


    public boolean realizarLogin(int id, String pass){
        for (Trabajador item:trabajadores) {
            if (item.getId() == id){
                if(item.getClave().equals(pass)){
                    // encontrado y login
                    return true;
                }
            }
        }
        return false;
    }

    public void listarCoches(){
        for (Coche item:coches) {
            System.out.println(item.toString());
        }
    }

    public void buscarCoche(String matricula){

        for (Coche item:coches) {
            if (item.getMatricula().equals(matricula)){
                System.out.println(item);
                break;
            }
        }
    }

    public double obtenerCosteMarca(String marca){

        double coste = 0;
        
        for (Coche item:coches) {
            
            if (item.getModelo().toUpperCase().equals(marca.toUpperCase())){
                coste = item.getPrecio();
                break;
            } 
            
        }
        
        return coste;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }
}
