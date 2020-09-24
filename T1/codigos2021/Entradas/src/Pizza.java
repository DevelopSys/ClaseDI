public class Pizza {

    private String tamanio, tipo;
    static int pedidas=0, servidas=0;
    boolean estado;

    public Pizza(String tipo, String tamanio) {
        this.tamanio = tamanio;
        this.tipo = tipo;
        this.estado = true;
        pedidas++;
    }

    public void sirve(){
        System.out.println("Esta pizza se ha servido");
        this.estado = true;
        servidas++;
    }

    public static int getTotalPedidas(){
        return pedidas;
    }

    public static int getTotalServidas(){
        return servidas;
    }

    @Override
    public String toString() {

        String estadoPizza = "pedida";

        if (!estado){
            estadoPizza = "servida";
        }

        return "Pizza{" +
                "tamanio='" + tamanio + '\'' +
                ", tipo='" + tipo + '\'' +
                ", estado=" + estadoPizza +
                '}';
    }
}
