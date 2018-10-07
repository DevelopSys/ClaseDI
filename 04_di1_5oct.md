# Cuarta semana

## TEMA 2 SWING


### LUNES https://github.com/DevelopSys/cursorepaso/tree/master/src/examen http://www.developandsys.es/elementos-graficos-frame/

Corrección del examen y repaso general

1. Arrancar una interfaz gráfica
````
SwingUtilities.invokeLater(new Runnable() {  
    @Override  
  public void run() {  
        VentanaEventos v = new VentanaEventos();  
  }  
});
````
2. Mostrar un JFrame con tamaño mínimo
````
pack();
````
3. Hacer visible un JFrame con estado maímizado
````
setVisible(true);
````
4. Hacer "cerrarble" un JFrame
````
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
````
5. Agregar elementos a un JFrame
````
this.getContentPane().add(configurarAbajo(),BorderLayout.SOUTH);
````
6. Arrancar la ventana maximizada
````
setExtendedState(MAXIMIZED_BOTH);
````

### MIÉRCOLES - http://www.developandsys.es/layouts-swing/
**GridLayout**
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

**FlowLayout**
****
Layout que reparte el espacio entre los elementos que están agregados al contenedor donde está configurado. Este tipo de layout es el que tiene por defecto un JPanel

1. Setear un panel con FlowLayout 
````
pIzquierda.setLayout(new FlowLayout());  
````
2. Modificar características del layout
````
((FlowLayout)pIzquierda.getLayout()).setAlignment(FlowLayout.CENTER);  
((FlowLayout)pIzquierda.getLayout()).setHgap(20);  
((FlowLayout)pIzquierda.getLayout()).setVgap(20);
````
3. Agregar elementos al panel
````
pIzquierda.add(b1);  
pIzquierda.add(b2);  
pIzquierda.add(b3);  
pIzquierda.add(b4);
````

### JUEVES -http://www.developandsys.es/layouts-swing/

**BorderLayout**
****
Layout basado en la colocación de los elementos en puntos cardinales. Este layout es el asignado por defecto a los elementos JFrame y JDialog

1. Setear un panel con FlowLayout 
````
container.setLayout(new BorderLayout());  
````
2. Agregar elementos al panel
````
container.add(pCentro,BorderLayout.CENTER);  
container.add(pNorte,BorderLayout.NORTH);  
container.add(pEste,BorderLayout.EAST);  
container.add(pOeste,BorderLayout.WEST);  
container.add(pSur,BorderLayout.SOUTH);
````
 
### VIERNES - http://www.developandsys.es/layouts-swing/

** CardLayout** 
****
Layout basado en una pila de componentes donde solo uno es mostrado, pudiendo cambiarse entre ellos
1. Setear un panel con CardLayout 
````
cardLayout = new CardLayout();
pCentral.setLayout(cardLayout);
````
2. Agregar elementos al panel
````
pCentral.add(pUno,"panel1");  
pCentral.add(pDos,"panel2");  
pCentral.add(pTres,"panel3");  
pCentral.add(pCuatro,"panel4");
````
3. Mostrar un elemento en concreto
````
cardLayout.show(pCentral,"panel4");
````