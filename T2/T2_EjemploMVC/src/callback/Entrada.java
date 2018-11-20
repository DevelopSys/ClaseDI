package callback;

import javax.swing.*;

public class Entrada {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana v = new Ventana();
                ControladoraVentana controladoraVentana = new ControladoraVentana(v);
            }
        });
    }
}
