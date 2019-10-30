package componentes;

import javax.swing.*;
import java.awt.event.*;

public class TextoPerso extends JTextField implements FocusListener {

    String hint;
    public TextoPerso(String text, int columns) {
        super(text, columns);
        hint = text;
        this.addFocusListener(this);
        this.addKeyListener(new ManejoTeclas());
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().equals(hint))
            this.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().length() == 0)
            this.setText(hint);
    }

    class ManejoTeclas extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {

            super.keyTyped(e);
            char tecla = e.getKeyChar();
            if (Character.isDigit(tecla)) {
                e.consume();
            } else if (getText().length() == 10) {
                e.consume();
            }
        }
    }


}
