package entradas;

public class Ticket {

    private int precio, tipo;
    int cantidad;

    // 1 --> general :10
    // 2 --> compra-venta:20
    // 3 --> vip:30

    public Ticket(int precio, int tipo) {
        this.precio = precio;
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public int getTipo() {
        return tipo;
    }
}
