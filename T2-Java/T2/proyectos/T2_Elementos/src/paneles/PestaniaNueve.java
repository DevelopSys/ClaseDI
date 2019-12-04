package paneles;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PestaniaNueve extends JPanel implements ActionListener {

    JTable tabla;
    DefaultTableModel modeloSimple;
    JButton bAgregar, bBorrar, bSeleccinado, bSeleccionMultiple;
    JPanel pSur;


    public PestaniaNueve() {

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

    private JPanel configurarSur(){
        pSur.setLayout(new GridLayout(4,1));
        pSur.add(bAgregar);
        pSur.add(bBorrar);
        pSur.add(bSeleccinado);
        pSur.add(bSeleccionMultiple);
        return pSur;
    }

    private void instancias() {


        String datos[][] = {{"Nombre","Apellido","123"},{"Nombre","Apellido","123"},{"Nombre","Apellido","123"},
                {"Nombre","Apellido","123"}};
        String columnas[] = {"Nombre","Apellido","Telefono"};
        modeloSimple = new DefaultTableModel(datos,columnas);
        tabla = new JTable(modeloSimple);
        bAgregar = new JButton("Agregar");
        bBorrar = new JButton("Borrar");
        pSur = new JPanel();
        bSeleccinado =  new JButton("Seleccionado");
        bSeleccionMultiple =  new JButton("Selección multiple");



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bAgregar){
            String[]datos = {"nuevo","nuevo","nuevo"};
            if (tabla.getSelectedRow()==-1){
                modeloSimple.addRow(datos);
            }else {
                modeloSimple.insertRow(tabla.getSelectedRow(), datos);
            }
            modeloSimple.fireTableDataChanged();
        } else if (e.getSource() == bBorrar){

            // int ultima = modeloSimple.getRowCount();
            // modeloSimple.removeRow(ultima);
            if (tabla.getSelectedRow()==-1){
                JOptionPane.showMessageDialog(this,"Por favor selecciona una fila",
                        "Fallo al borrar", JOptionPane.WARNING_MESSAGE);
            } else {
                modeloSimple.removeRow(tabla.getSelectedRow());
            }modeloSimple.fireTableDataChanged();

        } else if (e.getSource() == bSeleccinado){

            /*int filaSeleccionda = tabla.getSelectedRow();
            int columnaSeleccionada = tabla.getSelectedColumn();
            System.out.println(modeloSimple.getValueAt(filaSeleccionda,columnaSeleccionada));*/

            for (int i=0;i<tabla.getColumnCount();i++){
                System.out.println(modeloSimple.getValueAt(tabla.getSelectedRow(),i));
            }


            //tabla.getSelectionModel().
        } else if (e.getSource() == bSeleccionMultiple){
            int[]seleccionadas = tabla.getSelectedRows();
            for (int index:seleccionadas) {
                /*for (int i=0;i<tabla.getColumnCount();i++){
                    System.out.println(modeloSimple.getValueAt(index,i));
                }*/
                modeloSimple.removeRow(index);
            }
        }
    }
}
