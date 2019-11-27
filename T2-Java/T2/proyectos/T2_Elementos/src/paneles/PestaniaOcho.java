package paneles;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PestaniaOcho extends JPanel implements ItemListener {

    JComboBox comboLetra, comboTamanio, comboTipo, comboEstilo;
    DefaultComboBoxModel modeloLetra, modeloTamanio, modeloTipo, modeloEstilo;
    JLabel labelLetra, labelTamanio, labelTipo, labelEstilo;

    public PestaniaOcho() {

        initGUI();
    }

    public void initGUI() {
        instancias();
        rellenarLetras();
        configurarPanel();
        acciones();
    }

    private void rellenarLetras() {
        Font[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAllFonts();

        for (Font item :fuentes) {

            modeloLetra.addElement(item.getName());
        }


    }

    private void acciones() {
        comboLetra.addItemListener(this);

    }

    private void configurarPanel() {
        this.setLayout(new GridLayout(4,2));
        this.add(labelLetra);
        this.add(comboLetra);
        this.add(labelTamanio);
        this.add(comboTamanio);
        this.add(labelTipo);
        this.add(comboTipo);
        this.add(labelEstilo);
        this.add(comboEstilo);

    }

    private void instancias() {

        modeloLetra = new DefaultComboBoxModel();
        modeloEstilo = new DefaultComboBoxModel();
        modeloTipo = new DefaultComboBoxModel();
        modeloTamanio = new DefaultComboBoxModel();

        comboLetra = new JComboBox(modeloLetra);
        comboTamanio = new JComboBox(modeloTamanio);
        comboEstilo = new JComboBox(modeloEstilo);
        comboTipo = new JComboBox(modeloTipo);

        labelEstilo = new JLabel("Estilo");
        labelTipo = new JLabel("Tipo");
        labelTamanio = new JLabel("Tamaño");
        labelLetra = new JLabel("Letra");

    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==comboLetra){
            String tipo = (String) modeloLetra.getSelectedItem();
            System.out.println(tipo);
            Font fuente = new Font(tipo,Font.BOLD,25);
            //labelLetra.setFont(fuente);
            Component[] components = this.getComponents();
            for (Component item:components) {
                item.setFont(fuente);
            }
        }
    }
}
