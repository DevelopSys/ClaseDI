public class EstructurasArrays {

    // [0,0,0,0,0,0,0,0,0]
    private int[] numeros = new int[9];

    // quiero que el metodo admita la posicion que voy a tocar
    // dato que se incorpora en la posicion indicada
    // 6,7
    // si al metodo le dan una posicion mas mayor que la que se puede
    // aviso que hay fallo, y no lo hago
    public void incluirNumero(int posicion, int valor) {
        if (posicion > numeros.length - 1) {
            System.out.println("No hay posibilidad,fallo!!!!!");
        } else {
            numeros[posicion] = valor;
        }
    }

    // mostrar por consola todos los datos del array
    public void mostrarElementos() {
        for (int item : numeros) {
            System.out.printf("Valor %d%n", item);
        }
    }

    // quiero buscar un numero determinado.
    // para ello el metodo admitir el numero que quiero buscar dentro
    // del array y me dirá cuantos numeros iguales hay

    public void buscarRepetidos(int numeroBuscar) {
        int repetido = 0;
        for (int item : numeros) {
            if (item == numeroBuscar) {
                repetido++;
            }
        }
        System.out.printf("Del numero %d hay %d repetudos%n", numeroBuscar, repetido);
    }

    public boolean estaNumero(int numeroBuscar) {
        for (int item : numeros) {
            if (item == numeroBuscar) {
                return true;
            }
        }
        // 0-0.99999999999999999999
        // 
        return false;
    }

    // llenar el array con tantos numeros como posiciones tenga
    // de manera automatica, con numeros aleatorios 0-40
    
    // [0,0,0,0,0,0,0,0,0]
    public void rellenarArray(){
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random()*41);
        }
    }

    // obtener la suma de todos los valores del array
    // el numero medio generado -> decimal
    // el numero maximo generado
    // el numero minimo generado

    public void realizarCalculos(){
        int sumatorio =0;
        for ( int item: numeros ) {
            sumatorio +=item;
        }
        double media = (double) sumatorio/numeros.length;
        System.out.println("La media es "+media);

    }

}
