import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class VentanaPrincipal extends JFrame implements ActionListener {


    JButton botonUno, botonDos, botonTres, botonCuatro;
    JButton botonSupUno, botonSupDos;
    Container container;
    JLabel etiquetaInferior;
    JPanel panelInferior, panelSuperior, panelCentro, panelDerecha;
    JPanel panelCentroUno, panelCentroDos, panelCentroTres, panelCentroCuatro;
    CardLayout cardLayout;

    public void initGUI() {
        instancias();
        acciones();
        this.setTitle("Ejemplo inicial");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.setExtendedState(MAXIMIZED_BOTH);
        //this.setExtendedState(MAXIMIZED_HORIZ);
        //this.setExtendedState(MAXIMIZED_VERT);
        //this.setExtendedState(ICONIFIED);

        this.setBounds(50, 50, 500, 500);
        this.setLocationRelativeTo(null);
        configurarContainer();
        // this.pack();

        this.setVisible(true);
    }

    private void acciones() {
        botonUno.addActionListener(this);
        botonDos.addActionListener(this);
        botonTres.addActionListener(this);
        botonCuatro.addActionListener(this);
    }

    private void instancias() {

        botonUno = new JButton("IR A UNO");
        botonUno.setActionCommand(Constantes.ACC_B1);
        botonDos = new JButton("IR A DOS");
        botonDos.setActionCommand(Constantes.ACC_B2);
        botonTres = new JButton("IR A TRES");
        botonTres.setActionCommand(Constantes.ACC_B3);
        botonCuatro = new JButton("IR A CUATRO");
        botonCuatro.setActionCommand(Constantes.ACC_B4);
        botonSupUno = new JButton("<--");
        botonSupDos = new JButton("-->");

        container = this.getContentPane();
        etiquetaInferior = new JLabel("EJEMPLO");
        panelInferior = new JPanel();
        panelSuperior = new JPanel();
        panelCentro = new JPanel();
        panelCentro.setBorder(BorderFactory.createTitledBorder("Panel central"));
        panelDerecha = new JPanel();

        panelCentroUno = new JPanel();
        panelCentroUno.setBackground(Color.YELLOW);
        panelCentroDos = new JPanel();
        panelCentroDos.setBackground(Color.RED);
        panelCentroTres = new JPanel();
        panelCentroTres.setBackground(Color.BLUE);
        panelCentroCuatro = new JPanel();
        panelCentroCuatro.setBackground(Color.GREEN);

        cardLayout = new CardLayout();

    }


    private void configurarContainer() {
        // JPanel --> FlowLayout
        // container.setLayout(new FlowLayout(FlowLayout.RIGHT,100,100));
        // container.setLayout(new GridLayout(2,2,50,50));
        // container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        // JFrame --> BorderLayout
        container.setLayout(new BorderLayout());
        container.add(configDerecha(), BorderLayout.EAST);
        container.add(configInferior(), BorderLayout.SOUTH);
        container.add(configSuperior(), BorderLayout.NORTH);
        container.add(configurarCentro(), BorderLayout.CENTER);

    }


    private JPanel configDerecha() {
        // Por defecto tiene flowlayout
        panelDerecha.setPreferredSize(new Dimension(200, 400));
        panelDerecha.setLayout(new GridLayout(4, 1, 10, 10));
        panelDerecha.add(botonUno);
        panelDerecha.add(botonDos);
        panelDerecha.add(botonTres);
        panelDerecha.add(botonCuatro);
        return panelDerecha;
    }

    private JPanel configInferior() {

        panelInferior.add(etiquetaInferior);
        return panelInferior;
    }

    private JPanel configSuperior() {

        // por defecto flowlayout
        panelSuperior.add(botonSupUno);
        panelSuperior.add(botonSupDos);
        return panelSuperior;
    }

    private JPanel configurarCentro() {

        // por defecto flowlayout
        panelCentro.setLayout(cardLayout);
        panelCentro.add(panelCentroUno, Constantes.TAG_P1);
        panelCentro.add(panelCentroDos, Constantes.TAG_P2);
        panelCentro.add(panelCentroTres, Constantes.TAG_P3);
        panelCentro.add(panelCentroCuatro, Constantes.TAG_P4);

        cardLayout.show(panelCentro, "panel3");
        // ((CardLayout)panelCentro.getLayout()).show();
        return panelCentro;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        /*if (e.getSource() == botonUno){
            cardLayout.show(panelCentro,"panel1");
        } else if (e.getSource() == botonDos){
            cardLayout.show(panelCentro,"panel2");
        } else if (e.getSource() == botonTres){
            cardLayout.show(panelCentro,"panel3");
        } else if (e.getSource() == botonCuatro){
            cardLayout.show(panelCentro,"panel4");
        }*/

        switch (e.getActionCommand()) {
            case Constantes.ACC_B1:
                cardLayout.show(panelCentro, Constantes.TAG_P1);
                break;
            case Constantes.ACC_B2:
                cardLayout.show(panelCentro, Constantes.TAG_P2);
                break;
            case Constantes.ACC_B3:
                cardLayout.show(panelCentro, Constantes.TAG_P3);
                break;
            case Constantes.ACC_B4:
                cardLayout.show(panelCentro, Constantes.TAG_P4);
                break;
        }
    }
}
