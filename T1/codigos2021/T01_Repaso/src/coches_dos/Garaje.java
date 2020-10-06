package coches_dos;

public class Garaje {

    private Coche coche;
    private String averiaAsociada;
    private int numeroCoches;

    public boolean aceptarCoche(Coche coche, String averia){

        if(numeroCoches>0){
            System.out.println("No puedo atenderte");
            return false;
        } else {
            System.out.println("Atendiendo coche");
            coche.incrementarAveria();
            if (averia.equals("aceite")){
                coche.getMotor().setLitrosAceite(coche.getMotor().getLitrosAceite()+10);
            }
            numeroCoches++;
            return true;
        }
    }

    public void devolverCoche(){
        numeroCoches--;
    }
}
