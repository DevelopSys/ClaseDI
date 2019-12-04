import paneles.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Ventana extends JFrame implements ActionListener, ChangeListener {

    Container container;
    // panel personalizado
    PestaniaUno pestaniaUno;
    PestaniaDos pestaniaDos;
    PestaniaTres pestaniaTres;
    PestaniaCuatro pestaniaCuatro;
    PestaniaCinco pestaniaCinco;
    PestaniaSeis pestaniaSeis;
    PestaniaSiete pestaniaSiete;
    PestaniaOcho pestaniaOcho;
    PestaniaNueve pestaniaNueve;
    JTabbedPane panelPestanias;

    JMenuBar barraMenu;
    JMenu menuUno, menuItems1, menuItems2, menuDos;
    JMenuItem itemPestania1, itemPestania2, itemPestania3, itemPestania4, itemPestania5, itemPestania6;
    JCheckBoxMenuItem itemChek;
    JRadioButtonMenuItem itemRadio1, itemRadio2;

    ButtonGroup grupoRadios;

    public void initGUI(){

        instancias();


        configurarMenu();
        configurarContainer();
        acciones();
        this.setSize(new Dimension(300,300));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //this.pack();
    }

    private void acciones() {
        itemPestania1.addActionListener(this);
        itemPestania2.addActionListener(this);
        itemPestania3.addActionListener(this);
        itemPestania4.addActionListener(this);
        itemPestania5.addActionListener(this);
        itemPestania6.addActionListener(this);
        itemChek.addChangeListener(this);
    }

    private void configurarMenu() {
        barraMenu.add(menuUno);
        menuItems1.add(itemPestania1);
        menuItems1.add(itemPestania2);
        menuItems1.add(itemPestania3);
        menuUno.addSeparator();
        menuItems2.add(itemPestania4);
        menuItems2.add(itemPestania5);
        menuItems2.add(itemPestania6);

        menuUno.add(menuItems1);
        menuUno.add(menuItems2);

        barraMenu.add(menuDos);
        menuDos.add(itemChek);
        menuDos.add(itemRadio1);
        menuDos.add(itemRadio2);


        this.setJMenuBar(barraMenu);

    }

    private void configurarContainer() {
        container.add(panelPestanias);
        panelPestanias.addTab("Botones",pestaniaUno);
        panelPestanias.addTab("Check y radios",pestaniaDos);
        panelPestanias.addTab("Textos",pestaniaTres);
        panelPestanias.addTab("TextosRespaso",pestaniaCuatro);
        panelPestanias.addTab("Elementos datos",pestaniaCinco);
        panelPestanias.addTab("Elementos lista",pestaniaSeis);
        panelPestanias.addTab("Barra progreso",pestaniaSiete);
        panelPestanias.addTab("Personalizar",pestaniaOcho);
        panelPestanias.addTab("Tablas",pestaniaNueve);
    }

    private void instancias() {
        container = this.getContentPane();
        panelPestanias = new JTabbedPane(SwingConstants.TOP);
        pestaniaUno = new PestaniaUno();
        pestaniaDos = new PestaniaDos();
        pestaniaTres = new PestaniaTres();
        pestaniaCuatro = new PestaniaCuatro();
        pestaniaCinco = new PestaniaCinco();
        pestaniaSeis = new PestaniaSeis();
        pestaniaSiete = new PestaniaSiete();
        pestaniaOcho = new PestaniaOcho();
        pestaniaNueve = new PestaniaNueve();

        barraMenu = new JMenuBar();
        menuItems1 = new JMenu("Pestañas 1 a 3");
        menuItems2 = new JMenu("Pestañas 4 a 6");
        menuUno = new JMenu("Pestañas");
        itemPestania1 = new JMenuItem("Ir a pestaña 1");
        itemPestania1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_DOWN_MASK));
        itemPestania1.setToolTipText("Pulsar Ctl + 1");

        itemPestania2 = new JMenuItem("Ir a pestaña 2", KeyEvent.VK_2);
        itemPestania2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.ALT_DOWN_MASK));

        itemPestania3 = new JMenuItem("Ir a pestaña 3", KeyEvent.VK_3);
        itemPestania3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.ALT_DOWN_MASK));

        itemPestania4 = new JMenuItem("Ir a pestaña 4", KeyEvent.VK_4);
        itemPestania4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.ALT_DOWN_MASK));

        itemPestania5 = new JMenuItem("Ir a pestaña 5", KeyEvent.VK_5);
        itemPestania5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, InputEvent.ALT_DOWN_MASK));

        itemPestania6 = new JMenuItem("Ir a pestaña 6", KeyEvent.VK_6);
        itemPestania6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, InputEvent.ALT_DOWN_MASK));

        menuDos = new JMenu("Compuestos");
        itemChek = new JCheckBoxMenuItem("Seleccionado",false);
        itemRadio1 = new JRadioButtonMenuItem("Opción 1", false);
        itemRadio2 = new JRadioButtonMenuItem("Opción 2", true);

        grupoRadios = new ButtonGroup();
        grupoRadios.add(itemRadio1);
        grupoRadios.add(itemRadio2);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== itemPestania1){
            panelPestanias.setSelectedIndex(0);
        } else if (e.getSource()== itemPestania2){
            panelPestanias.setSelectedIndex(1);
        } else if (e.getSource()== itemPestania3){
            panelPestanias.setSelectedIndex(2);
        } else if (e.getSource()== itemPestania4){
            panelPestanias.setSelectedIndex(3);
        } else if (e.getSource()== itemPestania5){
            panelPestanias.setSelectedIndex(4);
        } else if (e.getSource()== itemPestania6){
            panelPestanias.setSelectedIndex(5);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        System.out.println(itemChek.isSelected());
    }
}
