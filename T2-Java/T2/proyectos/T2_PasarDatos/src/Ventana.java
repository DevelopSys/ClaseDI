import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener{

    Panel1 panel1;
    Panel2 panel2;
    JMenuBar barra;
    JMenu menu;
    JMenuItem itemUno, itemDos;
    CardLayout cardLayout;
    Container container;

    public Ventana()  {
        initGUI();
    }

    private void configurarMenu() {

        barra.add(menu);
        menu.add(itemUno);
        menu.add(itemDos);
        this.setJMenuBar(barra);

    }

    private void configurarPanel() {
        container.setLayout(cardLayout);
        container.add(panel1,"panel1");
        container.add(panel2,"panel2");
    }

    private void initGUI() {
        intancias();
        configurarMenu();
        configurarPanel();
        acciones();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private void acciones() {
        itemDos.addActionListener(this);
        itemUno.addActionListener(this);
    }

    private void intancias() {
        container = getContentPane();
        menu = new JMenu("Opciones");
        barra = new JMenuBar();
        itemDos = new JMenuItem("Listar");
        itemUno = new JMenuItem("Agregar");
        cardLayout = new CardLayout();
        panel2 = new Panel2();
        panel1 = new Panel1(panel2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemUno){
            cardLayout.show(container,"panel1");
        } else if (e.getSource() == itemDos){
            cardLayout.show(container,"panel2");
        }
    }
}
