package model;

abstract public class Multimedia {
    private int id;
    private String titulo, autor;
    private int tamanio;
    private String formato;

    public Multimedia() {
    }

    public Multimedia(int id, String titulo){

    }
    public Multimedia(int id, String titulo, String autor, int tamanio, String formato) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.tamanio = tamanio;
        this.formato = formato;
    }

    public void mostrarDatos(){
        System.out.println("id = " + id);
        System.out.println("titulo = " + titulo);
        System.out.println("autor = " + autor);
        System.out.println("tamanio = " + tamanio);
        System.out.println("formato = " + formato);
    }

    // una funcionalidad que esta presente en todos los multimedia, pero no se como funciona -> abs
    abstract public int calificar();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
