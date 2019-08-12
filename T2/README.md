<a name="tema2"></a>
## Swing

Swing es la libreria utilizada para la representación de intefaces gráficas. Sus principales elementos son:

- Layouts
- Contenedores
- JComponents
- Eventos

Para crear una aplicación

1. Crear una clase con el método main
````
````
2. Crear una clase que extienda de JFrame
````
public class Ventana extends JFrame {
    
    private  void initGUI(){
        this.setTitle("Primera ventana");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setLocation(50,50);
    }
    
}
````
Algunos métodos interesantes del elemento JFrame son:

- setVisible
- setTitle
- setLocation
- setLocationRelativeTo
- pack

3. Es recomendable crear un método intancias donde se intancien todos los elementos que formarán parte de la interfaz
````
public class Ventana extends JFrame {

    JButton boton;

    protectec void initGUI(){
        instancias();
        this.setTitle("Primera ventana");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setLocation(50,50);
    }

    private void instancias(){
        boton = new JButton("Pulsar");
    }
}
````
4. Desde la clase Entrada, instanciar un objeto de la clase ventana y llamar al método init

````
public class Entrada {

    public static void main(String[] args) {

        Ventana ventana = new Ventana();
        ventana.initGUI();
    }
}

````

Un objeto muy importante a la hora de trabajar con Swing es el container, el cual actua como contenedor de todos los elementos de la ventana. Para ello es recomendable instanciar este objeto que será utilizado de forma muy recurrente

````
public class Ventana extends JFrame {

    Container container;

    protected void initGUI(){
        instancias();
    }

    private void instancias(){
        container = this.getContentPane();
    }
}

````


#### Agregar un elemento a un JFrame
***

Para agregar elementos a un JFrame se utiliza el método add
````
container.add("NombreB1",boton1);
container.add("NombreB2",boton2);
````


#### Obtener todos los elementos de un JFrame
***

En ocasiones es necesario obtener todos los elementos que estén dentro de un contenedor. Para ello el método getContainer explicado en el punto anterior es muy útil

````
import javax.swing.*;
import java.awt.*;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

public class Ventana extends JFrame {

    Container container;
    JButton boton1, boton2;

    protected void initGUI(){
        instancias();
        agregarElemento();
        this.setTitle("Primera ventana");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setLocation(50,50);

    }

    private void agregarElemento() {
        container.add(boton1);
        container.add(boton2);
        Component[] componentes = container.getComponents();
        for (Component component: componentes
             ) {
            System.out.println(component.getName());
        }

    }

    private void instancias(){
        boton1 = new JButton("Pulsar");
        boton2 = new JButton("Elemento");
        boton1.setName("Boton1");
        boton1.setName("Botón2");


        container = this.getContentPane();
    }
}
````

**Manejar eventos sobre una ventana**


a. Layouts

- http://www.developandsys.es/layouts-swing/

Los layouts son elementos invisibles que se encargan de repartir los elementos por el espacio. Por defecto cada contenedor tiene su propio layout asignado, pero este puede ser modifcado. Los layouts por defecto son:

- JFrame: BorderLayout
- JPanel: FlowLayout

Para poder utilizar cualquier layout lo primero que hay que hacer es setear el contenedor correspondiente mediante el método setLayout

````
container.setLayout(new BorderLayout(20,20));
````


#### BorderLayout
***


Se trata de un layout que reparte los elementos en los puntos cardinales: arriba, izquierda, derecha y abajo. Para utilizarlo

1. Setear el elemento con el layout border
````
container.setLayout(new BorderLayout(20,20));
````
2. Agregar los elementos correspondientes en el punto que se quieran añadir
````
container.setLayout(new BorderLayout(20, 20));
container.add(new JLabel("NORTE"), BorderLayout.NORTH);
container.add(new JLabel("SUR"), BorderLayout.SOUTH);
container.add(new JLabel("ESTE"), BorderLayout.EAST);
container.add(new JLabel("OESTE"), BorderLayout.WEST);
container.add(new JLabel("CENTRO"), BorderLayout.CENTER);
````

3. En el caso de querer alinear el elemento agregado en un punto, este debe ser declarado antes
````
JLabel label = new JLabel("NORTE");
container.add(label, BorderLayout.NORTH);
label.setHorizontalAlignment(SwingConstants.CENTER);
````
#### FlowLayout
***
Este tipo de layout agrega los elementos de izquierda a derecha repartiendo el espacio entre ellos
1. Setear el elemento con el layout border
````
container.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
````
2. Agregar los elementos correspondientes en el punto que se quieran añadir
````
JLabel label = new JLabel("UNO");
container.add(label);
container.add(new JLabel("DOS"));
container.add(new JLabel("TRES"));
container.add(new JLabel("CUATRO"));
container.add(new JLabel("CINCO"));
````

