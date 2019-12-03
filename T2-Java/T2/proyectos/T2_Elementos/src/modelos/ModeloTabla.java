package modelos;

import utils.Persona;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {


    Persona[][] personas;
    String[] columnas;
    Class[] tipos = {String.class,Integer.class,Boolean.class,Double.class};


    public ModeloTabla(Persona[][] personas, String[] columnas) {
        this.personas = personas;
        this.columnas = columnas;
    }

    @Override
    public int getRowCount() {
        return personas.length;
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return personas[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return tipos[columnIndex];
    }
}
