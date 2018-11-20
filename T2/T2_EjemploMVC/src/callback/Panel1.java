package callback;

import javax.swing.*;

public class Panel1 extends JPanel {

    JTextField nombre;
    JButton boton;

    public Panel1() {
        instancias();
        initGUI();
    }

    private void initGUI() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        this.add(nombre);
        this.add(boton);
    }

    private void instancias() {
        nombre = new JTextField(10);
        boton = new JButton("Enviar");
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JButton getBoton() {
        return boton;
    }
}
