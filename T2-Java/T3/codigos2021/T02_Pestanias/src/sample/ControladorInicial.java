package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import sample.utils.Persona;
import sample.utils.PersonaTabla;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorInicial implements Initializable {

    @FXML
    Button botonImagen, botonCambio, botonCapturaTexto, botonListas, botonAgregarLista, botonDefectoLista, botonAgregarTabla, botonBorrarTabla, botonObtenerTabla;
    @FXML
    RadioButton radio1, radio2, radio3, radio4;
    @FXML
    ToggleButton toggle1, toggle2;
    @FXML
    TextField textoNormal, textoFiltrar;
    @FXML
    TextArea textoArea;
    @FXML
    PasswordField textoPass;
    @FXML
    CheckBox check1;
    @FXML
    ComboBox combo;
    @FXML
    ChoiceBox choice;
    @FXML
    ListView listView;

    @FXML TableColumn columnaNombre, columnaApellido, columnaEdad, columnaDisponibilidad;

    @FXML TableView tabla;

    ObservableList<Persona> listaChoice;
    ObservableList<Persona> listaCombo;
    ObservableList<Persona> listaListView;
    ObservableList listaTabla;


    DropShadow sombraExterior;
    ToggleGroup grupoRadios, grupoToggles;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarBotones();
        personalizarListas();
        personalizarTabla();
        acciones();
    }

    private void personalizarTabla() {
            tabla.setItems(listaTabla);
            listaTabla.addAll(new PersonaTabla("nombre","apellido",123,false));
            listaTabla.addAll(new PersonaTabla("nombre","apellido",123,false));
            listaTabla.addAll(new PersonaTabla("nombre","apellido",123,false));
    }

    private void personalizarListas() {
        choice.setItems(listaChoice);
        listaChoice.addAll(new Persona("Borja", "Martin", 1234),
                new Persona("Luis", "Diego", 23456), new Persona("Luis", "Diego", 23456)
                , new Persona("Luis", "Diego", 23456), new Persona("Luis", "Diego", 23456), new Persona("Luis", "Diego", 23456), new Persona("Luis", "Diego", 23456), new Persona("Luis", "Diego", 23456));


        combo.setItems(listaCombo);
        listaCombo.addAll(new Persona("Borja", "Martin", 1234),
                new Persona("Luis", "Diego", 23456));

        listView.setItems(listaListView);
        listaListView.addAll(new Persona("Borja", "Martin", 1234),
                new Persona("Luis", "Diego", 23456));
    }

    private void instancias() {
        sombraExterior = new DropShadow();
        grupoRadios = new ToggleGroup();
        grupoToggles = new ToggleGroup();

        listaChoice = FXCollections.observableArrayList();
        listaCombo = FXCollections.observableArrayList();
        listaListView = FXCollections.observableArrayList();
        listaTabla = FXCollections.observableArrayList();

        asociarDatos();
        grupoRadios.getToggles().addAll(radio1, radio2, radio3, radio4);
        grupoToggles.getToggles().addAll(toggle1, toggle2);
    }

    private void asociarDatos() {
        radio1.setUserData(new Persona("Borja", "Martin", 123213));
        radio2.setUserData(new Persona("Jose", "Martin", 123213));
        radio3.setUserData(new Persona("Roberto", "Martin", 123213));
        radio4.setUserData(new Persona("David", "Martin", 123213));
    }

    private void acciones() {

        botonImagen.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonImagen.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonCambio.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonCambio.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonImagen.setOnAction(new ManejoPulsaciones());
        botonListas.setOnAction(new ManejoPulsaciones());
        botonAgregarLista.setOnAction(new ManejoPulsaciones());
        botonDefectoLista.setOnAction(new ManejoPulsaciones());
        botonCapturaTexto.setOnAction(new ManejoPulsaciones());
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                /*System.out.println("cambio");
                System.out.println(oldValue);
                System.out.println(newValue);*/
                Persona personaRecuerada = (Persona) newValue.getUserData();
                System.out.println(personaRecuerada.getNombre());
            }
        });
        grupoToggles.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("cambio");
            }
        });
        check1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                //System.out.println(t1);
                botonImagen.setDisable(t1);
            }
        });
        textoNormal.addEventHandler(KeyEvent.KEY_TYPED, new ManejoTeclas());
        /*combo.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println(listaCombo.get(t1.intValue()));
            }
        });*/
        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Persona>() {
            @Override
            public void changed(ObservableValue observableValue, Persona o, Persona t1) {
                System.out.println(t1.getNombre());
            }
        });

    }

    private void personalizarBotones() {

        Image imagenOk = new Image(getClass().getResourceAsStream("resources/button_on.png"));
        botonImagen.setGraphic(new ImageView(imagenOk));
        botonImagen.setBackground(null);
        botonCambio.setGraphic(new ImageView
                (new Image(getClass().getResourceAsStream("resources/button_ok.png"))));
        botonCambio.setText("");
        botonCambio.setBackground(null);
        //botonImagen.setEffect(sombraExterior);
    }

    class ManejoTeclas implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent keyEvent) {

        }
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {

            // quien ha generado
            // que ha generado
            if (event.getSource() == botonImagen) {
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    botonImagen.setEffect(sombraExterior);
                } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                    botonImagen.setEffect(null);
                }
            } else if (event.getSource() == botonCambio) {
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    botonCambio.setGraphic(new ImageView
                            (new Image(getClass().getResourceAsStream("resources/button_cancel.png"))));
                    botonCambio.setEffect(sombraExterior);
                } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                    botonCambio.setGraphic(new ImageView
                            (new Image(getClass().getResourceAsStream("resources/button_ok.png"))));
                    botonCambio.setEffect(null);
                }
            }

            // que evento ha generado
            // quien lo ha hecho

        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonImagen) {
                System.out.println(grupoRadios.getSelectedToggle());
            } else if (actionEvent.getSource() == botonCapturaTexto) {
                /*System.out.println(textoNormal.getText());
                System.out.println(textoArea.getText());
                System.out.println(textoPass.getText());*/
                textoNormal.appendText("s");
                String numero = textoNormal.getText();
                numero = numero.substring(0, numero.length() - 1);
                textoNormal.setText(numero);
                String palabra = "sdfghjklñ";
                // substring 0,5 --> sdfghj
            } else if (actionEvent.getSource() == botonListas) {

                if (choice.getSelectionModel().getSelectedIndex() != -1
                        && combo.getSelectionModel().getSelectedIndex() != -1
                        && listView.getSelectionModel().getSelectedIndex() != -1) {
                    Persona personaChoice = listaChoice.get(choice.getSelectionModel().getSelectedIndex());
                    Persona personaCombo = listaCombo.get(combo.getSelectionModel().getSelectedIndex());
                    Persona personaList = listaListView.get(listView.getSelectionModel().getSelectedIndex());
                    System.out.println("La persona del choice es: " + personaChoice);
                    System.out.println("La persona del combo es: " + personaCombo);
                    System.out.println("La persona del listView es: " + personaList);
                }
            } else if(actionEvent.getSource() == botonAgregarLista){
                listaCombo.add(new Persona("Nueva","Nueva",1234));
                listaChoice.add(new Persona("Nueva","Nueva",1234));
                listaListView.add(new Persona("Nueva","Nueva",1234));
            } else if (actionEvent.getSource() == botonDefectoLista){
                combo.getSelectionModel().select(0);
                choice.getSelectionModel().select(0);
                listView.getSelectionModel().select(0);
            }
        }
    }
}
