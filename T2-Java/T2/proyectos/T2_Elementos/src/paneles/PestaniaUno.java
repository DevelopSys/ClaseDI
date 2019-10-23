package paneles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PestaniaUno extends JPanel implements ActionListener {

    JButton botonNormal, botonImagen;

    public PestaniaUno(){

        initGUI();
    }

    public void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }

    private void acciones() {
        botonNormal.addActionListener(this);
    }

    private void configurarPanel() {
        this.add(botonNormal);
        this.add(botonImagen);
    }

    private void instancias() {
        botonNormal = new JButton("Pulsar");
        botonImagen = new JButton();
        botonImagen.setIcon(new ImageIcon(getClass().getResource("../recursos" +
                "/button_ok.png")));

        //botonImagen.setPressedIcon(new ImageIcon("src/recursos/button_cancel.png"));
        //botonImagen.setRolloverIcon(new ImageIcon("src/recursos/button_power.png"));
        //botonImagen.setToolTipText("El boton vale para lo que sea");
        botonImagen.setBackground(null);
        botonImagen.setBorderPainted(false);
        botonImagen.setFocusPainted(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==botonNormal){
            System.out.println("Boton Pulsado");
        }
    }
}
