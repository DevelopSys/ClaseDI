package utils;

public enum Prioridad {
    baja("verde", 1), alta("rojo", 3), media("narajna", 2);

    private String color;
    private int valor;

    Prioridad(String color, int valor) {
        this.color = color;
        this.valor = valor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
