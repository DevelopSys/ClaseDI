import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaMenus extends JFrame implements ActionListener {
    private JPanel root;
    private JPanel principal;
    private JTextField texto;
    VentanaMenus v;
    JMenuBar barraMenu;
    JMenu menuFichero;
    JMenuItem menuItemNuevo;
    JMenuItem menuItemCerrar;
    JMenu menuEditar;
    JMenuItem menuItemCopiar;
    JMenuItem menuItemCortar;
    JMenu menuEditarInterno;
    JMenuItem menuItemIterno;
    JCheckBoxMenuItem menuItemInternoCheck;
    JRadioButtonMenuItem menuItemIternoRadio1, menuItemIternoRadio2;
    ButtonGroup grupoRadios;
    JPopupMenu popupMenu;
    JMenuItem menuItemPopUno;
    JMenuItem menuItemPopDos;
    JToolBar toolBar;
    JButton b1,b2;



    public VentanaMenus() throws HeadlessException {

        v = this;
        setContentPane(root);
        instancias();
        configuMenu();
        configPopUp();
        configToolBar();
        acciones();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
    }

    private void configToolBar() {
        toolBar.add(b1);
        toolBar.add(b2);
        toolBar.setRollover(true);
        principal.add(toolBar,BorderLayout.NORTH);
    }

    private void configPopUp() {
        popupMenu.add(menuItemPopUno);
        popupMenu.add(menuItemPopDos);
    }

    private void acciones() {
        menuItemNuevo.addActionListener(this);
        menuItemCerrar.addActionListener(this);
        menuItemCopiar.addActionListener(this);
        menuItemCortar.addActionListener(this);
        menuItemIterno.addActionListener(this);
        principal.addMouseListener(new ManejoRaton());
        texto.addMouseListener(new ManejoRaton());
        texto.addKeyListener(new ManejoPulsacion());
    }

    private void configuMenu() {
        this.setJMenuBar(barraMenu);
        barraMenu.add(menuFichero);
        //menuItemNuevo.setIcon(new ImageIcon(getClass().getResource("")));
        menuItemNuevo.setMnemonic(KeyEvent.VK_E);
        menuItemNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.ALT_MASK));
        menuFichero.add(menuItemNuevo);
        menuFichero.add(menuItemCerrar);
        barraMenu.add(menuEditar);
        menuEditar.add(menuItemCortar);
        menuEditar.add(menuItemCopiar);
        menuEditar.addSeparator();
        menuEditar.add(menuEditarInterno);
        menuEditarInterno.add(menuItemIterno);
        menuEditarInterno.add(menuItemInternoCheck);
        menuEditarInterno.add(menuItemIternoRadio1);
        menuEditarInterno.add(menuItemIternoRadio2);
    }

    private void instancias() {
        barraMenu = new JMenuBar();
        menuFichero = new JMenu("Fichero");
        menuItemNuevo = new JMenuItem("Abrir");
        menuItemCerrar = new JMenuItem("Cerrar");
        menuEditar = new JMenu("Editar");
        menuItemCopiar = new JMenuItem("Copiar");
        menuItemCortar = new JMenuItem("Cortar");
        menuEditarInterno = new JMenu("Editar interno");
        menuItemIterno = new JMenuItem("interno");
        menuItemInternoCheck = new JCheckBoxMenuItem("Seleccion");
        menuItemIternoRadio1 = new JRadioButtonMenuItem("Opcion 1");
        menuItemIternoRadio2 = new JRadioButtonMenuItem("Opcion 2");
        grupoRadios = new ButtonGroup();
        grupoRadios.add(menuItemIternoRadio1);
        grupoRadios.add(menuItemIternoRadio2);
        popupMenu = new JPopupMenu();
        menuItemPopUno = new JMenuItem("Elemento 1");
        menuItemPopDos = new JMenuItem("Elemento 2");
        toolBar = new JToolBar();
        b1 = new JButton("Botón 1");
        b2 = new JButton("Botón 2");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemNuevo) {
            System.out.println("pulsado");
        } else if (e.getSource() == menuItemCerrar) {
            System.exit(0);
        } else if (e.getSource() == menuItemCopiar) {

        } else if (e.getSource() == menuItemCortar) {

        } else if (e.getSource() == menuItemIterno) {

        }
    }

     class ManejoPulsacion extends KeyAdapter{
         @Override
         public void keyPressed(KeyEvent e) {
             super.keyPressed(e);
             if (e.getKeyCode() == KeyEvent.VK_E){
                 popupMenu.show(texto,50,50);
             }
         }
     }

    class ManejoRaton extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getButton() == MouseEvent.BUTTON3){
                popupMenu.show(principal,e.getX(),e.getY());
            }
        }
    }
}
