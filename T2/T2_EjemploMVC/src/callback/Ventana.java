package callback;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    Container container;
    JPanel pArriba, pCentro;
    JButton botonPUno, botonPDos;
    CardLayout cardLayout;
    Panel1 panel1;
    Panel2 panel2;

    static String tag_uno = "pUno";
    static String tag_dos = "pDos";

    public Ventana() throws HeadlessException {
        instancias();
        initGUI();
    }

    private void instancias() {
        container = getContentPane();
        pCentro = new JPanel();
        pArriba = new JPanel();
        botonPDos = new JButton("IR A P2");
        botonPUno = new JButton("IR A P1");
        cardLayout = new CardLayout();
        panel1 = new Panel1();
        panel2 = new Panel2();
    }

    private void initGUI() {
        pArriba.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        container.add(configurarArriba(), BorderLayout.NORTH);
        container.add(configurarCentro(), BorderLayout.CENTER);
        setTitle("MVC");
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel configurarCentro() {
        pCentro.setLayout(cardLayout);
        //((CardLayout)pCentro.getLayout());
        pCentro.add(panel1,tag_uno);
        pCentro.add(panel2,tag_dos);
        //cardLayout.show(pCentro,);
        return pCentro;
    }



    private JPanel configurarArriba() {
        pArriba.add(botonPUno);
        pArriba.add(botonPDos);
        return pArriba;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JButton getBotonPDos() {
        return botonPDos;
    }

    public JPanel getpCentro() {
        return pCentro;
    }

    public JButton getBotonPUno() {
        return botonPUno;
    }

    public Panel1 getPanel1() {
        return panel1;
    }

    public Panel2 getPanel2() {
        return panel2;
    }
}
