import java.util.ArrayList;


public class Gasolinera {

    String nombre;

    ArrayList<Surtidor> surtidores;

    int ganancias;

    public Gasolinera(String nombre) {
        this.nombre = nombre;
        this.ganancias = 0;
        this.surtidores = new ArrayList<Surtidor>();
    }

    public void agregarSurtidor(Surtidor surtidor){
            surtidores.add(surtidor);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Surtidor> getSurtidores() {
        return surtidores;
    }

    public void setSurtidores(ArrayList<Surtidor> surtidores) {
        this.surtidores = surtidores;
    }

    public int getGanancias() {
        return ganancias;
    }

    public void setGanancias(int ganancias) {
        this.ganancias = ganancias;
    }
}
