import javax.swing.*;

public class Panel2 extends JPanel {

    JLabel etiqueta;

    public Panel2() {

        instancias();
        initGUI();
    }

    private void initGUI() {
        this.add(etiqueta);
    }

    private void instancias() {
        etiqueta = new JLabel("Nombre");
    }

    public JLabel getEtiqueta() {
        return etiqueta;
    }
}