#### BoxLayout
***
Este tipo de layout sirve para colocar elementos en el eje de las x o en el eje de las y, repartiendo el espacio de forma absoluta

1. Setear el contenedor como boxlayout, indicando el elemento que gestiona el layout y el eje
````
// o X_AXIS
container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
````
2. Agregar los elementos correspondientes en el punto que se quieran añadir
````
JLabel label = new JLabel("UNO");
container.add(label);
container.add(new JLabel("DOS"));
container.add(new JLabel("TRES"));
container.add(new JLabel("CUATRO"));
container.add(new JLabel("CINCO"));
````

#### GridLayout
****
Para configurar un layout n eun contenedor se utilizar el método setLayout(). GridLayout dispone los elementos de izquierda a derecha en un número de filas , columnas indicados en el constructor

1. Setear un panel con GridLayout 4 filas 1 columna y espacio entre ellas
````
pDerecha.setLayout(new GridLayout(4,1,10,0));
````
2. Modificar características del layout
````
((GridLayout)pDerecha.getLayout()).setRow(3)
````
3. Agregar elementos al panel
````
pDerecha.add(b1);  
pDerecha.add(b2);  
pDerecha.add(b3);  
pDerecha.add(b4);
````

#### CardLayout
****

Este tipo de layout permite visualizar un elemento contreto sobre varios añadidos en el mismo contenedor. Para ello:

1. Setear el panel con CardLayout (recomendable declararlo antes)
````
CardLayout cardLayout = new CardLayout();
container.setLayout(cardLayout);
````
2. Agregar los elementos con una constraint, que será utilizada para poder llamarlos cuando quieran ser mostrador
````
container.add(new JLabel("DOS"), "uno");
container.add(new JLabel("TRES"), "dos");
container.add(new JLabel("CUATRO") "tres");
container.add(new JLabel("CINCO"), "cuatro");
````
3. Indicar a la variable cardlayout cual es el elemento que quiere ser mostrado
````
cardLayout.show(container,"uno");
````
**Trabajo con cardlayout**
Además de poder mostrar un panel en concreto, un cardlayout permite una serie de operaciones tales como 

1. Mostrar el siguiente panel de la pila
```
cardLayout.next(pCentral)
```
2. Mostrar el panel previo de la pila
```
cardLayout.previous(pCentral)
```
3. Mostrar el primer panel de la pila
```
cardLayout.first(pCentral)
```
4. Mostrar el último panel de la pila
```
cardLayout.last(pCentral)
```
5. Comprobar si un panel se está mostrando
```
panel.isShowing()
```

#### GridBagLayout
****

Este tipo de layout es uno de los más utilizados por sus multiples posibilidades. Es complejo de utilizar pero muy modulable. Además de los elementos que se añaden, también consta de constraint las cuales le indica al elemento en que posición debe ponerse y con qué características.

1. Crear una variable de tipo GridBagConstraint y setear el layout al panel correspondiente
````
GridBagConstraints constraints = new GridBagConstraints();
container.setLayout(new GridBagLayout());
````

2. Configurar las restricciones de constraint en posición  (x,y)
````
constraints.gridx = 0;
constraints.gridy = 0;
````
3. Agregar el elemento teneiendo en cuenta las restricciones asociadas
````
container.add(etiquetaPara,constraints);
````
4. Crear un método que me permita trabajar de forma conjunta con todos los parámetros
````
//sustituye a la configuración individual de cada uno de los elementos
private void configurarConstrait(int x, int y, Component c){
constraints.gridx = x;
constraints.gridy = y;
container.add(c,constraints);
}
````
5. Utilizar un método para poder trabajar de forma más eficiente
````
configurarConstraint(0,0,etiquetaPara)
````

**Utilizar todos los elementos del gridbag**

1. Modificar las restricciones de tamaño, peso , relleno, alineamiento, margenes
````
constraints.gridx = 0;
constraints.gridy = 0;
// peso
constraints.weightx=0.5;
constraints.weighty=0.5;
// tamaño
constraints.gridwidth=1;
constraints.gridheight=1;
// rellenar
constraints.fill = GridBagConstraints.BOTH;
// posición interna
constraints.anchor = GridBagConstraints.CENTER;
// separaciones
constraints.insets = new Insets(5,5,5,5);
````
2. Modificar el método de agregar para trabajar con todas las restricciones
````
private void configurarConstrait(int x, int y, int tx, int ty, int px, int py, Insets ins, int anchor, int fill, Component c){
constraints.gridx = x;
constraints.gridy = y;
constraints.gridwidth = tx;
constraints.gridheight = ty;
constraints.weightx = px;
constraints.weighty = py;
constraints.insets = ins;
constraints.anchor = anchor;
constraints.fill = fill;
container.add(c,constraints);
}
````
3. Agregar elementos utilizando el método creado
````
configurarConstrait(0,0,1,1,0.5,0.5,
                new Insets(5,5,5,5),GridBagConstraints.CENTER,GridBagConstraints.BOTH,etiquetaPara);
