package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import sample.utils.Persona;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class ControladorInicial implements Initializable {

    @FXML
    Button botonImagen, botonCambio, botonCapturaTexto, botonListas, botonAgregarLista, botonDefectoLista, botonAgregarTabla, botonBorrarTabla, botonObtenerTabla, botonModificarTabla;
    @FXML
    RadioButton radio1, radio2, radio3, radio4;
    @FXML
    ToggleButton toggle1, toggle2;
    @FXML
    TextField textoNormal, textoFiltrar, nombreTabla, apellidoTabla;
    @FXML
    TextArea textoArea;
    @FXML
    PasswordField textoPass;
    @FXML
    CheckBox check1, disponibilidadTabla;
    @FXML
    ComboBox combo, edadTabla;
    @FXML
    ChoiceBox choice;
    @FXML
    ListView listView;

    @FXML
    TableColumn columnaNombre, columnaApellido, columnaEdad, columnaDisponibilidad;

    @FXML
    TableView<PersonaTabla> tabla;

    ObservableList<Persona> listaChoice;
    ObservableList<Persona> listaCombo;
    ObservableList<Persona> listaListView;
    ObservableList listaEdades;

    ObservableList<PersonaTabla> listaTabla;
    FilteredList<PersonaTabla> listaFiltrada;


    DropShadow sombraExterior;
    ToggleGroup grupoRadios, grupoToggles;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarBotones();
        personalizarListas();
        personalizarTabla();
        personalizarFormulario();
        acciones();
    }

    private void personalizarFormulario() {

        edadTabla.setItems(listaEdades);
        for(int i=18;i<100;i++){
            listaEdades.add(i);
        }

    }

    private void personalizarTabla() {
        columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        columnaEdad.setCellValueFactory(new PropertyValueFactory("edad"));
        columnaDisponibilidad.setCellValueFactory(new PropertyValueFactory("disponibilidad"));

        listaTabla.addAll(new PersonaTabla("eds", "uytfcv", 123, false));
        listaTabla.addAll(new PersonaTabla("fgdfv", "fsdfsd", 432, true));
        listaTabla.addAll(new PersonaTabla("yrte", "ertert", 645, true));
        listaTabla.addAll(new PersonaTabla("asd", "gdfgdf", 645, false));
        listaTabla.addAll(new PersonaTabla("bnm", "ert", 645, false));
        listaTabla.addAll(new PersonaTabla("cvb", "gdfgd", 645, true));
        listaTabla.addAll(new PersonaTabla("dfg", "cvbcvb", 645, false));
        listaTabla.addAll(new PersonaTabla("ert", "hytrf", 645, false));
        listaTabla.addAll(new PersonaTabla("yrte", "asdfg", 645, true));

        //tabla.setItems(listaTabla);

        listaFiltrada = new FilteredList(listaTabla);
        tabla.setItems(listaFiltrada);


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
        listaEdades = FXCollections.observableArrayList();

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
        botonAgregarTabla.setOnAction(new ManejoPulsaciones());
        botonBorrarTabla.setOnAction(new ManejoPulsaciones());
        botonObtenerTabla.setOnAction(new ManejoPulsaciones());
        botonModificarTabla.setOnAction(new ManejoPulsaciones());
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
        textoFiltrar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println(t1);
                //e y --> {e,y}
                String[] palabras = t1.split(" ");
                //System.out.println(palabras.length);

                listaFiltrada.setPredicate(new Predicate<PersonaTabla>() {
                    @Override
                    public boolean test(PersonaTabla persona) {
                        return (persona.getNombre().contains(t1));
                    }
                });
            }
        });
        tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PersonaTabla>() {
            @Override
            public void changed(ObservableValue<? extends PersonaTabla> observableValue, PersonaTabla oldValue, PersonaTabla newValue) {
                //System.out.println("Cambio en la seleccion de la tabla");
                //System.out.println(newValue.isDisponibilidad());
                nombreTabla.setText(newValue.getNombre());
                apellidoTabla.setText(newValue.getApellido());
                edadTabla.getSelectionModel().select(newValue.getEdad()-18);
                // select(22)  -> 18+22
                nombreTabla.setText(newValue.getApellido());
                disponibilidadTabla.setSelected(newValue.isDisponibilidad());
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
            } else if (actionEvent.getSource() == botonAgregarLista) {
                listaCombo.add(new Persona("Nueva", "Nueva", 1234));
                listaChoice.add(new Persona("Nueva", "Nueva", 1234));
                listaListView.add(new Persona("Nueva", "Nueva", 1234));
            } else if (actionEvent.getSource() == botonDefectoLista) {
                combo.getSelectionModel().select(0);
                choice.getSelectionModel().select(0);
                listView.getSelectionModel().select(0);
            } else if (actionEvent.getSource() == botonAgregarTabla) {
                //PersonaTabla personaTabla = new PersonaTabla("PersonaNueva", "ApellidoNuevo", 23, false);

                if(!nombreTabla.getText().equals("") && !apellidoTabla.getText().equals("")
                        && edadTabla.getSelectionModel().getSelectedIndex()!= -1 ) {
                    PersonaTabla personaTabla = new PersonaTabla(nombreTabla.getText(), apellidoTabla.getText(),
                            (int) edadTabla.getSelectionModel().getSelectedItem(), disponibilidadTabla.isSelected());
                    listaTabla.add(personaTabla);
                }
            } else if (actionEvent.getSource() == botonBorrarTabla) {

                if (listaTabla.size() != 0) {
                    if (tabla.getSelectionModel().getSelectedItem() != null) {
                        listaTabla.remove(tabla.getSelectionModel().getSelectedItem());
                    } else {
                        System.out.println("Por favor selecciona algo");
                    }
                } else {
                    System.out.println("Tabla vacía");
                }
            } else if (actionEvent.getSource() == botonObtenerTabla){
                if (tabla.getSelectionModel().getSelectedIndex() != -1){
                    /*PersonaTabla personaTabla = listaTabla.get(tabla.getSelectionModel().getSelectedIndex());
                    System.out.println(personaTabla.getNombre());*/

                    PersonaTabla personaTabla = tabla.getSelectionModel().getSelectedItem();
                    System.out.println(personaTabla.getNombre());
                }
            } else if (actionEvent.getSource() == botonModificarTabla){
                PersonaTabla personaTabla = tabla.getSelectionModel().getSelectedItem();
                personaTabla.setDisponibilidad(disponibilidadTabla.isSelected());
                personaTabla.setApellido(apellidoTabla.getText());
                personaTabla.setNombre(nombreTabla.getText());
                personaTabla.setEdad((Integer) edadTabla.getSelectionModel().getSelectedItem());
                //personaTabla.setDisponibilidad(disponibilidadTabla.isSelected());
                //tabla.getSelectionModel().getSelectedItem().setDisponibilidad(!tabla.getSelectionModel().getSelectedItem().isDisponibilidad());
                tabla.refresh();

            }
        }
    }
}
