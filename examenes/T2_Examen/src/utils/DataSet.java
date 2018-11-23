package utils;

import java.util.ArrayList;

public class DataSet {

    public static DataSet newInstance() {
        DataSet dataSet = new DataSet();
        return dataSet;
    }

    public ArrayList listaAsignaturas() {
        ArrayList lista = new ArrayList();
        lista.add(new Asignatura("DI"));
        lista.add(new Asignatura("PSP"));
        lista.add(new Asignatura("PMDM"));
        lista.add(new Asignatura("ASO"));
        lista.add(new Asignatura("SI"));
        lista.add(new Asignatura("SGE"));
        lista.add(new Asignatura("AD"));
        lista.add(new Asignatura("IAW"));
        lista.add(new Asignatura("ING"));
        lista.add(new Asignatura("XML"));
        lista.add(new Asignatura("BD"));
        lista.add(new Asignatura("FCT"));
        return lista;
    }
}
