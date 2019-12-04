import javax.swing.*;
import java.awt.*;

public class Panel2 extends JPanel {

    private JList lista;
    private DefaultListModel modelo;

    public Panel2() {
        initGUI();
    }

    private void initGUI() {
        intancias();
        configuraPanel();
    }

    private void configuraPanel() {
        this.setLayout(new BorderLayout());
        this.add(lista);
    }

    private void intancias() {
        modelo = new DefaultListModel();
        lista = new JList(modelo);
    }

    public DefaultListModel getModelo() {
        return modelo;
    }
}
