public class Trabajador {

    private int id;
    private String nombre, dni, clave;
    private double sueldo;

    public Trabajador(int id, String nombre, String dni, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.clave = clave;
        this.sueldo = 1200;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Trabajadores{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", clave='" + clave + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}
