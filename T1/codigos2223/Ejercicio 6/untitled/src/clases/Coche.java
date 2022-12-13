public class Coche {

    String tipoGasolina;

    int litrosDeposito;

    public Coche(String tipoGasolina) {
        this.tipoGasolina = tipoGasolina;
        this.litrosDeposito = 0;
    }

    public void ponerGasolida(Surtidor surtidor, int litros){
        if(!(surtidor.isFuncionando())) {
            System.out.println("El surtidor está fuera de servicio");
        }

        else if(this.tipoGasolina != surtidor.getTipoGasolina())
            {
                System.out.println("El tipo de gasolina de este surtidor es distinto a la de tu coche");
            }

        else surtidor.quitarGasolina(litros);
    }
}