````

#### SpringLayout
***



**Interfaces dinámicas**
***
Del mismo modo que se puede agregar cosas a la GUI de forma estática, las cosas pueden ser añadidas de forma automática al layout
1. Agregar cosas a un contenedor
````
pCentro.add(pCentroDos);
````
2. Eliminar cosas de un contenedor
````
pCentro.remove(pCentroDos);
ó
// borrar según una posición
pCentro.remove(2)
````
3. Obtener elementos de un contenedor
````
pCentro.getComponents();
````
Hay que tener en cuenta que siempre se debería hacer un pack cada vez que cambie la interzaf

#### [Volver al índice](#tema2)
***

b. Contenedores

- http://www.developandsys.es/elementos-graficos-frame/
- http://www.developandsys.es/elementos-graficos-split/

Como se ha comentado en el punto anterior, uno de los elementos de los que constan las interfaces gráficas son los contenedores. Los princpales contenedores de swing son:
- Ventanas (JFrame): cuyo uso se ha explicado al principio del tema
- JPanel
- JDialog: los cuales se explicarán con detalle en el tema de diálogos
- JInternalFrama
#### JPanel
***

Por defecto un panel es un contenedor de objetos que no necesita ser mostrado ya que lo está por defecto. Una vez el panel se agrega a otro contenedor (suele ser una ventana), lo útil es setearle un layout y trabajar con los elementos que estarán dentro. Algunos métodos para trabajar con paneles:
````
// cambiar color de fondo
panel.setBackground(Color.LIGHT_GRAY);
// poner un borde al panel
panel.setBorder(BorderFactory.createTitledBorder("Trabajo con paneles"));
// agregar un elemento
panel.add(new JLabel("Elemento"));
// indicar tamaño mínimo
panel.setMinimumSize(new Dimension(800,800));
// indicar tamaño predefinido
panel.setPreferredSize(new Dimension(800,800));
// indicar tamaño máximo
panel.setMaximumSize(new Dimension(300,300));
````

**Trabajo con eventos de un panel**
Existen numerósos listener que se pueden aplicar a un panel, pero los principales son:

````
panel.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                System.out.println("res");
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                System.out.println("movido");
            }

            @Override
            public void componentShown(ComponentEvent e) {
                System.out.println("mostrado");

            }

            @Override
            public void componentHidden(ComponentEvent e) {
                System.out.println("escondido");

            }
        });
        
panel.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
                System.out.println("añadido");

            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                System.out.println("borrado");

            }
        });
````

#### JSplitPane

Contenedor que permite contener a dos paneles o elementos dispuestos en horizontal o vertical, pudiendo mostrar unou otro o los dos al mismo tiempo.
1. Declarar el split con su tipo de movimiento
````
JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);
````
2. Declarar los elementos que estarán contenidos e indicar donde serán mostrados
````
JPanel panelIzquierda = new JPanel();
JPanel panelDerecha = new JPanel();
splitPane.setLeftComponent(panelIzquierda);
splitPane.setRightComponent(panelDerecha);
````
3. Declarar las características del split
````
splitPane.setContinuousLayout(true);
splitPane.setDividerSize(10);
splitPane.setOneTouchExpandable(true);
splitPane.setResizeWeight(0.5);
````

#### JTabberPane
***

1. Declarar un objeto de tipo JTabbedPane
````
panelPestanias = new JTabbedPane();
//Se puede indicar tambien la posición que tendran las penstañas
panelPestanias = new JTabbedPane(SwingConstants.BOTTOM);
````
2. Mediante el método addTab agregar pestanias
````
panelPestanias.addTab("Pestaña1",null,new JPanel(),"tooltip1");
panelPestanias.addTab("Pestaña2",null,new JPanel(),"tooltip2");
````
3. Obtener información y trabajar con el panel de pestañas
````
//Añade una pestana con título, icono, componente y tooltip
panelPestanias.addTab("Pestania 1",null,pestania1,"Cerrar pestania");
//Asocia a la pestaña 1 el atajo de teclado 1 (Ctrl + Alt)
panelPestanias.setMnemonicAt(0, KeyEvent.VK_1);
//Obtiene el índice de la pestaña seleccionadda
panelPestanias.getSelectedIndex();
//Obtiene el número total de pentañas
panelPestanias.getTabCount();
//Pone como selección la pestaña numero 1
panelPestanias.setSelectedIndex(0);
//Obtiene la penstania asociada al componente concreto
panelPestanias.indexOfComponent(pestania4);
//Cambia la localizción de la pestania
panelPestanias.setTabPlacement(SwingConstants.TOP);
````
4. Tratar eventos en el elemento jtabbedpane
````
panelPestanias.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                
            }
        });
