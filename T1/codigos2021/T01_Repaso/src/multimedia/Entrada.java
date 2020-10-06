package multimedia;

import com.sun.org.apache.xpath.internal.operations.Mult;

public class Entrada {

    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        //Multimedia multimedia = new Multimedia();

        libreria.agregarElemento(new Libro("los pilares de la tierra","KF",1990,1,5,200, "pdf"));
        libreria.agregarElemento(new Pelicula("La vida es bella","asd",2000,2,new String[]{},"asd",1));
        libreria.agregarElemento(new Pelicula("La vida es bella","asd",2000,2,new String[]{},"asd",1));
        libreria.borrarElemento(2);
    }
}
