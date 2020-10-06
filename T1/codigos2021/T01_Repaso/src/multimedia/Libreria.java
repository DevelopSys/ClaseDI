package multimedia;

import com.sun.tools.corba.se.idl.StringGen;

import java.util.ArrayList;

public class Libreria {

    //Libro libro;
    //Pelicula pelicula;
    //ArrayList<Pelicula> listaPeliculas;
    //ArrayList<Libro> listaLibros;
    ArrayList<Multimedia> listaMultimedia;

    public Libreria(){
        System.out.println("Libreria inaugurada");
        listaMultimedia = new ArrayList();
    }

    public void agregarElemento(Multimedia multimedia){

        // 1,2,3,4,5,6,7,8
        // 5
        boolean existe = false;
        for (Multimedia item :listaMultimedia) {
            if (item.getCodigo() == multimedia.getCodigo()){
                // no se puede agregar
                System.out.println("No se puede agregar");
                existe = true;
                break;
            }
        }

        if (existe){
            System.out.println("Elemento duplicado");
        } else {
            System.out.println("Agregado correctamente");
            this.listaMultimedia.add(multimedia);
        }

    }
    public void borrarElemento(int codigo){
        /*for (Multimedia item :listaMultimedia) {
            if (item.getCodigo() == codigo){
                // lo borro
                System.out.println("borrado correctamente");
                //listaMultimedia.remove(item);
                break;
            }
        }*/

        for (int i = 0; i < listaMultimedia.size(); i++) {
            if (listaMultimedia.get(i).getCodigo() == codigo){
                // lo borro
                System.out.println("borrado correctamente");
                //listaMultimedia.remove(item);
                listaMultimedia.remove(i);
                break;
            }
        }
    }
}
