import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class VentanaDialogos extends JFrame implements ActionListener {
    private JPanel root;
    private JButton informaciónButton;
    private JButton errorButton;
    private JButton warningButton;
    private JButton siNoButton;
    private JButton entradaButton;
    private JButton entradaSpinnerButton;
    private JButton ficheroButton;
    private JButton colorButton;
    private JLabel info;
    private JButton persoButton;
    private JLabel labelPerso;

    public JLabel getLabelPerso() {
        return labelPerso;
    }

    JMenu menu;
    JMenuItem menuItem;
    JMenuBar barra;

    public VentanaDialogos() throws HeadlessException {
        setContentPane(root);
        acciones();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();

    }

    private void acciones() {

        informaciónButton.addActionListener(this);
        errorButton.addActionListener(this);
        warningButton.addActionListener(this);
        siNoButton.addActionListener(this);
        entradaButton.addActionListener(this);
        entradaSpinnerButton.addActionListener(this);
        ficheroButton.addActionListener(this);
        colorButton.addActionListener(this);
        persoButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == informaciónButton) {
            JOptionPane.showMessageDialog(this, "Mensaje información", "titulo info", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == errorButton) {
            JOptionPane.showMessageDialog(this, "Mensaje error", "titulo error", JOptionPane.ERROR_MESSAGE);
        } else if (e.getSource() == warningButton) {
            JOptionPane.showMessageDialog(this, "Mensaje error", "titulo error", JOptionPane.WARNING_MESSAGE);
        } else if (e.getSource() == siNoButton) {
            int m = JOptionPane.showConfirmDialog(this, "Mensaje pregunta", "Titulo pregunta", JOptionPane.YES_NO_OPTION);
            System.out.println(m);
        } else if (e.getSource() == entradaSpinnerButton) {
            String[] datos = {"Opcion 1", "Opcion 2", "Opcion 3"};
            Object o = JOptionPane.showInputDialog(this, "Mensaje entrada sp",
                    "Titulo entrada sp", JOptionPane.QUESTION_MESSAGE, null, datos, datos[1]);
            if (o != null) {
                System.out.println(o.toString());
            } else System.out.println("No hay seleccion");
        } else if (e.getSource() == entradaButton) {
            String introducido = JOptionPane.showInputDialog(this, "Mensaje entrada",
                    "Introduzca datos");
            System.out.println(introducido);
        } else if (e.getSource() == ficheroButton) {
            JFileChooser fileChooser = new JFileChooser();
            int i = fileChooser.showDialog(this, "Aceptas");
            switch (i) {
                case JFileChooser.APPROVE_OPTION:
                    File f = fileChooser.getSelectedFile();
                    System.out.println(f.getName());
                    break;
                case JFileChooser.CANCEL_OPTION:
                    break;
            }

        } else if (e.getSource() == colorButton) {

            Color c = JColorChooser.showDialog(this, "Titulo color", Color.BLACK);
            System.out.println(c.toString());
            root.setBackground(c);
        }
        else if (e.getSource() == persoButton){
            //DialogoPerso d = new DialogoPerso();
            DialogoGrafico d = new DialogoGrafico("Titulo a pasar",this,labelPerso);
            d.setVisible(true);
        }
    }

    public JButton getErrorButton() {
        return errorButton;
    }

    public JButton getWarningButton() {
        return warningButton;
    }

    public JButton getSiNoButton() {
        return siNoButton;
    }

    public JButton getEntradaButton() {
        return entradaButton;
    }

    public JButton getEntradaSpinnerButton() {
        return entradaSpinnerButton;
    }

    public JButton getFicheroButton() {
        return ficheroButton;
    }

    public JButton getColorButton() {
        return colorButton;
    }

}
