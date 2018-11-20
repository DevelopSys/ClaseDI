import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Ventana extends JFrame implements ActionListener, ListSelectionListener {

    JList lista;
    JButton boton, botonMultiple;
    JScrollPane scrollPane;
    DefaultListModel modeloDatos;
    Container container;
    File ruta;

    public Ventana() throws HeadlessException {
        instancias();
        initGUI();
        rellenarLista(ruta);
        configurarLista();
        acciones();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    private void configurarLista() {
        //lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        int[] seleccionado = new int[3];
        seleccionado[0]=1;
        seleccionado[1]=2;
        seleccionado[2]=3;
        //lista.setSelectedIndices(seleccionado);
        lista.getSelectionModel().setSelectionInterval(1,3);
    }

    private void initGUI() {
        // container tiene BorderLayout
        container.add(scrollPane, BorderLayout.CENTER);
        // panel botones;
        JPanel pBotones = new JPanel();
        pBotones.add(boton);
        pBotones.add(botonMultiple);

        container.add(pBotones, BorderLayout.SOUTH);
    }

    private void rellenarLista(File file) {
        File[] ficheros = file.listFiles();

        for (File temporal : ficheros) {
            System.out.println(temporal.getName());
            modeloDatos.addElement(temporal.getName());

        }
    }

    private void acciones() {
        boton.addActionListener(this);
        botonMultiple.addActionListener(this);
        lista.addListSelectionListener(this);
    }

    private void instancias() {

        modeloDatos = new DefaultListModel();
        lista = new JList(modeloDatos);
        scrollPane = new JScrollPane(lista);
        //scrollPane.setViewportView(lista);
        //lista.setModel(modeloDatos);
        boton = new JButton("Acceder");
        botonMultiple = new JButton("Multiple");
        container = getContentPane();
        ruta = new File("/Users/borja/");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) {
            //System.out.println(lista.getModel().getElementAt(lista.getSelectedIndex()).toString());
            if(!(lista.getSelectedIndices().length > 1)){
                String nombre = lista.getModel().getElementAt(lista.getSelectedIndex()).toString();
                String rutaNueva = ruta.getAbsolutePath() + "/" + nombre;
                ruta = new File(rutaNueva);
                //System.out.println(rutaNueva.toString());
                //System.out.println(ruta.isDirectory());
                if (ruta.isDirectory()) {
                    modeloDatos.clear();
                    rellenarLista(ruta);
                }
            }


        } else if (e.getSource() == botonMultiple){
            int[] indices = lista.getSelectedIndices();
            for (int temporal: indices) {
                //System.out.println(temporal);
                System.out.println(lista.getModel().getElementAt(temporal).toString());
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == lista) {
            if (e.getValueIsAdjusting()) {
                System.out.println(lista.getModel().getElementAt(lista.getSelectedIndex()).toString());
            }
        }
    }
}
