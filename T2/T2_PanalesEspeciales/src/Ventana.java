import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    JTabbedPane panelPestanias;
    JPanel panelPenstaniaUno;
    JPanel panelPenstaniaDos;
    Container container;

    public Ventana() throws HeadlessException {
        instancias();
        initGUI();
        ControladoraVentana controladoraVentana = new ControladoraVentana(this);

    }

    public Ventana(String dato){
        this.setTitle(dato);
        instancias();
        initGUI();
        ControladoraVentana controladoraVentana = new ControladoraVentana(this);

    }

    private void instancias() {
        panelPestanias = new JTabbedPane();
        container = getContentPane();
        panelPenstaniaUno = new JPanel();
        panelPenstaniaUno.setBackground(Color.blue);
        panelPenstaniaDos = new JPanel();
        panelPenstaniaDos.setBackground(Color.YELLOW);
    }

    private void initGUI() {

        container.add(panelPestanias);
        panelPestanias.addTab("Pestaña1",null,panelPenstaniaUno,"tooltip1");
        panelPestanias.addTab("Pestaña2",null,panelPenstaniaDos,"tooltip2");


        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }

    public JTabbedPane getPanelPestanias() {
        return panelPestanias;
    }
}
