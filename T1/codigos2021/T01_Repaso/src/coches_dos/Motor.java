package coches_dos;

public class Motor {

    private int litrosAceite, cv;

    public Motor(int cv) {
        this.cv = cv;
        this.litrosAceite = 0;
    }

    public int getLitrosAceite() {
        return litrosAceite;
    }

    public int getCv() {
        return cv;
    }

    public void setLitrosAceite(int litrosAceite) {
        this.litrosAceite = litrosAceite;
    }
}
