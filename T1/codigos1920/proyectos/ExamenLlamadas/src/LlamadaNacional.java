public class LlamadaNacional extends Llamada {


    public LlamadaNacional(int nOrigen, int nDestino, int duracion) {
        super(nOrigen, nDestino, duracion);
        caluclarCoste();
    }

    @Override
    public void caluclarCoste() {
        coste = duracion * 0.20;
    }
}
