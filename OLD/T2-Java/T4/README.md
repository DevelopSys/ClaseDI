<a name="tema5"></a>
## JavaFX			
####[Volver al índice](#tema5)
***
a. Fundamentos

- http://www.developandsys.es/fundamentos-javafx/

#### [Volver al índice](#tema5)
***

b. Manejo de eventos

- http://www.developandsys.es/manejo-de-eventos-en-javafx/

#### [Volver al índice](#tema5)
***
c. Layouts

- http://www.developandsys.es/layouts-javafx/

#### [Volver al índice](#tema5)
***

d. Botones, texto, radios, checks, etc…

- http://www.developandsys.es/botones-javafx/
- http://www.developandsys.es/javafx-texto//)

#### [Volver al índice](#tema5)
***

e. Listas

- http://www.developandsys.es/listas-javafx/

#### [Volver al índice](#tema5)
***

f. Tablas

- http://www.developandsys.es/tablas-javafx/?rs=tablas+javafx

#### [Volver al índice](#tema5)
***

g. CSS

- http://www.developandsys.es/css-en-javafx/

#### [Volver al índice](#tema5)
***

h. Comunicación JSON
- http://www.developandsys.es/rellenar-jlist-desde-json/#:~:text=JSON
#### [Volver al índice](#tema5)
***


Comunicación entre ventanas

Para poder comunica ventanas entre sí, es necesario el uso de las controladoras. La comunicación se puede dar en dos sentidos

- Sentido ventana --> ventana

En este caso la ventana origen debe ejecutar un método que está creado en la controladora de la ventana destino, pasando por parámetros todos aquellos datos que se quieran comunicar

```java
                    Stage ventanaDetalle = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("detail-view.fxml"));

                    Scene scene = null;
                    try {
                        Parent parent = fxmlLoader.load();
                        scene = new Scene(parent,400,400);
                        DetailController detailController = fxmlLoader.getController();
                        detailController.setearAlumno(tabla.getSelectionModel().getSelectedItem());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ventanaDetalle.setScene(scene);
                    ventanaDetalle.show();
```

Para ello es necesario cargar el fxml dentro de una variable, y acceder a la controladora. En este caso la controladora DetailController tendrá un método que permitirá pasar un alumno desde la Controladora desde la que se ejecuta el código mostrado. Una vez ejecutado este método se mostrará la ventana

```java
    public void setearAlumno (Alumno alumno){
        campoNombre.setText(alumno.getNombre());
        campoApellido.setText(alumno.getApellido());
        campoCorreo.setText(alumno.getCorreo());
        campoTelefono.setText(String.valueOf(alumno.getTelefono()));
    }

```

DetailController tiene ese método que recibe el parámetro y lo utiliza para poder colocarlo en aquellos elementos que le son necesarios

- Sentido ventana <--> ventana

Proceso muy parecido al anterior, con la diferencia que la controladora de la segunda ventana puede contestar. PAra ello en el primer proceso de comunicacion es necesario que la controladora original, además de ejecutar el método como en el paso anterior pase un objeto de la propia controladora

```java
                Stage ventanaAdd = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                        .getResource("add-view.fxml"));
                try {
                    Parent parent = fxmlLoader.load();
                    Scene escenaAdd = new Scene(parent,400,400);
                    ventanaAdd.setScene(escenaAdd);
                    ventanaAdd.show();

                    AddController controller = fxmlLoader.getController();
                    controller.setController(HelloController.this);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

```

De esta forma la controladora AddController tendrá una instancia del objeto

```java
public class AddController implements Initializable {

    private HelloController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            botonAgregar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    String nombre = campoNombre.getText();
                    String apellido = camporApellido.getText();
                    String correo = campoCorreo.getText();
                    int telefono = Integer.valueOf(campoTelefono.getText());

                    controller.agregarElementos(new Alumno(0,nombre,apellido,correo,telefono));
                    Stage ventanaActual = (Stage) botonAgregar.getScene().getWindow();
                    ventanaActual.close();
                }
            });
    }

    public void setController(HelloController controller){
        this.controller = controller;
    }
}
```

Como se puede ver este objeto lo utiliza para ejecutar un método que está creado en la controladora de la ventana origen, produciendo la comunicación bidireccional entre ambas ventanas

```java
public class HelloController implements Initializable {


    @FXML
    private TableView<Alumno> tabla;

    private ObservableList<Alumno> listaTabla;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void agregarElementos(Alumno alumno){
        alumno.setId(contador);
        listaTabla.add(alumno);
        contador++;
    }
}
```