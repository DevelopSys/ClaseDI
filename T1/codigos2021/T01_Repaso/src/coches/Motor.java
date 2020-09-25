package coches;

public class Motor {
    private int cv, litrosAceite;

    public Motor(int cv){
        this.cv=cv;
        this.litrosAceite = 0;
    }

    public void setLitrosAceite(int litrosAceite) {
        this.litrosAceite = litrosAceite;
    }

    public int getCv() {
        return cv;
    }

    public int getLitrosAceite() {
        return litrosAceite;
    }
}
