package callback;

import java.util.Observable;
import java.util.Observer;

public class Comunicacion extends Observable {

    public Comunicacion() {
        super();
    }

    public void cambiarDatos(Object dato){
        setChanged();
        notifyObservers(dato);
    }
}
