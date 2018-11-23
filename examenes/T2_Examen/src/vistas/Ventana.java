package vistas;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    JTabbedPane panelPestanias;
    PanelConstruir panelConstruir;
    PanelDetalle panelDetalle;
    Container container;

    public Ventana() throws HeadlessException {
        instancias();
        initGUI();
    }

    private void initGUI() {
        panelConstruir.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelPestanias.addTab("Agregar",null,panelConstruir,"Agregar módulo");
        panelPestanias.addTab("Detalle",null,panelDetalle,"Detalle de módulos");
        container.add(panelPestanias);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }

    private void instancias() {
        panelConstruir = new PanelConstruir(new GridBagLayout());
        container = getContentPane();
        panelPestanias = new JTabbedPane();
        panelDetalle = new PanelDetalle(new BorderLayout());
    }

    public JTabbedPane getPanelPestanias() {
        return panelPestanias;
    }

    public PanelConstruir getPanelConstruir() {
        return panelConstruir;
    }

    public PanelDetalle getPanelDetalle() {
        return panelDetalle;
    }
}
