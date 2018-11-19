public class Persona {

    String nombre, apellido;
    int telefono;
    boolean situacion;

    public Persona(String nombre, String apellido, boolean situacion, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.situacion = situacion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public boolean getSituacion() {
        return situacion;
    }

    public int getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
