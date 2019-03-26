import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ventana extends JFrame implements ActionListener {


    JButton botonNombre, botonEdad, botonBuscar, botonInsertar;
    JTextField editBusqueda;
    JSpinner spinner;
    SpinnerListModel modeloSpinner;
    private String nombreTemp;
    private Object edadTemp;
    ArrayList<Usuario> listaUsuarios;
    JPanel pUno;
    JPanel pDos;
    CardLayout cd;
    JMenuBar barra;
    JMenu menu;
    JMenuItem menuUno, menuDos;

    public Ventana() throws HeadlessException {
        instancias();
        configurarSpinner();
        configurarPanelUno();
        configurarPanelDos();
        configurarGeneral();
        configurarBarra();
        acciones();
    }

    private void configurarBarra() {
        setJMenuBar(barra);
    }

    private void configurarGeneral() {
        this.getContentPane().setLayout(new GridLayout(1, 2));
        this.getContentPane().add(pUno);
        this.getContentPane().add(pDos);
        //        cd.show(this.getContentPane(), "panel1");
    }

    private void configurarSpinner() {
        spinner.setModel(modeloSpinner);
    }

    private void acciones() {
        botonInsertar.addActionListener(this);
        botonNombre.addActionListener(this);
        botonEdad.addActionListener(this);
        botonBuscar.addActionListener(this);
        menuUno.addActionListener(this);
        menuDos.addActionListener(this);
    }

    private void configurarPanelUno() {
        pUno.setLayout(new GridLayout(5, 1));
        pUno.add(botonNombre);
        pUno.add(botonEdad);
        pUno.add(botonInsertar);
        pUno.add(editBusqueda);
        pUno.add(botonBuscar);
    }

    private void configurarPanelDos() {
        pDos.setLayout(new GridLayout(1, 1));
        pDos.add(spinner);
    }

    private void instancias() {
        cd = new CardLayout();
        botonNombre = new JButton("Nombre");
        botonEdad = new JButton("Edad");
        botonBuscar = new JButton("Busca");
        botonInsertar = new JButton("Insertar");
        editBusqueda = new JTextField("Introduce nombre");
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("asdasd","asdasd"));
        modeloSpinner = new SpinnerListModel(listaUsuarios);
        spinner = new JSpinner();
        pUno = new JPanel();
        pDos = new JPanel();
        barra = new JMenuBar();
        menu = new JMenu("M");
        menuUno = new JMenuItem("M1");
        menuDos = new JMenuItem("M2");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonNombre) {

            nombreTemp = JOptionPane.showInputDialog(Ventana.this, "Introduce nombre", "Nombre", JOptionPane.QUESTION_MESSAGE);

        } else if (e.getSource() == botonEdad) {
            int j = 0;
            String[] edades = new String[10];
            for (int i = 10; i < 20; i++) {
                edades[j] = String.valueOf(i);
                j++;
            }

            edadTemp = JOptionPane.showInputDialog(Ventana.this,
                    "Introduce la edad",
                    "Edad", JOptionPane.QUESTION_MESSAGE,
                    null, edades, edades[0]);

        } else if (e.getSource() == botonInsertar) {

            if (nombreTemp != null && edadTemp != null) {
                Usuario u = new Usuario(nombreTemp, String.valueOf(edadTemp));
                listaUsuarios.add(u);
                spinner.setModel(modeloSpinner);
                spinner.getModel().notifyAll();

            }

        } else if (e.getSource() == botonBuscar) {
            String nombreBuscar = editBusqueda.getText();
            for (Usuario u : listaUsuarios) {
                if (u.getNombre().equals(nombreBuscar)) {
                    //etiqueta.setText(u.getNombre());
                    System.out.println(u.getNombre());
                    System.out.println(u.getEdad());
                }
            }
        }else if (e.getSource() == botonBuscar) {
            String nombreBuscar = editBusqueda.getText();
            for (Usuario u : listaUsuarios) {
                if (u.getNombre().equals(nombreBuscar)) {
                    listaUsuarios.remove(u);
                }
            }
        } else if (e.getSource() == menuUno) {
            cd.show(this.getContentPane(), "panel1");
        } else if (e.getSource() == menuDos) {
            cd.show(this.getContentPane(), "panel2");
        }
    }
}
