public class Particular extends Coche{

    private int cv;

    public Particular(String modelo, String matricula, double precio, int cv) {
        super(modelo, matricula, precio);
        this.cv = cv;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return "Particular{" +
                "cv=" + cv +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", precio=" + precio +
                '}';
    }
}
