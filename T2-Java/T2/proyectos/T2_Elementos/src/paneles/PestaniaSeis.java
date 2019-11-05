package paneles;

import componentes.TextFieldNumeros;
import utils.Persona;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PestaniaSeis extends JPanel implements ActionListener {


    JList listaNormal;
    JButton botonAgregar, botonRellenar;
    DefaultListModel modeloLista;
    ArrayList<Persona> listaPersonas;

    public PestaniaSeis() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }

    private void acciones() {
        botonAgregar.addActionListener(this);
        botonRellenar.addActionListener(this);
        listaNormal.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (listaNormal.getValueIsAdjusting()) {
                    Persona p = (Persona) modeloLista.getElementAt(listaNormal.getSelectedIndex());
                    System.out.println(p.getNombre());
                }
            }
        });
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(listaNormal), BorderLayout.CENTER);
        this.add(botonAgregar, BorderLayout.NORTH);
        this.add(botonRellenar, BorderLayout.SOUTH);
    }

    private void instancias() {

        modeloLista = new DefaultListModel();
        listaNormal = new JList(modeloLista);

        listaNormal.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        // listaNormal.setModel(modeloLista);
        botonAgregar = new JButton("Agregar elemento");
        botonRellenar = new JButton("Rellenar lista");
        listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("asd", "asd", 12, 12, false));
        listaPersonas.add(new Persona("asd1", "asd", 12, 12, false));
        listaPersonas.add(new Persona("asd2", "asd", 12, 12, false));
        listaPersonas.add(new Persona("asd3", "asd", 12, 12, false));
        listaPersonas.add(new Persona("asd4", "asd", 12, 12, false));
        listaPersonas.add(new Persona("asd5", "asd", 12, 12, false));

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonAgregar) {
            modeloLista.addElement("Ejemplo de item");
            //System.out.println(listaNormal.getSelectedIndex());
            //Persona seleccionada = (Persona) listaNormal.getSelectedValue();
            //System.out.println(seleccionada.isDisponibilidad());
            Object seleccionado = modeloLista.getElementAt(listaNormal.getSelectedIndex());
            if (seleccionado.getClass() == Persona.class) {
                Persona pEncontrada = (Persona) modeloLista.getElementAt(listaNormal.getSelectedIndex());
                System.out.println(pEncontrada.isDisponibilidad());
            }
        } else if (e.getSource() == botonRellenar) {
            //modeloLista.addElement(listaPersonas);
            for (Persona item : listaPersonas) {
                modeloLista.addElement(item);
            }
        }
    }


}
