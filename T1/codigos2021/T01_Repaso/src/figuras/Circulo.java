package figuras;

public final class Circulo {

    private int x,y;
    private double radio;
    private double area, diametro;

    public Circulo(int x, int y, double radio) {
        this.x = x;
        this.y = y;
        this.radio = radio;
    }

    public double calcularArea(){
        this.area = Math.PI * (radio*radio);
        return area;
        //Math.pow(radio,2);
    }

    public void calcularDiametro(){
        this.diametro = 2*radio;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }
}
