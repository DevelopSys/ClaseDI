package model;

public class Encargo {
    private int id;
    private String descripcion;
    private boolean completada;

    public Encargo(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        // completada = false;
    }

    public Encargo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Encargo{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completada +
                '}';
    }
}
