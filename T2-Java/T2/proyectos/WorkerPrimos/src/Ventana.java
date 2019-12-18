import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {


    PanelPrimos panelPrimosUno, panelPrimosDos;


    public Ventana() throws HeadlessException {
        initGUI();
        setVisible(true);
    }

    private void initGUI() {
        instancias();
        configurarPanel();
    }

    private void configurarPanel() {
        this.getContentPane().setLayout(new GridLayout(1,2));
        this.getContentPane().add(panelPrimosUno);
        this.getContentPane().add(panelPrimosDos);
    }

    private void instancias() {
        panelPrimosUno = new PanelPrimos();
        panelPrimosDos = new PanelPrimos();
    }
}