````

#### [Volver al índice](#tema2)
***

c. Botones, Check, radios, ComboBox, Spinner, ProgressBar

- http://www.developandsys.es/elementos-graficos-swing-botones/
- http://www.developandsys.es/elementos-graficos-checkbox-radiobutton-y-otros/

- http://www.developandsys.es/elementos-graficos-combobox/
- http://www.developandsys.es/elementos-graficos-spinner-2/
- http://www.developandsys.es/barra-de-progreso/


#### Botones
****

Los botones son los elementos principales para trabajar con formularios. Para poder utilizarlos: 

1. Crear una variable de tipo JButton
```
JButton boton1 = new JButton();
```
2. Algunos de los métodos que se pueden utilizar son
````
boton1.setActionCommand("accion_boton1");
boton1.setName("boton1");
boton1.setEnabled(true);
boton1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,22));
boton1.setPreferredSize(new Dimension(50,50));
boton1.setFocusable(true);
````

**Manejo de eventos con los botones**

Se pueden utilizar muchos listaner con los botones, pero principalmente se utiliza el listener de pulsación
````
botonInicial3.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
})
````
En el caso de haber varios elementos con actionlistener configurado se deberá evaluar la fuente del evento producido
````
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == boton1){
        System.out.println("Pulsado botón1");
    }
}

````

Del mismo modo, si el elemento tiene configurado un stringaction, se puede evaluar desde el evento producido
````
public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("accion_boton1")){
        System.out.println("Pulsado botón1");
    }
}
````

#### Botones con imágenes
****

**JButton con imagenes**
1. Agregar las imagenes a un paquete llamado resources
2. Para poder las imagenes al botón se puede realizar mediante los metodos setXXXIco() pasando un objeto de tipo ImageIco (accedido desde el proyecto, nunca con ruta del sistema de ficheros)
````
botonImagenes.setIcon(new ImageIcon(getClass().getResource("./recursos/up.png")));
botonImagenes.setPressedIcon(new ImageIcon(getClass().getResource("./recursos/up_press.png")));
botonImagenes.setRolloverIcon(new ImageIcon(getClass().getResource("./recursos/down.png")));
botonImagenes.setToolTipText("Raton por encima del elemento");
````
3. Eliminar fondos y pintados de bordes segun selección
````
botonImagenes.setBorderPainted(false);
botonImagenes.setFocusPainted(false);
botonImagenes.setBackground(null);
````

#### ToggleButton
****

1. Agregar las imagenes a un paquete llamado resources
2. Para poder las imagenes al botón se puede realizar mediante los metodos setXXXIco() pasando un objeto de tipo ImageIco (accedido desde el proyecto, nunca con ruta del sistema de ficheros)
````
botonTog.setIcon(new ImageIcon(getClass().getResource("./recursos/down.png")));
botonTog.setSelectedIcon(new ImageIcon(getClass().getResource("./recursos/down_press.png")));
````
3. Eliminar fondos y pintados de bordes segun selección
````
botonTog.setBorderPainted(false);
botonTog.setFocusPainted(false);
botonTog.setBackground(null);
````
4. Agregar un listener para evaluar cuando cambia la selección / desellección del toggle
````
botonTog.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange()==ItemEvent.SELECTED){
            toggleButton.setText("Seleccionado"); 
        }
        else{
            toggleButton.setText("Deseleccionado"); 
        }
    }
});

botonTog.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("Estado cambiado: " + ((JToggleButton) e.getSource()).isSelected());
            }
});
````

