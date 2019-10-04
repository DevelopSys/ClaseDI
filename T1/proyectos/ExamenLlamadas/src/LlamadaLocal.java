public class LlamadaLocal extends Llamada{


    public LlamadaLocal(int nOrigen, int nDestino, int duracion) {
        super(nOrigen, nDestino, duracion);
        caluclarCoste();
    }

    @Override
    public void caluclarCoste() {
        coste = 0;
    }
}
