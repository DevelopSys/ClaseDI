package callback;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class Panel2 extends JPanel implements Observer {

    JLabel etiqueta;

    public Panel2() {

        instancias();
        initGUI();
    }

    private void initGUI() {
        this.add(etiqueta);
    }

    private void instancias() {
        etiqueta = new JLabel("Nombre");
    }

    public JLabel getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void update(Observable o, Object arg) {
        getEtiqueta().setText(arg.toString());
    }
}
