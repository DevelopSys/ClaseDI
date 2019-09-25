package trabajadores;

public abstract class Trabajador {


    public String nombre, apellido, dni;
    public int sueldo;
    public double sueldoMes;


    public Trabajador(String nombre, String apellido, String dni, int sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sueldo = sueldo;
    }

    public void monstarDatos() {
        System.out.printf("Nombre %s \n", nombre);
        System.out.printf("Apellido %s \n", apellido);
        System.out.printf("DNI %s \n", dni);
        System.out.printf("Sueldo anual %d \n", sueldo);
        System.out.printf("Sueldo mes %d \n",sueldoMes);

    }

    public abstract void calcularSalario();


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public double getSueldoMes() {
        return sueldoMes;
    }

    public void setSueldoMes(double sueldoMes) {
        this.sueldoMes = sueldoMes;
    }
}
