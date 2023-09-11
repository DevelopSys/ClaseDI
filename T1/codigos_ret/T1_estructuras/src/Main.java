// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public void estructuraFor(){

        int[] numeros = new int[]{1,2,3,4,5,6,7,8,9};

        for ( int num : numeros ) {
            System.out.println("Ejecutando");
            if (num==7){
                System.out.println("Encontrado");
                break;
            }
        }

        /*for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }*/
    }

    public static void main(String[] args) {
        new Main().estructuraFor();
    }
}