package split;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControladoraVentana implements ChangeListener {

    Ventana ventana;

    public ControladoraVentana(Ventana ventana) {
        this.ventana = ventana;
        acciones();
    }

    private void acciones() {
    }

    @Override
    public void stateChanged(ChangeEvent e) {
    }
}

