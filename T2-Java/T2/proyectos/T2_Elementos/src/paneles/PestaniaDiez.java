package paneles;

import modelos.ModeloTabla;
import utils.Persona;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PestaniaDiez extends JPanel implements ActionListener {

    JTable tabla;
    //DefaultTableModel modeloSimple;
    ModeloTabla modeloTabla;
    JButton bAgregar, bBorrar, bSeleccinado, bSeleccionMultiple;
    JPanel pSur;


    public PestaniaDiez() {

        initGUI();
    }

    public void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }

    private void acciones() {
        bAgregar.addActionListener(this);
        bBorrar.addActionListener(this);
        bSeleccinado.addActionListener(this);
        bSeleccionMultiple.addActionListener(this);
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("cambio de selección");
            }
        });

    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(tabla), BorderLayout.CENTER);
        this.add(configurarSur(), BorderLayout.SOUTH);

    }

    private JPanel configurarSur() {
        pSur.setLayout(new GridLayout(4, 1));
        pSur.add(bAgregar);
        pSur.add(bBorrar);
        pSur.add(bSeleccinado);
        pSur.add(bSeleccionMultiple);
        return pSur;
    }

    private void instancias() {


        ArrayList personas = new ArrayList();
        personas.add(new Persona("N1","A1",234123,23,false));
        personas.add(new Persona("N2","A2",345634,42,true));
        personas.add(new Persona("N3","A3",6455,15,false));
         modeloTabla = new ModeloTabla(personas);
        //modeloSimple = new DefaultTableModel(datos, columnas);
        tabla = new JTable(modeloTabla);
        bAgregar = new JButton("Agregar");
        bBorrar = new JButton("Borrar");
        pSur = new JPanel();
        bSeleccinado = new JButton("Seleccionado");
        bSeleccionMultiple = new JButton("Selección multiple");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bAgregar) {

            Persona p = new Persona("NNuevo","ANuevo",123123,32,true);
            // modeloTabla.getPersonas().add(p);
            // modeloTabla.fireTableDataChanged();
            modeloTabla.agregarPersona(p);

        } else if (e.getSource() == bBorrar) {
            modeloTabla.borrarPersona(tabla.getSelectedRow());

        } else if (e.getSource() == bSeleccinado) {

            Persona persona = modeloTabla.personaSeleccionada(tabla.getSelectedRow());
            System.out.println(persona.getEdad());

        } else if (e.getSource() == bSeleccionMultiple) {
            Persona[] seleccionadas = modeloTabla.personasSeleccionadasMultiple(tabla.getSelectedRows());
            for (Persona p: seleccionadas) {
                System.out.println(p.getEdad());
            }
        }
    }
}
