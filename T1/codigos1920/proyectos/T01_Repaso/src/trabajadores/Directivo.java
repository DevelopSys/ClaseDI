package trabajadores;

public interface Directivo {

    // variables son CONTANTES
    // métodos solo tienen la firma

    default void presentacion(){
        System.out.println("PRESENTACIÓN DEL DIRECTIVO");
    }
    public void mandarMensaje(String s);
    public int emitirVoto(int v);
}
