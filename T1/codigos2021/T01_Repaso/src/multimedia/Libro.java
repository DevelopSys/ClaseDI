package multimedia;

public final class Libro extends Multimedia {

    private int edicion, numPaginas;
    private String soporte;

    public Libro(String titulo, String autor, int anio, int codigo, int edicion, int paginas, String soporte) {
        super(titulo, autor, anio, codigo);
        /*
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.codigo = codigo;
        * */
        this.edicion = edicion;
        this.numPaginas = paginas;
        this.soporte = soporte;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getSoporte() {
        return soporte;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }

    @Override
    public String toString() {
        return super.toString() + "edicion: "+edicion+" paginas: "+numPaginas+" soporte: "+soporte;
    }
}
