// importaciones
// paquetes
// no puede haber NADA
// COMENTARIO DE DOCUMENTACION
public class Entrada {

    private int valorClase = 3;
    static int valorClase2 = 3;

    // variables -> no inicializadas
    // segun su tipo -> simples / complejas
    // la vida de su valor asociado -> constantes (final -> EN MAYUSCULAS) y aquellas que pueden cambiar
    // segun su ambito -> de bloque o variable de clase

    //public Entrada(int cosa){}
    //public Entrada(){}
    // constructores -> 1 (vacio)
    // public Entrada(){}
    // metodos - propios
    public static void main(String[] args) {
        // new Entrada(5);
        // this.
        // int valor = 5;
        // Integer valor2 = 5;
        // Scanner scanner = new Scanner(System.in);
        // IF (decision en cascada) - SWITCH
        // IF -> normal if elseif else o ternario
        // valor =  condicion ? true : false
        // switch(){} -> int, string, char
        /*int nota = 8;
        char letra = 'a';
        String mensaje;
        switch (letra) {
            case 'v':
                // codigo
                mensaje = "asd";
                break;
            case 'a':
                mensaje = "asd";
                // codigo
                break;
            case 3:
                mensaje = "asd";
                // codigo
                break;
            case 4:
                mensaje = "asd";
                // codigo
                break;
            case 5:
                mensaje = "asd";
                // codigo
                break;
            case 6:
                mensaje = "asd";
                // codigo
                break;
        }
        System.out.println(mensaje);*/
        // FOR : recorrer conjuntos marco inicio y fin -> puedo hacer modificaciones de la coleccion
        // FOREACH : recorrer coojuntos de forma completa -> no puedo puedo hacer modicaciones en el tamaño de la coleccion

        // [0..10) -> i
        int[] numeros = {1, 3, 4, 5, 6, 7, 8, 9};
        /*for (int i = 0; i < 10; i++) {
            System.out.println(numeros[i]);
        }*/
        for (int item : numeros) {
            if (item % 2 == 0) {
                break;
            }
        }
        // while -> n
        // do-while -> ejecuto de 1 a n



        int opcion = -1234567;
        do {
            opcion =3;
            // modica el valor o valores de la condicion
        } while (opcion!=5);


    }

    /*public void metodo(){
        valorClase = 9;
        metodo2(8);
        metodo2(5);
        metodo2(2);
        metodo2(1);
    }
    public void metodo2(int valocaClase){

        this.valorClase = 9;
        valorClase = 3;
    }*/

    // getter y setter
}
