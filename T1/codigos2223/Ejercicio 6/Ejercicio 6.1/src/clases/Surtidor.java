package clases;

public class Surtidor {

    private int capacidadTotal,capacidadActual;

    private String tipoGasolina;

    boolean funcionando = false;

    public Surtidor(int capacidadTotal, String tipoGasolina) {
        this.capacidadTotal = capacidadTotal;
        this.tipoGasolina = tipoGasolina;
        this.capacidadActual = capacidadTotal;
        this.funcionando = true;
    }
    public  Surtidor(String tipoGasolina) {
        this.tipoGasolina = tipoGasolina;
        this.capacidadTotal = 0;
        this.capacidadActual = 0;
        this.funcionando = false;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public String getTipoGasolina() {
        return tipoGasolina;
    }

    public void setTipoGasolina(String tipoGasolina) {
        this.tipoGasolina = tipoGasolina;
    }

    public boolean isFuncionando() {
        return funcionando;
    }

    public void setFuncionando(boolean funcionando) {
        this.funcionando = funcionando;
    }

    public void arreglar(){
        this.funcionando = true;
    }

    public void rellenar(int litros){
        if(this.capacidadActual + litros <= capacidadTotal)
        this.capacidadActual += litros;
        else System.out.println("La cantidad a rellenar sobrepasa la capacidad de este surtidor");
    }

    public void quitarGasolina(int litras){
        if(this.capacidadTotal - litras >= 0)
        this.capacidadTotal -= litras;
    }


}
