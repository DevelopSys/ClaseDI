package com.pestanias.pestanias;


import com.pestanias.pestanias.model.TipoPago;
import com.pestanias.pestanias.model.Usuario;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    // elementos gráficos
    @FXML
    private TabPane panelPestanias;
    @FXML
    private Button botonNormal, botonNormalDos;
    @FXML
    private ToggleButton botonToggle;
    @FXML
    private RadioButton radio1, radio2, radio3;
    @FXML
    private Label labelNombre, labelDesc, labelComision;
    @FXML
    private TextField textFiledUno, textFiledDos;
    @FXML
    private Button botonSuma, botonResta, botonDiv, botonMulti, botonIgual, botonMostrar, botonOcultar, botonComprobar;
    @FXML
    private GridPane gridBotones;
    @FXML
    private VBox panelMostrar;
    @FXML
    private BorderPane panelGeneral;
    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private ComboBox<Usuario> comboUsuarios;

    @FXML
    private Spinner<String> spinner;

    @FXML
    private ListView<String> list;

    // ArrayList

    private ObservableList<String> listaCombo, listaChoice, listaSpinner, listaListView;

    private ObservableList<Usuario> listaUsuarios;


    private int tipoOperacion = -1;
    private DropShadow sombraExterior;
    private ToggleGroup grupoRadios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        // se ejecuca cuando se asocia la parte grafica y la logica --> setContentView
        instancias();
        asociarDatos();
        configurarBotones();
        interpretarJSON();
        acciones();
    }

    private void interpretarJSON(){

        String urlString = "https://randomuser.me/api/?results=10";
        try {
            // 1- URL
            URL url = new URL(urlString);
            // 2- Crear la conexion
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            // 3- Interpretar los datos --> BufferReader
            BufferedReader lecturaURL =
                    new BufferedReader(new InputStreamReader(conexion.getInputStream()));

            String linea = null;
            String lecturaCompleta = "";

            while ((linea = lecturaURL.readLine())!= null){
                lecturaCompleta+=linea;
            }
            // System.out.println(lecturaCompleta);

            // 4- Pasar el string a JSON
            JSONObject objetoCompleto = new JSONObject(lecturaCompleta);
            JSONArray objetoInfo = objetoCompleto.getJSONArray("results");
            System.out.println(objetoInfo.getJSONObject(0).getString("gender"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void asociarDatos() {

        radio1.setUserData(new TipoPago("Tarjeta", "PAgo con trajeta bancaria", 0));
        radio2.setUserData(new TipoPago("Transferencia", "PAgo con transferecia bacanria", 10));
        radio3.setUserData(new TipoPago("PayPal", "PAgo con aplicacion paypal", 20));

        combo.setItems(listaCombo);
        choice.setItems(listaChoice);
        comboUsuarios.setItems(listaUsuarios);
        spinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(listaSpinner));
        list.setItems(listaListView);

    }

    private void configurarBotones() {
        // ImageView --> Image
        botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
        botonNormal.setBackground(null);

        botonNormalDos.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
        botonNormalDos.setBackground(null);

        botonToggle.setBackground(null);
        if (botonToggle.isSelected()) {
            botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchon.png"))));
        } else {
            botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
        }

    }

    private void instancias() {
        sombraExterior = new DropShadow();
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radio1, radio2, radio3);

        listaChoice = FXCollections.observableArrayList();
        listaChoice.addAll("OpcionCH 1","OpcionCH 2", "OpcionCH 3", "OpcionCH 4", "OpcionCH 5");
        listaCombo = FXCollections.observableArrayList();
        listaCombo.addAll("OpcionCB 1","OpcionCB 2", "OpcionCB 3", "OpcionCB 4", "OpcionCB 5");

        listaSpinner = FXCollections.observableArrayList();
        listaSpinner.addAll("OpcionSP 1","OpcionSP 2", "OpcionSP 3", "OpcionSP 4", "OpcionSP 5");

        listaUsuarios = FXCollections.observableArrayList();
        listaUsuarios.addAll(new Usuario(1,"usuario1","apellido1","correo1"),
                new Usuario(2,"usuario2","apellido2","correo2"),
                new Usuario(3,"usuario3","apellido3","correo3"),
                new Usuario(4,"usuario4","apellido4","correo4"));

        listaListView = FXCollections.observableArrayList();
        listaListView.addAll("Opcion 1","Opcion 2","Opcion 3","Opcion 4","Opcion 5","Opcion 6","Opcion 7","Opcion 8");

    }

    private void acciones() {
        botonComprobar.setOnAction(new ManejoPulsaciones());
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormalDos.setOnAction(new ManejoPulsaciones());
        botonMostrar.setOnAction(new ManejoPulsaciones());
        botonOcultar.setOnAction(new ManejoPulsaciones());
        for (Node child : gridBotones.getChildren()) {
            if (child instanceof Button) {
                ((Button) child).setOnAction(new ManejoPulsaciones());
            }
        }

        /*botonSuma.setOnAction(new ManejoPulsaciones());
        botonResta.setOnAction(new ManejoPulsaciones());
        botonMulti.setOnAction(new ManejoPulsaciones());
        botonDiv.setOnAction(new ManejoPulsaciones());
        botonIgual.setOnAction(new ManejoPulsaciones());*/

        // radio1.setOnAction(new ManejoPulsaciones());
        // botonToggle.setOnAction(new ManejoPulsaciones());
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                RadioButton radioButton = (RadioButton) newValue;
                TipoPago tipoPago = (TipoPago) radioButton.getUserData();
                labelNombre.setText(tipoPago.getNombre());
                labelDesc.setText(tipoPago.getDescripcion());
                labelComision.setText(String.valueOf(tipoPago.getComision()));
            }
        });
        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_CLICKED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_PRESSED, new ManejoRaton());
        botonToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean oldValue, Boolean newValue) {
                botonNormal.setDisable(newValue);
                botonNormalDos.setDisable(newValue);
                if (newValue) {
                    botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchon.png"))));
                } else {
                    botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
                }
            }
        });
        textFiledUno.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                char letraPulsada = keyEvent.getCharacter().charAt(0);
                System.out.println(Character.isDigit(letraPulsada));
            }
        });
        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println("El valor cambiado del combo es "+t1);
            }
        });
        choice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println("La seleccion del choice es "+t1);
            }
        });

        comboUsuarios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Usuario>() {
            @Override
            public void changed(ObservableValue<? extends Usuario> observableValue, Usuario usuario, Usuario t1) {
                System.out.println("Datos del usuario");
                System.out.println("\t nombre: "+t1.getNombre());
                System.out.println("\t nombre: "+t1.getApellido());
                System.out.println("\t nombre: "+t1.getCorreo());
            }
        });
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println("Cambio en la lista, valor nuevo "+t1);
            }
        });
        //botonNormal.addEventHandler(MouseEvent.MOUSE_RELEASED, new ManejoRaton());
    }

    class ManejoRaton implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {

            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                if (mouseEvent.getSource() == botonNormal) {
                    botonNormal.setEffect(sombraExterior);
                } else if (mouseEvent.getSource() == botonNormalDos) {
                    botonNormalDos.setEffect(sombraExterior);
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                if (mouseEvent.getSource() == botonNormal) {
                    botonNormal.setEffect(null);
                } else if (mouseEvent.getSource() == botonNormalDos) {
                    botonNormalDos.setEffect(null);
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                //System.out.println("Raton pressed");
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
                System.out.println("Raton clicked");
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
                System.out.println("Raton released");
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {


        @Override
        public void handle(ActionEvent actionEvent) {
            //System.out.println("Boton pulsado");
            if (actionEvent.getSource() == botonNormal) {
                botonToggle.setSelected(true);
                System.out.println(textFiledUno.getText());
            } else if (actionEvent.getSource() == botonNormalDos) {
                RadioButton radioSeleccionado = (RadioButton) grupoRadios.getSelectedToggle();
                TipoPago tipoPago = (TipoPago) radioSeleccionado.getUserData();
                System.out.println(tipoPago.getComision());
                System.out.println(tipoPago.getNombre());
                System.out.println(tipoPago.getDescripcion());
            } else if (actionEvent.getSource() == botonSuma) {
                tipoOperacion = 0;
                /*if (Character.isDigit(textFiledUno.getText().charAt(0)) && Character.isDigit(textFiledDos.getText().charAt(0))){
                    int suma = Integer.parseInt(String.valueOf(textFiledUno.getText().charAt(0))) + Integer.parseInt(String.valueOf(textFiledDos.getText().charAt(0)));
                    System.out.println("La suma de los valores es "+suma);
                } else {
                    System.out.println("Alguno de los elementos no es numero");
                }*/

            } else if (actionEvent.getSource() == botonResta) {
                tipoOperacion = 1;
            } else if (actionEvent.getSource() == botonMulti) {
                tipoOperacion = 2;
            } else if (actionEvent.getSource() == botonDiv) {
                tipoOperacion = 3;
            }
            else if (actionEvent.getSource() == botonIgual) {
                int op1 = Integer.parseInt(String.valueOf(textFiledUno.getText().charAt(0)));
                int op2 = Integer.parseInt(String.valueOf(textFiledDos.getText().charAt(0)));
                double resultado = 0.0;
                switch (tipoOperacion) {
                    case 0:
                        resultado = op1 + op2;
                        break;
                    case 1:
                        resultado = op1 - op2;
                        break;
                    case 2:
                        resultado = op1 * op2;
                        break;
                    case 3:
                        resultado = (double) op1 / op2;
                        break;
                }
                System.out.printf("El resutaldo de la operacion es %.2f", resultado);
            }
            else if (actionEvent.getSource() == botonMostrar) {

                //panelMostrar.setVisible(true);
                panelGeneral.setRight(panelMostrar);
            }
            else if (actionEvent.getSource() == botonOcultar) {
                // VBOX --
                //panelMostrar.setVisible(false);
                panelGeneral.getChildren().remove(panelMostrar);
            }
            else if (actionEvent.getSource() == botonComprobar) {
                // seleccion de una lista

                String seleccionLista = list.getSelectionModel().getSelectedItem();
                String seleccionCombo = combo.getSelectionModel().getSelectedItem();
                String seleccionChoice = choice.getSelectionModel().getSelectedItem();
                System.out.println(choice.getSelectionModel().getSelectedIndex());
                System.out.println(seleccionLista);
                String seleccionSpinner = spinner.getValue();

                System.out.println(combo.getSelectionModel().getSelectedIndex());

                System.out.println(seleccionSpinner);

                //combo.getSelectionModel().selectNext();
                //choice.getSelectionModel().selectNext();

                if (combo.getSelectionModel().getSelectedIndex() >-1 && choice.getSelectionModel().getSelectedIndex()>-1){
                    System.out.printf("Seleccion de combo %s%n",seleccionCombo);
                    System.out.printf("Seleccion de choice %s%n",seleccionChoice);

                } else {
                    System.out.println("Uno de los dos elementos no tiene seleccion");
                }

                // APAREZCA POR CONSOLA EL ELEMENTO SELECCIONADO EN EL MOMENTO EN EL QUE
                // HAY UN CAMBIO


                // CREAR UNA CLASE USUARIO CON NOMBRE, APELLIDO, ID, CORREO
                // EN EL COMBO METER 5 USUARIOS CON LOS DATOS QUE QUERAIS
                // EN EL COMBO APARECERÁ EL NOMBRE DEL USUARIO
                // CUANDO SE DETECTE UN CAMBIO DE SELECCION APARECERA EN CONSOLA
                    // Nombre: XXXX
                    // Apelllido: XXXX
                    // Correo: XXXX
                    // Id: XXXX



            }
        }
    }
}

/*
 * 1- CAMBIAR LA IMAGEN DEL TOGGLE PARA QUE PONGA EL ON Y EL OFF
 * 2- AL CAMBIAR LA SELECCIÓN DEL TOGGLE GROUP APARECE LA INFORMACION EN 3 LABEL
 * 3- AL PULSAR EL BOTON DE OFF APARECE POR CONSOLA LA INFORMACION DEL
 * TOGGLE SELECCIONADO
 * */
