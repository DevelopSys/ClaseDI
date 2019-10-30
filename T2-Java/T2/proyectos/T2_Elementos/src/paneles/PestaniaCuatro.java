package paneles;

import componentes.TextFieldNumeros;
import componentes.TextoPerso;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class PestaniaCuatro extends JPanel implements FocusListener{


    JTextField textoNormal, textoNormalDos;
    TextoPerso textoPerso1,textoPerso2,textoPerso3;

    public PestaniaCuatro() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }

    private void acciones() {
        textoNormal.addFocusListener(this);
        textoNormalDos.addFocusListener(this);
        textoNormal.addKeyListener(new ManejoTeclas());
        textoPerso3.addMouseListener(new ManejoPulsacionRaton());

    }

    private void configurarPanel() {
        this.add(textoNormal);
        this.add(textoNormalDos);
        this.add(textoPerso1);
        this.add(textoPerso2);
        this.add(textoPerso3);
    }

    private void instancias() {

        textoNormal = new JTextField("hint", 20);
        textoNormalDos = new JTextField("hint", 20);
        textoPerso1 = new TextoPerso("hint",20);
        textoPerso2 = new TextoPerso("hint1",20);
        textoPerso3 = new TextoPerso("hint2",20);

    }


    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == textoNormal) {
            if (textoNormal.getText().equals("hint"))
                textoNormal.setText("");
        } else if (e.getSource() == textoNormalDos) {
            if (textoNormalDos.getText().equals("hint"))
                textoNormalDos.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == textoNormal) {
            if (textoNormal.getText().length() == 0)
                textoNormal.setText("hint");
        } else if (e.getSource() == textoNormalDos) {
            if (textoNormalDos.getText().length() == 0)
                textoNormalDos.setText("hint");
        }
    }

    class ManejoPulsacionRaton extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if (e.getSource() == textoPerso3){
                if (e.getButton() == MouseEvent.BUTTON3){
                    System.out.println(e.getX() +" " + e.getY());
                }
            }
        }
    }
    class ManejoTeclas extends KeyAdapter{

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            char tecla = e.getKeyChar();
            if (Character.isDigit(tecla)){
                e.consume();
            } else if (textoNormal.getText().length()==10){
                e.consume();
            }
        }
    }
}
