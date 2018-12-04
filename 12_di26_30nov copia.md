## TEMA 2 SWING

**Diálogos** 
***

### Cuadros de diálogo preconstruidos

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

## Cuadros de diálogo personalizados

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

## Comunicación 

### Diálogo - Frame
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

### Frame - Diálogo
Se realiza mediante el constructor al que se le pasan los datos que se quieran manejar
````
DialogoGrafico d = new DialogoGrafico("Titulo a pasar");
````
```
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



