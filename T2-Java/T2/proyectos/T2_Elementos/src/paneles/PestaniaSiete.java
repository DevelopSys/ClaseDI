package paneles;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PestaniaSiete extends JPanel implements ActionListener {

    JButton botonNormal;
    JProgressBar barraProgreso;


    public PestaniaSiete() {

        initGUI();
    }

    public void initGUI() {
        instancias();
        configurarBarra();
        configurarPanel();
        acciones();
    }

    private void configurarBarra() {
        barraProgreso.setMinimum(0);
        barraProgreso.setMaximum(100);
        barraProgreso.setValue(0);
        //barraProgreso.getValue();
        barraProgreso.setStringPainted(true);
        barraProgreso.setBorderPainted(true);

    }

    private void acciones() {
        botonNormal.addActionListener(this);

    }

    private void configurarPanel() {
        this.add(botonNormal);
        this.add(barraProgreso);

    }

    private void instancias() {
        botonNormal = new JButton("Pulsar");
        barraProgreso = new JProgressBar();



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonNormal) {
            barraProgreso.setValue(barraProgreso.getValue()+25);
            if (barraProgreso.getValue()==100){
                getToolkit().beep();
            }
        }
    }


}
