import java.util.ArrayList;
import java.util.Scanner;

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
    public void estructuraSwitch(){

        int opcion=0;
        Scanner lecturaTeclado = new Scanner(System.in);

        String caso = "";
        do{
            System.out.println("1. Opcion1");
            System.out.println("2. Opcion2");
            System.out.println("3. Opcion3");
            System.out.println("4. Opcion4");
            System.out.println("5. Salir");
            //1
            opcion = lecturaTeclado.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("caso1");
                    // submenu
                    opcion = lecturaTeclado.nextInt();
                    switch (opcion){
                        case 1:
                            break;
                        case 2:
                            break;
                            //3 4 5
                    }
                    break;
                case 2:
                    System.out.println("caso2");
                    break;
                case 3:
                    System.out.println("caso3");
                    break;
                case 4:
                    System.out.println("caso4");
                    break;
            }
            // menu
        }while (opcion!=5);
    }
    public void estructuraBreak(){
        int[] numeros = new int[]{1,2,3,4,5,6,7,8,9,10};
        for (int item:numeros) {
            if (item == 7){
                break;
            }
        }
    }
    public boolean estructuraBreak2(String elemento){

        ArrayList<String> elementos = new ArrayList<>();
        // 10 palabras
        for (String item: elementos) {
            if (item.equals(elemento)){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        if (new Main().estructuraBreak2("ejemplo")){
            System.out.println("La palabra se ha encontado");
        };
        //new Main().estructuraSwitch();
        //new Main().estructuraFor();
    }
}