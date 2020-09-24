public class Entrada {

    public static void main(String[] args) {
        Pizza p1 = new Pizza("margarita", "mediana");
        Pizza p2 = new Pizza("funghi", "familiar");
        Pizza p3 = new Pizza("cuatro quesos", "mediana");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        p2.sirve();
        System.out.println("pedidas: " + Pizza.getTotalPedidas());
        System.out.println("servidas: " + Pizza.getTotalServidas());
    }

        /*
        * pizza margarita mediana, pedida
        pizza funghi familiar, servida
        pizza cuatro quesos mediana, pedida
        esa pizza ya se ha servido
        pedidas: 3
        servidas: 1
        * */

}