#### ButonGroup http://www.developandsys.es/elementos-graficos-checkbox-radiobutton-y-otros/
***
Se trata de la unión lógica de elementos para que tan solo uno pueda estar seleccionado.
1. Creación de los elementos
````
JButton op1 = new JButton("Opción 1");
JButton op2 = new JButton("Opción 2");
JButton op3 = new JButton("Opción 3");
````
2. Creación del ButtonGroup
````
ButtonGroup grupoBotones = new ButtonGroup();
````
3. Agregar los elementos al ButtonGroup
````
grupoBotones.add(op1);
grupoBotones.add(op2);
grupoBotones.add(op3);
````
#### CheckBox - http://www.developandsys.es/elementos-graficos-checkbox-radiobutton-y-otros/
***
Utilizado para una selección / deselección
1. Crear el elemento check
````
// se puede indicar también el icono en el constructor
JCheckBox checkBox = new JCheckBox("Seleccion",false);
````
2. Personalizarlo con los iconos
````
checkBox.setIcon(new ImageIcon(getClass().getResource("./recursos/up.png")));
checkBox.setSelectedIcon(new ImageIcon(getClass().getResource("./recursos/up_press.png")));
````
3. Obtener información de su estado
````
checkBox.isSelected();
checkBox.setSelected(true);
````
4. Manejar el evento asociado obteniendo informacion del evento ItemEvent --> e.getSetateChange()
````
checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){

                }
                else {

                }
            }
});
````
#### RadioButton - http://www.developandsys.es/elementos-graficos-checkbox-radiobutton-y-otros/
***
1. Crear el elemento radio
````
// se puede indicar también el icono en el constructor
JRadioButton radioButton = new JRadioButton("Opción",false);
````
2. Personalizarlo con los iconos
````
radioButton.setIcon(new ImageIcon(getClass().getResource("./recursos/down.png")));
radioButton.setSelectedIcon(new ImageIcon(getClass().getResource("./recursos/down_press.png")));
````
3. Obtener información de su estado
````
radioButton.isSelected();
radioButton.setSelected(false);
````
4. Manejar el evento asociado obteniendo informacion del evento ItemEvent --> e.getSetateChange()
````
radioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){

                }
                else {

                }
            }
});
````
En la mayoria de los casos este tipo de botones se suele utilizar dentro de un grupo

1. Crear los radios
````
JRadioButton radioButtonOpcion1 = new JRadioButton("Opción 1",false);
JRadioButton radioButtonOpcion2 = new JRadioButton("Opción 2",true);
````
2. Crear el grupo de botones y agregar los botones al grupo
````
ButtonGroup grupoRadios = new ButtonGroup();
grupo.add(radioButtonOpcion1);
grupo.add(radioButtonOpcion2);
````
#### Spinner http://www.developandsys.es/elementos-graficos-spinner-2/
***
1. Crear el elemento.
````
/ /se puede indicar el modelo en el constructor
JSpinner spinnerNumeros = new JSpinner();
````
2. Asignarle un modelo de datos

2.1 Modelo de números indicando máximo y mínimo
````
SpinnerNumberModel modeloNumero = new SpinnerNumberModel();
modeloNumero.setMaximum(99);
modeloNumero.setMinimum(0);
modeloNumero.setStepSize(5);
modeloNumero.setValue(50);
````
2.2 Modelo de datos indicando la colección a representar
````
ArrayList listaDatos = new ArrayList();
listaDatos.add("Verde");
listaDatos.add("Amarillo");
listaDatos.add("Azul");
SpinnerListModel modeloDatos = new SpinnerListModel(listaDatos);
````
2.3 Poner el modelo
```
spinnerNumeros.setModel(modeloNumero);
```

3. Obtener información del spinner ó modelo
````
spinnerNumeros.getModel().getValue();
spinnerNumeros.getModel().getValue();
spinnerNumeros.getModel().setValue(20);
spinnerNumeros.getModel().getNextValue();
spinnerNumeros.getModel().getPreviousValue();
listaDatos.add("Rojo");
````
4. Manejar el evento asociado 
````
spinnerNumeros.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(spinnerNumeros.getModel().getValue());

            }
});
````

#### JTextField http://www.developandsys.es/elementos-graficos-swing-textos/
***

Un campo de texto es el principal elemento para poder capturar datos de los usuarios mediante por ejemplo formulario

1. Cear el elemento
````
JTextField textFieldNumeros = new JTextField(10);
````
2. Algunas de las opciones interesantes de los textos son
````
JTextField textField = new JTextField("Introduce texto");
textField.setColumns(10);
textField.setHorizontalAlignment(SwingConstants.CENTER);
textField.setEnabled(true);
textField.setToolTipText("Introduce un dato concreto");
textField.setSelectedTextColor(Color.RED);
````
**Evaluar eventos de un JTextField**

Se pueden asognar muchos eventos, pero principalmente se trabaja con la pulsación de teclas:
````
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
````

Más concretamente si se quiere actuar ante una pulsación evaluando el evento consumiendo la pulsación si no es número o tiene una longitud determinada se puede utilizar un adaptador en vez de un listener (se explicará más adelante)

````
textFieldNumeros.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Character c = e.getKeyChar();

                if (!Character.isDigit(c) || textFieldNumeros.getText().length() > 5){
                    e.consume();
                }
            }
        });
````
Si se quiere quitar y poner un hint al seleccionar el texto
````
textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (((JTextField) e.getSource()).getText().equals("hint")) {
                    ((JTextField) e.getSource()).setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (((JTextField) e.getSource()).getText().isEmpty()) {
                    ((JTextField) e.getSource()).setText("hint");
                }
            }
        });
````

