package modelos;

import utils.Persona;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloTabla extends AbstractTableModel {


    private ArrayList<Persona> personas;
    private String[] columnas;
    private Class[] tipos = {String.class, String.class, Integer.class, Boolean.class};


    public ModeloTabla(ArrayList personas) {
        this.personas = personas;
        this.columnas = new String[]{"Nombre", "Apellido", "Telefono", "Diponibilidad"};
    }

    @Override
    public int getRowCount() {
        return personas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return personas.get(rowIndex).getNombre();
            case 1:
                return personas.get(rowIndex).getApellido();
            case 2:
                return personas.get(rowIndex).getTelefono();
            case 3:
                return personas.get(rowIndex).isDisponibilidad();
            default:
                return null;
        }
    }

    public void agregarPersona(Persona persona){
        personas.add(persona);
        fireTableDataChanged();
    }

    public void borrarPersona(int index){
        personas.remove(index);
        fireTableDataChanged();
    }

    public Persona personaSeleccionada(int index){
        return personas.get(index);
    }

    public Persona[] personasSeleccionadasMultiple(int[] seleccion){

        Persona[] personas = new Persona[seleccion.length];

        for (int i=0;i<personas.length;i++){
            personas[i]=this.personas.get(i);
        }

        return personas;
    }

    public void borrarPersonaDNI(int dni){
        for (Persona p:personas) {
           /*if (p.getDNI().equals(dni)){
               personas.remove(p);
           }*/
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return tipos[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
