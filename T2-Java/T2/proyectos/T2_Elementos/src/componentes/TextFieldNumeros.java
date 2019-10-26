package componentes;

import javax.swing.*;
import java.awt.event.*;

public class TextFieldNumeros extends JTextField
        implements KeyListener, FocusListener {

    String hint;

    public TextFieldNumeros(String text, int columns) {
        super(text, columns);
        this.hint = text;
        this.addFocusListener(this);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (Character.isDigit(e.getKeyChar())){
            System.out.println("es digito");
        }else {
            System.out.println("no es digito");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().equals(hint)){
            this.setText("");
        }

    }
    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().length() == 0) {
            this.setText(hint);
        }
    }


}
