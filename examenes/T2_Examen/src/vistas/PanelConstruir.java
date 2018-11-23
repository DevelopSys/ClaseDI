package vistas;

import utils.Asignatura;
import utils.DataSet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelConstruir extends JPanel {

    JList listaAsignaturasTotal, listaAsignaturasConstruidas;
    DefaultListModel<Asignatura> modeloAsignaturasTotal, modeloAsignaturasConstruidas;
    ListSelectionModel modeloSeleccionListaTotal, modeloSeleccionListaConstruidas;
    JTextField nombreModulo;
    JButton botonAgregar, botonCancelar, botonIzquierda, botonDerecha;

    public PanelConstruir(LayoutManager layout) {
        super(layout);
        instancias();
        rellenarConstruirModelos();
        initGUI();
    }

    private void rellenarConstruirModelos() {
        ArrayList<Asignatura> lista = DataSet.newInstance().listaAsignaturas();
        for (Asignatura asignatura: lista) {
            modeloAsignaturasTotal.addElement(asignatura);
        }
        modeloSeleccionListaConstruidas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        modeloSeleccionListaTotal.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    private void instancias() {
        modeloAsignaturasTotal = new DefaultListModel();
        modeloAsignaturasConstruidas = new DefaultListModel();
        listaAsignaturasConstruidas = new JList(modeloAsignaturasConstruidas);
        listaAsignaturasConstruidas.setPreferredSize(new Dimension(400,300));
        listaAsignaturasConstruidas.setMinimumSize(new Dimension(400,300));
        listaAsignaturasTotal = new JList(modeloAsignaturasTotal);
        listaAsignaturasTotal.setPreferredSize(new Dimension(400,300));
        listaAsignaturasTotal.setMinimumSize(new Dimension(400,300));
        modeloSeleccionListaConstruidas = listaAsignaturasConstruidas.getSelectionModel();
        modeloSeleccionListaTotal = listaAsignaturasTotal.getSelectionModel();
        nombreModulo = new JTextField();
        botonAgregar = new JButton("Agregar");
        botonCancelar = new JButton("Cancelar");
        botonIzquierda = new JButton(new ImageIcon(getClass().getResource("/recursos/fizq.jpg")));
        botonIzquierda.setBackground(null);
        botonIzquierda.setBorderPainted(false);
        botonDerecha = new JButton(new ImageIcon(getClass().getResource("/recursos/fder.jpg")));
        botonDerecha.setBackground(null);
        botonDerecha.setBorderPainted(false);
    }

    private void initGUI() {
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonAgregar);
        panelBotones.add(botonCancelar);
        agregarElementos(0, 0, 1, 1, 0, 0, new Insets(5, 5, 5, 5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new JLabel("Nombre ciclo"));
        agregarElementos(1, 0, 2, 1, 0, 0, new Insets(5, 5, 5, 5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, nombreModulo);
        agregarElementos(0, 1, 1, 3, 1, 0.5, new Insets(5, 5, 5, 5), GridBagConstraints.CENTER, GridBagConstraints.BOTH, new JScrollPane(listaAsignaturasTotal));
        agregarElementos(1, 1, 1, 1, 0, 0, new Insets(5, 5, 5, 5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, botonIzquierda);
        agregarElementos(2, 1, 1, 3, 1, 0.5, new Insets(5, 5, 5, 5), GridBagConstraints.CENTER, GridBagConstraints.BOTH, new JScrollPane(listaAsignaturasConstruidas));
        agregarElementos(1, 2, 1, 1, 0, 0, new Insets(5, 5, 5, 5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, botonDerecha);
        agregarElementos(0, 4, 3, 1, 0, 0, new Insets(5, 5, 5, 5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, panelBotones);

    }

    private void agregarElementos(int x, int y, int tx, int ty, double px, double py, Insets insets, int pos, int relleno, JComponent component) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = y;
        constraints.gridx = x;
        constraints.gridwidth = tx;
        constraints.gridheight = ty;
        constraints.weightx = px;
        constraints.weighty = py;
        constraints.insets = insets;
        constraints.anchor = pos;
        constraints.fill = relleno;
        this.add(component, constraints);

    }

    public JList getListaAsignaturasTotal() {
        return listaAsignaturasTotal;
    }

    public JList getListaAsignaturasConstruidas() {
        return listaAsignaturasConstruidas;
    }

    public DefaultListModel<Asignatura> getModeloAsignaturasTotal() {
        return modeloAsignaturasTotal;
    }

    public DefaultListModel<Asignatura> getModeloAsignaturasConstruidas() {
        return modeloAsignaturasConstruidas;
    }

    public ListSelectionModel getModeloSeleccionListaTotal() {
        return modeloSeleccionListaTotal;
    }

    public ListSelectionModel getModeloSeleccionListaConstruidas() {
        return modeloSeleccionListaConstruidas;
    }

    public JTextField getNombreModulo() {
        return nombreModulo;
    }

    public JButton getBotonAgregar() {
        return botonAgregar;
    }

    public JButton getBotonCancelar() {
        return botonCancelar;
    }

    public JButton getBotonIzquierda() {
        return botonIzquierda;
    }

    public JButton getBotonDerecha() {
        return botonDerecha;
    }
}
