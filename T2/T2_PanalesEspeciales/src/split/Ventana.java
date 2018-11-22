package split;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ventana extends JFrame {

    //JTabbedPane panelPestanias;
    JSplitPane splitPane;
    JPanel panelPenstaniaUno;
    JPanel panelPenstaniaDos;
    Container container;
    JComboBox comboLetras;
    DefaultComboBoxModel modeloCombo;
    JLabel texto;

    public Ventana() throws HeadlessException {
        instancias();
        initGUI();
        rellenarCombo();
        acciones();


    }

    private void acciones() {
        comboLetras.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(modeloCombo.getSelectedItem().toString());
                Font fuente = new Font(modeloCombo.getSelectedItem().toString(),Font.PLAIN,25);
                texto.setFont(fuente);
                int tamano = texto.getFont().getSize();
            }
        });
    }

    public Ventana(String dato) {
        this.setTitle(dato);
        instancias();
        initGUI();
    }

    private void rellenarCombo() {

        String[] letrasSistema = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String letra: letrasSistema) {
            modeloCombo.addElement(letra);
        }
    }

    private void instancias() {
        container = getContentPane();
        panelPenstaniaUno = new JPanel();
        //panelPenstaniaUno.setBackground(Color.blue);
        panelPenstaniaDos = new JPanel();
        //panelPenstaniaDos.setBackground(Color.YELLOW);
        splitPane = new JSplitPane();
        modeloCombo = new DefaultComboBoxModel();
        comboLetras = new JComboBox(modeloCombo);
        texto = new JLabel("Prueba");

    }

    private void initGUI() {

        splitPane.setContinuousLayout(true);
        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);

        panelPenstaniaUno.add(comboLetras);
        panelPenstaniaDos.add(texto);

        splitPane.setBottomComponent(panelPenstaniaDos);
        splitPane.setTopComponent(panelPenstaniaUno);
        splitPane.setDividerSize(10);



        container.add(splitPane);


        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }
}
