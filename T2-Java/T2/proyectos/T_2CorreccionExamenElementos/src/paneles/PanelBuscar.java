package paneles;

import utils.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PanelBuscar extends JPanel {

    DefaultComboBoxModel modeloCombo;
    JLabel labelMedia;
    JComboBox comboBox;

    public PanelBuscar(){
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }

    private void configurarPanel() {
        this.setLayout(new GridBagLayout());
        configurarConstrait(0,0,1,1,0.5,0,GridBagConstraints.CENTER, GridBagConstraints.NONE, new JLabel("Alumno"));
        configurarConstrait(1,0,1,1,0.5,0,GridBagConstraints.CENTER, GridBagConstraints.NONE, comboBox);
        configurarConstrait(0,1,2,1,1,0,GridBagConstraints.CENTER, GridBagConstraints.NONE, labelMedia);

    }


    private void configurarConstrait(int x, int y, int tx, int ty, double px, double py , int anchor, int fill, Component c){

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = tx;
        constraints.gridheight = ty;
        constraints.weightx = px;
        constraints.weighty = py;
        constraints.anchor = anchor;
        constraints.fill = fill;
        this.add(c,constraints);
    }


    private void acciones() {
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (comboBox.getModel().getSelectedItem().getClass()== Persona.class){
                    Persona entontrada = (Persona) comboBox.getModel().getSelectedItem();
                    labelMedia.setText(String.format("La media del alumno es %.2f",entontrada.getMedia()));
                }
            }
        });
    }

    private void instancias() {
        modeloCombo = new DefaultComboBoxModel();
        modeloCombo.addElement("Selecciona un alumno");
        comboBox  = new JComboBox(modeloCombo);
        labelMedia = new JLabel("Selecciona un alumno");
    }

    public DefaultComboBoxModel getModeloCombo() {
        return modeloCombo;
    }
}
