## TEMA 2 SWING

**Menús** 
***

### Menús de barra

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

### Toolbar
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
