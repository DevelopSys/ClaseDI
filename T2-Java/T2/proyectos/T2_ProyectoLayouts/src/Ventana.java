import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    JButton b1, b2, b3, b4, b5, b6;
    Container container;
    JPanel panelCentro;

    public void initGUI() {

        instancias();
        configurarGridBag();

        this.setSize(new Dimension(300, 300));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void instancias() {
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        container = this.getContentPane();
        panelCentro = new JPanel();
    }

    private void configurarGridBag() {
        container.add(configurarCentro(), BorderLayout.CENTER);
    }

    private void configurarConstraint(int posx, int posy, int tx, int ty,
                                      int ali, int fill, double pesx, double pesy, Component component) {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = tx;
        constraints.gridheight = ty;
        constraints.gridx = posx;
        constraints.gridy = posy;
        constraints.anchor = ali;
        constraints.fill = fill;
        constraints.weightx = pesx;
        constraints.weighty = pesy;
        panelCentro.add(component, constraints);

    }

    private JPanel configurarCentro() {
        panelCentro.setLayout(new GridBagLayout());
        /*GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridwidth=1;
        constraints.gridheight=1;
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx=0.2;
        constraints.weighty=0.33;*/

        configurarConstraint(1, 1, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL, 0.2, 0.33, b1);
        configurarConstraint(1, 1, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL, 0.2, 0.33, b1);
        configurarConstraint(1, 1, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL, 0.2, 0.33, b1);
        configurarConstraint(1, 1, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL, 0.2, 0.33, b1);
        configurarConstraint(1, 1, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL, 0.2, 0.33, b1);
        //panelCentro.add(b1,constraints);

        constraints.weighty = 0.33;
        constraints.weightx = 0.8;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;


        panelCentro.add(b2, constraints);

        constraints.weighty = 0.33;
        constraints.weightx = 0.2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;


        panelCentro.add(b3, constraints);

        constraints.weighty = 0.33;
        constraints.weightx = 0.2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;


        panelCentro.add(b4, constraints);

        constraints.weighty = 0.33;
        constraints.weightx = 0.8;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;


        panelCentro.add(b5, constraints);
        // panelCentro.add(b6);
        return panelCentro;

    }
}
