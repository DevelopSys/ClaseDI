package multiplicaciones;

import java.util.Arrays;

public class MainMultiplicaciones {

    public static void main(String[] args) {

        

        for (int i = 0; i < 11; i++) {
            System.out.println("Tabla del " + i);
            for (int j = 0; j < 11; j++) {
                System.out.printf("\t %d * %d = %d%n", i, j, i * j);
            }

        }
    }
}