Para poder asignar un formato más concreto se puede utilzar un objeto de tipo JFormattedTextField
1. Crear un NumberFormat de integer indicandole las características que debe cumplir
````
NumberFormat formatoNumero = NumberFormat.getIntegerInstance();
formatoNumero.setMinimumIntegerDigits(3);
````
2. Crear el objeto JFormattedTextField y asignar el formato al elemento
````
JFormattedTextField customFormatField =
new JFormattedTextField(new NumberFormatter(formatoNumero));
````
3. Obtener información del elemento
````
customFormatField.getValue();
````
#### JTextarea
***


#### Combobox
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
3. Evaluar la pulación del combo
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

#### [Volver al índice](#tema2)
***

d. Listas

- http://www.developandsys.es/elementos-graficos-list/

#### Listas
***

1. Crear un elemento JList y un modelo de datos para asociarlo a la lista
````
DefaultListModel modeloDatosLista = new DefaultListModel();
JList lista = new JList(modeloDatosLista);
JScrollPane scroll = new JScrollPane(lista);
````
3. Modificar el modo de selección
````
lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
// ó
lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
// ó
lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

````
4. Agregar cosas al modelo para que aparezcan dento de la lista
````
Persona persona1 = new Persona("asd", "asd", 123);
Persona persona2 = new Persona("sdfs", "asd", 123);
Persona persona3 = new Persona("sdfsdf", "asd", 123);
modeloDatosLista.addElement(persona1);
modeloDatosLista.addElement(persona2);
modeloDatosLista.addElement(persona3);
````
5. Evaluar la pulación de la lista
````
lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()){

                    Persona p = (Persona) modeloDatosLista.get(lista.getSelectedIndex());
                    System.out.println(p.getTelefono());


                } 
            }
        });
````
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

**Evaluar la pulsación multiple en una lista**

````
int[] indices = lista.getSelectedIndices();
            for (int temporal: indices) {
                //System.out.println(temporal);
                System.out.println(lista.getModel().getElementAt(temporal).toString());
}
````



#### [Volver al índice](#tema2)
***

e. Manejo de eventos

- http://www.developandsys.es/manejo-de-eventos-en-swing/

#### [Volver al índice](#tema2)
***

f. MVC

- http://www.developandsys.es/modelo-vista-controlador/

1. Declarar una clase que extienda de el elemento gráfico a tratar con todas sus configuraciones gráficas
````
public class Vista extends JFrame {
 
    JTextField nombre;
    JButton boton;
    JPanel contenedor;
    JPanel pPrincipal;
 
    Vista() {
        initComponent();
    }
 
    private void initComponent() {
        instancias();
        configurarEspacio();
        this.setTitle("Ejemplo modelo vista controlador");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
 
    }
 
    private void configurarEspacio() {
        pPrincipal.add(new JLabel("Introduce un nombre para probar"));
        pPrincipal.add(nombre);
        pPrincipal.add(boton);
        contenedor.add(pPrincipal);
     }
 
    private void instancias() {
        nombre = new JTextField("Introduce nombre", 10);
        boton = new JButton("Enviar");
        pPrincipal = new JPanel();
        contenedor = (JPanel) getContentPane();
    }
 
    public JTextField getNombre() {
        return nombre;
    }
 
    public JButton getBoton() {
        return boton;
    }
}
````
Hay que tener en cuenta que en esta parte puedo trabajar de forma individual con los paneles  (cada panel una clase)
2. Creo una clase que es el modelo, donde aparecerán las acciones que se pueden llevar a cabo
````
public class Modelo {
 
    public String mostrarFormateo(String nombre){
 
        return "El nombre introducido es: "+nombre;
    }
 
}
````
3. Creo una clase que maneja los listener de cada uno de los elementos gráficos que se quiera, accediendo a ellos mediante un objeto del tipo Ventana, Panel, etc... y sus getters asociados
````
public class Controlador implements ActionListener {
 
    Vista objetoVista;
    Modelo objetoModelo;
 
    public Controlador(Vista objetoVista, Modelo objetoModelo) {
        this.objetoVista = objetoVista;
        this.objetoModelo = objetoModelo;
        acciones();
    }
 
    private void acciones() {
        objetoVista.getBoton().addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(objetoModelo.mostrarFormateo(objetoVista.getNombre().getText()));
    }
}
````
4. Por último se crea en el main todas las clases correspondientes y se hace la comunicación entre ellas mediante los constructores
````
public class Entrada {
 
    public static void main (String [] args){
        Vista v = new Vista();
        Modelo m = new Modelo();
        Controlador c = new Controlador(v,m);
    }
}
````

#### [Volver al índice](#tema2)
***

h. Tablas

- http://www.developandsys.es/modelo-personalizado-tabla/
- http://www.developandsys.es/elementos-graficos-tablas/

