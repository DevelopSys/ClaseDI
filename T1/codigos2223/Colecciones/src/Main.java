import model.CocheM;

public class Main {

    public static void main(String[] args) {

        // marca, modelo, km, bastidor,vel:60
        CocheM coche1 = new CocheM("Ford", "Focus",1234);
        // marca, modelo, km, bastidor,vel:20
        CocheM coche2 = new CocheM("Ford", "Fiesta",2345);
        // marca, modelo, km, bastidor,vel
        CocheM coche3 = new CocheM("Ford", "Fiesta");

        coche1.acelerar(10);
        coche1.acelerar(50);

        coche2.acelerar(20);

        System.out.println(coche1.getVelocidad());

        coche1.frenar();

        coche2.frenar();

        coche3.frenar();

    }
}
