import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel1 extends JPanel implements ActionListener {

    JButton boton;
    Panel2 panel2;

    public Panel1(Panel2 panel2) {
        this.panel2 = new Panel2();
        initGUI();
    }

    private void initGUI() {
        intancias();
        configurarPanel();
        acciones();
    }

    private void acciones() {
        boton.addActionListener(this);
    }

    private void configurarPanel() {
        this.add(boton);
    }

    private void intancias() {
        boton = new JButton("Agregar");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO acceder a la lista del panel2
        panel2.getModelo().addElement(new Persona("Nombre"
                , "ap", 123));
    }
}