#### [Volver al índice](#tema2)
***

i. Árboles

- http://www.developandsys.es/elementos-graficos-arboles/
- http://www.developandsys.es/modelo-render-jtree/

#### [Volver al índice](#tema2)
***

j. Menús

- http://www.developandsys.es/menu/
- http://www.developandsys.es/menu-contextual/

#### Menús de barra
***

1. Crear un objeto de tipo JMenuBar, JMenu, JMenuItem
````
barraMenu = new JMenuBar();
menuFichero = new JMenu("Fichero");
menuItemNuevo = new JMenuItem("Abrir");
menuItemCerrar = new JMenuItem("Cerrar");
menuEditar = new JMenu("Editar");
menuItemCopiar = new JMenuItem("Copiar");
menuItemCortar = new JMenuItem("Cortar");
menuEditarInterno = new JMenu("Editar interno");
menuItemIterno = new JMenuItem("interno");
menuItemInternoCheck = new JCheckBoxMenuItem("Seleccion");
menuItemIternoRadio1 = new JRadioButtonMenuItem("Opcion 1");
menuItemIternoRadio2 = new JRadioButtonMenuItem("Opcion 2");
grupoRadios = new ButtonGroup();
grupoRadios.add(menuItemIternoRadio1);
grupoRadios.add(menuItemIternoRadio2);
````
2. Organizar la estructura del menú
````
private void configuMenu() {
        barraMenu.add(menuFichero);
        menuFichero.add(menuItemNuevo);
        menuFichero.add(menuItemCerrar);
        barraMenu.add(menuEditar);
        menuEditar.add(menuItemCortar);
        menuEditar.add(menuItemCopiar);
        menuEditar.addSeparator();
        menuEditar.add(menuEditarInterno);
        menuEditarInterno.add(menuItemIterno);
        menuEditarInterno.add(menuItemInternoCheck);
        menuEditarInterno.add(menuItemIternoRadio1);
        menuEditarInterno.add(menuItemIternoRadio2);
}
````
3. Agregar la barra del menú a la parte superior
````
this.setJMenuBar(barraMenu);
````
4. Modificar el comportamiento en aspecto y teclas de los items
````
menuItemNuevo.setIcon(new ImageIcon(getClass().getResource("RUTA_DEL_RECURSO")));
menuItemNuevo.setMnemonic(KeyEvent.VK_E);
menuItemNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.ALT_MASK));
````
5. Darle acciones a cada uno de los elementos
````
menuItemNuevo.addActionListener(this);
menuItemCerrar.addActionListener(this);
menuItemCopiar.addActionListener(this);
menuItemCortar.addActionListener(this);
menuItemIterno.addActionListener(this);
````
6. Evaluar la pulsación de los elementos del menú
````
@Override
public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemNuevo) {
            System.out.println("pulsado");
        } else if (e.getSource() == menuItemCerrar) {
            System.exit(0);
        } else if (e.getSource() == menuItemCopiar) {

        } else if (e.getSource() == menuItemCortar) {

        } else if (e.getSource() == menuItemIterno) {

        }
    }
````

#### Menús contextuales
***
1. Crear un objeto de tipo JPopUp y los elementos que se quieran asociar
````
popupMenu = new JPopupMenu();
menuItemPopUno = new JMenuItem("Elemento 1");
menuItemPopDos = new JMenuItem("Elemento 2");
````
2. Organizar los elementos y personalizarlos
````
popupMenu.add(menuItemPopUno);
popupMenu.add(menuItemPopDos);
menuItemPopUno.setIcon(new ImageIcon(getClass().getResource("RUTA_DEL_RECURSO")));
menuItemPopUno.setMnemonic(KeyEvent.VK_E);
menuItemPopUno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.ALT_MASK));
````
3. Mostrar el menu contextual tras una accion
````
class ManejoPulsacion extends KeyAdapter{
         @Override
         public void keyPressed(KeyEvent e) {
             super.keyPressed(e);
             if (e.getKeyCode() == KeyEvent.VK_E){
                 popupMenu.show(texto,50,50);
             }
         }
     }

    class ManejoRaton extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getButton() == MouseEvent.BUTTON3){
                popupMenu.show(principal,e.getX(),e.getY());
            }
        }
    }
````
4. Darle la acción al elemento correspondiente para que se muestre el menú contextual en el
````
principal.addMouseListener(new ManejoRaton());
texto.addKeyListener(new ManejoPulsacion());
````

#### Toolbar
***

