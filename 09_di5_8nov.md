# Octava semana

## TEMA 2 SWING

### MIERCOLES

1. Evaluar la pulsación multiple de la lista
````
int[] indices = lista.getSelectedIndices();
            for (int temporal: indices) {
                //System.out.println(temporal);
                System.out.println(lista.getModel().getElementAt(temporal).toString());
}
````

### JUEVES  

**Uso de los JComboBox**
***

1. Crear un elemento JComboBox y un modelo de datos para asociarlo a la lista
````
modeloDatos = new DefaultComboBoxModel();
container = getContentPane();
comboBox = new JComboBox(modeloDatos);
````
2. Agregar cosas al modelo para que aparezcan dento del combo
````
modeloDatos.addElement(Opción 1);
modeloDatos.addElement(Opción 2);
modeloDatos.addElement(Opción 3);
modeloDatos.addElement(Opción 4);
````
5. Evaluar la pulación del combo
````
comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                e.getItem();
                e.getStateChange();
                System.out.println(comboBox.getSelectedIndex());
                modeloDatos.getElementAt(comboBox.getSelectedIndex());
            }
});
````

### VIERNES

**Evaluar acciones en un elemento JList**
1. Evaluar el cambio de datos en una lista
````
modeloDatosLista.addListDataListener(new ListDataListener() {
            @Override
            public void intervalAdded(ListDataEvent e) {
                
            }

            @Override
            public void intervalRemoved(ListDataEvent e) {

            }

            @Override
            public void contentsChanged(ListDataEvent e) {

            }
        });
```` 
