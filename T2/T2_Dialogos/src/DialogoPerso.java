import javax.swing.*;
import java.awt.*;

public class DialogoPerso extends JDialog {

    Container container;

    public DialogoPerso() {

        instancias();
        setModal(true);
        setVisible(true);
        pack();

    }

    private void instancias() {
        container = getContentPane();
        container.add(new JLabel("Cuadro personalizado"));
    }
}