1. Crear un objeto de tipo JToolbar y los botones que se quieren poner dentro
````
toolBar = new JToolBar();
b1 = new JButton("Botón 1");
b2 = new JButton("Botón 2");
````
2. Personaliza la barra y situarla en una colocación del panel donde se mostrará 
````
toolBar.add(b1);
toolBar.add(b2);
principal.add(toolBar,BorderLayout.NORTH);
````
3. Personalizar la barra de tareas
````
toolBar.setRollover(true);
toolBar.setFloatable(true);
toolBar.setBorderPainted(true);
toolBar.setBorder(BorderFactory.createTitledBorder("Borde de la barra de herramientas"));
````

#### [Volver al índice](#tema2)
***

k. Diálogos

- http://www.developandsys.es/dialogos-construidos/
- http://www.developandsys.es/selector-de-archivo/
- http://www.developandsys.es/selector-de-color/

**Cuadro de diálogo de información**

````
JOptionPane.showMessageDialog(this, "Mensaje información", "titulo info", JOptionPane.INFORMATION_MESSAGE);
````

**Cuadro de diálogo de error**

````
JOptionPane.showMessageDialog(this, "Mensaje error", "titulo error", JOptionPane.ERROR_MESSAGE);
````

**Cuadro de diálogo de warning**

````
JOptionPane.showMessageDialog(this, "Mensaje error", "titulo error", JOptionPane.WARNING_MESSAGE);
````

**Cuadro de diálogo de entrada con botones**

````
int m = JOptionPane.showConfirmDialog(this, "Mensaje pregunta", "Titulo pregunta", JOptionPane.YES_NO_OPTION);
````

**Cuadro de diálogo de entrada con botones personalizados**

````
Object[] botones = {"Botón 1","Botón 2", "Botón 3"};
            int m = JOptionPane.showOptionDialog(this, "Mensaje pregunta", "Titulo pregunta", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,botones,botones[0]);
            System.out.println(m);
````

**Cuadro de diálogo de entrada con spinner**
````
String[] datos = {"Opcion 1", "Opcion 2", "Opcion 3"};
Object o = JOptionPane.showInputDialog(this, "Mensaje entrada sp",
                    "Titulo entrada sp", JOptionPane.QUESTION_MESSAGE, null, datos, datos[1]);
            if (o != null) {
                System.out.println(o.toString());
            } else System.out.println("No hay seleccion");
````
**Cuadro de diálogo de entrada de texto**
````
String introducido = JOptionPane.showInputDialog(this, "Mensaje entrada",
                    "Introduzca datos");
System.out.println(introducido);
````

**Cuadro de diálogo de ficheros**
````
JFileChooser fileChooser = new JFileChooser();
            int i = fileChooser.showDialog(this, "Aceptas");
            switch (i) {
                case JFileChooser.APPROVE_OPTION:
                    File f = fileChooser.getSelectedFile();
                    System.out.println(f.getName());
                    break;
                case JFileChooser.CANCEL_OPTION:
                    break;
}
````
**Cuadro de diálogo de color**
````
Color c = JColorChooser.showDialog(this, "Titulo color", Color.BLACK);
            System.out.println(c.toString());
            root.setBackground(c);
````

#### Cuadros de diálogo personalizados

1. Crear una clase que extienda de JDialog
````
public class DialogoPerso extends JDialog {

    Container container;

    public DialogoPerso() {

    }

}

````
2. Construir el elemento tal y como si fuera una ventana, utilizando métodos como setVisible(), pack(),etc..
````
public class DialogoPerso extends JDialog {

    Container container;

    public DialogoPerso() {

        instancias();
        setModal(true);
        setVisible(true);
        pack();

    }

    private void instancias() {
        container = getContentPane();
        container.add(new JLabel("Cuadro personalizado"));
    }
}
````

#### Comunicación entre elementos
***

**Diálogo - Frame**
Se realiza mediante el constructor en la llamada del diálogo, donde se pasa un objeto de tipo JFrame o aquel que se quiera utilizar en el diálogo para poder acceder a los elementos del mismo
````
DialogoGrafico d = new DialogoGrafico(labelPerso);
d.setVisible(true);
````
````
public class DialogoGrafico extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private VentanaDialogos v;
    private JLabel textField;

    public DialogoGrafico(, VentanaDialogos v, JLabel t) {
        this.v = v;
        this.textField = t;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);
        pack();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        textField.setText("contestacion");
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
````

**Frame - Diálogo**
Se realiza mediante el constructor al que se le pasan los datos que se quieran manejar
````
DialogoGrafico d = new DialogoGrafico("Titulo a pasar");
````
````
public class DialogoPerso extends JDialog {

    Container container;

    public DialogoPerso(String s) {

        setTituluo(s);
        instancias();
        setModal(true);
        setVisible(true);
        pack();

    }

    private void instancias() {
        container = getContentPane();
        container.add(new JLabel("Cuadro personalizado"));
    }
}
````
#### [Volver al índice](#tema2)
***