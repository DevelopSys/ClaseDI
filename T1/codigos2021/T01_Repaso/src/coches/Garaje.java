package coches;

public class Garaje {

    private Coche coche;
    private int numeroCoches;
    private String averiaAsociada;

    public boolean aceptarCoche(Coche coche, String averia) {

        if (numeroCoches > 0) {
            System.out.println("No te puedo atender");
            return false;
        } else {
            System.out.println("He aceptado el coche");
            if (averia.equals("aceite")){
              coche.getMotor().setLitrosAceite(coche.getMotor().getLitrosAceite()+10);
            }
            this.coche = coche;
            this.averiaAsociada = averia;
            coche.acumularAverias();
            numeroCoches++;
            return true;
        }
    }

    public void devolverCoche() {
        if (coche!=null){
            numeroCoches = 0;
            this.averiaAsociada = null;
            this.coche = null;
        } else {
            System.out.printf("No tengo ningun cliente");
        }

    }
}
