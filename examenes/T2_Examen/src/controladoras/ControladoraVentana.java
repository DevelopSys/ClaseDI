package controladoras;

import utils.Asignatura;
import utils.Modulo;
import vistas.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class ControladoraVentana implements ActionListener, ItemListener {

    Ventana ventana;

    public ControladoraVentana(Ventana ventana) {
        this.ventana = ventana;
        acciones();
    }

    private void acciones() {
        ventana.getPanelConstruir().getBotonDerecha().addActionListener(this);
        ventana.getPanelConstruir().getBotonIzquierda().addActionListener(this);
        ventana.getPanelConstruir().getBotonAgregar().addActionListener(this);
        ventana.getPanelConstruir().getBotonCancelar().addActionListener(this);
        ventana.getPanelDetalle().getComboModulos().addItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventana.getPanelConstruir().getBotonDerecha()) {
            if (!ventana.getPanelConstruir().getModeloSeleccionListaTotal().isSelectionEmpty()) {
                Asignatura a = ventana.getPanelConstruir().getModeloAsignaturasTotal().getElementAt(ventana.getPanelConstruir().getListaAsignaturasTotal().getSelectedIndex());
                ventana.getPanelConstruir().getModeloAsignaturasConstruidas().addElement(a);
            }

        } else if (e.getSource() == ventana.getPanelConstruir().getBotonIzquierda()) {
            if (!ventana.getPanelConstruir().getModeloSeleccionListaConstruidas().isSelectionEmpty()) {
                int n = ventana.getPanelConstruir().getListaAsignaturasConstruidas().getSelectedIndex();
                ventana.getPanelConstruir().getModeloAsignaturasConstruidas().remove(n);
            }
        } else if (e.getSource() == ventana.getPanelConstruir().getBotonAgregar()) {
            if (!ventana.getPanelConstruir().getNombreModulo().getText().isEmpty()){
                ArrayList<Asignatura> lista = new ArrayList<>();
                Enumeration enumeration = ventana.getPanelConstruir().getModeloAsignaturasConstruidas().elements();
                while (enumeration.hasMoreElements()) {
                    lista.add((Asignatura) enumeration.nextElement());
                }
                Modulo modulo = new Modulo(ventana.getPanelConstruir().getNombreModulo().getText(), lista);
                ventana.getPanelDetalle().getModeloCombo().addElement(modulo);
                ventana.getPanelConstruir().getModeloAsignaturasConstruidas().clear();
                ventana.getPanelConstruir().getNombreModulo().setText(null);
            }
        } else if (e.getSource() == ventana.getPanelConstruir().getBotonCancelar()) {
            ventana.getPanelConstruir().getModeloAsignaturasConstruidas().clear();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        ventana.getPanelDetalle().getModeloLista().clear();
        Modulo modulo = (Modulo) ventana.getPanelDetalle().getModeloCombo().getSelectedItem();
        ArrayList<Asignatura> lista = modulo.getAsignaturas();
        for (Asignatura a : lista) {
            ventana.getPanelDetalle().getModeloLista().addElement(a);
        }
    }
}
