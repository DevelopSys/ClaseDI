import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControladoraVentana implements ChangeListener{

    Ventana ventana;

    public ControladoraVentana(Ventana ventana) {
        this.ventana = ventana;
        acciones();
    }

    private void acciones() {
        ventana.getPanelPestanias().addChangeListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        System.out.println(ventana.getPanelPestanias().getSelectedIndex());
        if (ventana.getPanelPestanias().getSelectedIndex()==1){
            Ventana ventana = new Ventana("Titulo");
        }
    }
}
