package model;

public class Libro extends Multimedia {

    // getter y setter
    // mostrarDatos
    // 1 construtor

    private String isbn;
    private int nPaginas;

    public Libro() {
    }

    public Libro(int id, String titulo, String autor, int tamanio, String formato, String isbn, int nPaginas) {
        super(id, titulo, autor, tamanio, formato);
        this.isbn = isbn;
        this.nPaginas = nPaginas;
    }

    public void metodoCalificarLibro(){

    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("isbn = " + isbn);
        System.out.println("nPaginas = " + nPaginas);
    }

    @Override
    public int calificar() {
        if (nPaginas < 100)
            return 1;
        else if (nPaginas < 200)
            return 2;
        return 3;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }
}
