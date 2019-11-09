package ventanas;

import paneles.PanelBuscar;
import paneles.PanelRegistro;
import utils.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {

    Container container;
    JButton irRegistro, irBuscar, registrar;
    JPanel pSuperior, pInferior, pCentral;
    CardLayout cardLayout;
    PanelRegistro panelRegistro;
    PanelBuscar panelBuscar;

    final String TAG_PBUSCAR = "buscar";
    final String TAG_PREGISTRO = "registrar";

    public Ventana() throws HeadlessException {

        initGUI();
    }

    private void initGUI() {

        instancias();
        configurarVentana();
        acciones();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(400, 300));
    }

    private void acciones() {
        irBuscar.addActionListener(this);
        irRegistro.addActionListener(this);
        registrar.addActionListener(this);
    }

    private void configurarVentana() {
        container.add(configurarPanelSuperior(),BorderLayout.NORTH );
        container.add(configurarPanelInferior(),BorderLayout.SOUTH );
        container.add(configurarPanelCentral(),BorderLayout.CENTER );
    }

    private JPanel configurarPanelCentral() {
        pCentral.setLayout(cardLayout);
        pCentral.add(panelRegistro,TAG_PREGISTRO);
        pCentral.add(panelBuscar,TAG_PBUSCAR);
        return pCentral;
    }

    private JPanel configurarPanelSuperior() {
        pSuperior.add(irRegistro);
        pSuperior.add(irBuscar);
        return pSuperior;
    }

    private JPanel configurarPanelInferior() {
        pInferior.add(registrar);
        return pInferior;
    }

    private void instancias() {
        container = this.getContentPane();
        pSuperior = new JPanel();
        pCentral = new JPanel();
        pInferior = new JPanel();
        irRegistro = new JButton("Ir a registro");
        irBuscar = new JButton("Ir a buscar");
        registrar = new JButton(new ImageIcon("src/resources/add.png"));
        panelBuscar = new PanelBuscar();
        panelRegistro = new PanelRegistro();
        cardLayout = new CardLayout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == irRegistro)
        {
            cardLayout.show(pCentral,TAG_PREGISTRO);
            registrar.setEnabled(true);
        } else if (e.getSource() == irBuscar)
        {
            cardLayout.show(pCentral,TAG_PBUSCAR);
            registrar.setEnabled(false);
        } else if (e.getSource() == registrar){
            if (!panelRegistro.gettNombre().getText().isEmpty() && !panelRegistro.gettDNI().getText().isEmpty()){
                Persona p = panelRegistro.devolverPersona();
                panelBuscar.getModeloCombo().addElement(p);
            }
        }
    }
}
