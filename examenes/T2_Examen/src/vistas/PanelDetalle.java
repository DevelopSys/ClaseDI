package vistas;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PanelDetalle extends JPanel {

    JComboBox comboModulos;
    DefaultComboBoxModel modeloCombo;
    JList listaAsignaturasModulos;
    DefaultListModel modeloLista;

    public PanelDetalle(LayoutManager layout) {
        super(layout);
        instancias();
        initGUI();
    }

    private void initGUI() {
        this.add(comboModulos,BorderLayout.NORTH);
        this.add(new JScrollPane(listaAsignaturasModulos), BorderLayout.CENTER);
    }

    private void instancias() {
        modeloCombo = new DefaultComboBoxModel();
        comboModulos = new JComboBox(modeloCombo);
        modeloLista = new DefaultListModel();
        listaAsignaturasModulos = new JList(modeloLista);
    }

    public JComboBox getComboModulos() {
        return comboModulos;
    }

    public DefaultComboBoxModel getModeloCombo() {
        return modeloCombo;
    }

    public JList getListaAsignaturasModulos() {
        return listaAsignaturasModulos;
    }

    public DefaultListModel getModeloLista() {
        return modeloLista;
    }
}
