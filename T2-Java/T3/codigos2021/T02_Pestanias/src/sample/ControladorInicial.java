package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.utils.Persona;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class ControladorInicial implements Initializable {


    @FXML
    TabPane panelPestanias;

    @FXML
    RadioMenuItem menuActivar, menuDesactivar;

    @FXML
    MenuItem menuBotones, menuTextos, menuTablas, menuListas;
    @FXML
    Button botonImagen, botonCambio, botonCapturaTexto, botonListas, botonAgregarLista, botonDefectoLista, botonAgregarTabla, botonBorrarTabla, botonObtenerTabla, botonModificarTabla;

    @FXML
    Button dialogoWarning, dialogoFile, dialogoBuscador, dialogoError, dialogoConf, dialogoConfPerso, dialogoInfo, dialogoEleccion, dialogoEntrada;

    @FXML
    Button botonComunicar;

    @FXML
    TextField textoComunicar;

    @FXML
    ColorPicker dialogoColor;

    @FXML
    DatePicker dialogoFecha;

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
    ToggleGroup grupoRadios, grupoToggles, grupoOpciones;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        personalizarMenu();
        personalizarBotones();
        personalizarListas();
        personalizarTabla();
        personalizarFormulario();
        acciones();
    }

    private void personalizarMenu() {
        Image imagenOk = new Image(getClass().getResourceAsStream("resources/botones.png"));
        menuBotones.setGraphic(new ImageView(imagenOk));
        menuBotones.setAccelerator(KeyCombination.keyCombination("Ctrl+B"));
        menuTextos.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/textos.png"))));
        menuTextos.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        menuTablas.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/tablas.png"))));
        menuTablas.setAccelerator(KeyCombination.keyCombination("Ctrl+T"));
        menuListas.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/listas.png"))));
        menuListas.setAccelerator(KeyCombination.keyCombination("Ctrl+L"));
    }

    private void personalizarFormulario() {

        edadTabla.setItems(listaEdades);
        for (int i = 18; i < 100; i++) {
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
        grupoOpciones = new ToggleGroup();

        listaChoice = FXCollections.observableArrayList();
        listaCombo = FXCollections.observableArrayList();
        listaListView = FXCollections.observableArrayList();
        listaTabla = FXCollections.observableArrayList();
        listaEdades = FXCollections.observableArrayList();

        asociarDatos();
        grupoRadios.getToggles().addAll(radio1, radio2, radio3, radio4);
        grupoToggles.getToggles().addAll(toggle1, toggle2);
        grupoOpciones.getToggles().addAll(menuActivar, menuDesactivar);
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
        dialogoInfo.setOnAction(new ManejoPulsaciones());
        dialogoError.setOnAction(new ManejoPulsaciones());
        dialogoWarning.setOnAction(new ManejoPulsaciones());
        dialogoConf.setOnAction(new ManejoPulsaciones());
        dialogoConfPerso.setOnAction(new ManejoPulsaciones());
        dialogoEntrada.setOnAction(new ManejoPulsaciones());
        dialogoEleccion.setOnAction(new ManejoPulsaciones());
        dialogoFile.setOnAction(new ManejoPulsaciones());
        dialogoBuscador.setOnAction(new ManejoPulsaciones());
        dialogoColor.setOnAction(new ManejoPulsaciones());
        dialogoFecha.setOnAction(new ManejoPulsaciones());

        botonComunicar.setOnAction(new ManejoPulsaciones());

        menuBotones.setOnAction(new ManejoPulsaciones());
        menuListas.setOnAction(new ManejoPulsaciones());
        menuTablas.setOnAction(new ManejoPulsaciones());
        menuTextos.setOnAction(new ManejoPulsaciones());
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
                edadTabla.getSelectionModel().select(newValue.getEdad() - 18);
                // select(22)  -> 18+22
                nombreTabla.setText(newValue.getApellido());
                disponibilidadTabla.setSelected(newValue.isDisponibilidad());
            }
        });
        grupoOpciones.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (t1 == menuActivar) {
                    panelPestanias.setDisable(false);
                } else if (t1 == menuDesactivar) {
                    panelPestanias.setDisable(true);
                }
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

    public void terminarComunicacion(String texto){
        textoComunicar.setText(texto);
    }

    public void cerrarVentana(){
        botonComunicar.getScene().getWindow().hide();
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

                if (!nombreTabla.getText().equals("") && !apellidoTabla.getText().equals("")
                        && edadTabla.getSelectionModel().getSelectedIndex() != -1) {
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
            } else if (actionEvent.getSource() == botonObtenerTabla) {
                if (tabla.getSelectionModel().getSelectedIndex() != -1) {
                    /*PersonaTabla personaTabla = listaTabla.get(tabla.getSelectionModel().getSelectedIndex());
                    System.out.println(personaTabla.getNombre());*/

                    PersonaTabla personaTabla = tabla.getSelectionModel().getSelectedItem();
                    System.out.println(personaTabla.getNombre());
                }
            } else if (actionEvent.getSource() == botonModificarTabla) {
                PersonaTabla personaTabla = tabla.getSelectionModel().getSelectedItem();
                personaTabla.setDisponibilidad(disponibilidadTabla.isSelected());
                personaTabla.setApellido(apellidoTabla.getText());
                personaTabla.setNombre(nombreTabla.getText());
                personaTabla.setEdad((Integer) edadTabla.getSelectionModel().getSelectedItem());
                //personaTabla.setDisponibilidad(disponibilidadTabla.isSelected());
                //tabla.getSelectionModel().getSelectedItem().setDisponibilidad(!tabla.getSelectionModel().getSelectedItem().isDisponibilidad());
                tabla.refresh();

            } else if (actionEvent.getSource() == menuBotones) {
                //System.out.println("pulsado menu botones");
                panelPestanias.getSelectionModel().select(0);
            } else if (actionEvent.getSource() == menuListas) {
                //System.out.println("pulsado menu listas");
                panelPestanias.getSelectionModel().select(2);
            } else if (actionEvent.getSource() == menuTablas) {
                //System.out.println("pulsado menu tablas");
                panelPestanias.getSelectionModel().select(3);
            } else if (actionEvent.getSource() == menuTextos) {
                //System.out.println("pulsado menu textos");
                panelPestanias.getSelectionModel().select(1);
            } else if (actionEvent.getSource() == dialogoInfo) {
                Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                alertInfo.setTitle("Diálogo información");
                alertInfo.setHeaderText("Cabecera de información");
                alertInfo.setContentText("Cuerpo del cuadro de diálogo");
                alertInfo.show();
            } else if (actionEvent.getSource() == dialogoError) {
                Alert alertInfo = new Alert(Alert.AlertType.ERROR);
                alertInfo.setTitle("Diálogo información");
                alertInfo.setHeaderText("Cabecera de información");
                alertInfo.setContentText("Cuerpo del cuadro de diálogo");
                alertInfo.show();
            } else if (actionEvent.getSource() == dialogoWarning) {
                Alert alertInfo = new Alert(Alert.AlertType.WARNING);
                alertInfo.setTitle("Diálogo información");
                alertInfo.setHeaderText("Cabecera de información");
                alertInfo.setContentText("Cuerpo del cuadro de diálogo");
                alertInfo.show();
            } else if (actionEvent.getSource() == dialogoConf) {
                Alert alertConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
                alertConfirmacion.setTitle("Diálogo confirmación");
                alertConfirmacion.setHeaderText("Cabecera de confirmación");
                alertConfirmacion.setContentText("Cuerpo del cuadro de diálogo");
                Optional<ButtonType> seccion = alertConfirmacion.showAndWait();
                System.out.println(seccion);
                if (seccion.get() == ButtonType.OK) {
                    System.out.println("Seleccionado aceptar");
                } else if (seccion.get() == ButtonType.CANCEL) {
                    System.out.println("Seleccionado cancelar");
                }
            } else if (actionEvent.getSource() == dialogoConfPerso) {
                Alert confirmacionPerso = new Alert(Alert.AlertType.CONFIRMATION);
                confirmacionPerso.setTitle("Titulo");
                confirmacionPerso.setContentText("Contenido");
                confirmacionPerso.setHeaderText("Cabecera");
                ButtonType opcion1 = new ButtonType("Opcion1");
                ButtonType opcion2 = new ButtonType("Opcion2");
                ButtonType opcion3 = new ButtonType("Opcion3");
                ButtonType opcion4 = new ButtonType("Opcion4");
                confirmacionPerso.getButtonTypes()
                        .setAll(opcion1, opcion2, opcion3, opcion4, ButtonType.CANCEL);

                Optional<ButtonType> seleccion = confirmacionPerso.showAndWait();
                if (seleccion.get() == opcion1) {

                } else if (seleccion.get() == opcion2) {

                } else if (seleccion.get() == opcion3) {

                } else if (seleccion.get() == opcion4) {

                } else if (seleccion.get() == ButtonType.CANCEL) {

                }
            } else if (actionEvent.getSource() == dialogoEntrada) {

                boolean entrar = false;
                try {
                    do {
                        TextInputDialog dialogoEntrada = new TextInputDialog();
                        dialogoEntrada.setTitle("Titulo");
                        dialogoEntrada.setHeaderText("Cabecera");
                        dialogoEntrada.setContentText("Contenido");
                        Optional<String> texto = dialogoEntrada.showAndWait();

                        if (texto.get().equals("")) {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setContentText("Estás seguro???");
                            Optional<ButtonType> contestacion = alert.showAndWait();
                            if (contestacion.get() == ButtonType.CANCEL) {
                                entrar = true;
                            } else {
                                break;
                            }
                        } else {
                            System.out.println(texto.get());
                            break;
                        }

                    } while (entrar);

                } catch (NoSuchElementException e) {
                    System.out.println("No hay valor");
                }

            } else if (actionEvent.getSource() == dialogoEleccion) {

                ObservableList lista = FXCollections.observableArrayList();
                lista.addAll(new Persona("Borja", "Martin", 13),
                        new Persona("Pedro", "Martin", 13),
                        new Persona("Jose", "Martin", 23456789),
                        new Persona("Luis", "Martin", 13));

                ChoiceDialog<Persona> choiceDialog = new ChoiceDialog(lista.get(3), lista);
                choiceDialog.setContentText("Contenido");
                choiceDialog.setTitle("Titulo");
                choiceDialog.setHeaderText("Cabecera");
                Optional<Persona> seleccion = choiceDialog.showAndWait();
                System.out.println(seleccion.get().getTelefono());
            } else if (actionEvent.getSource() == dialogoFile) {


                TextInputDialog textInputDialog = new TextInputDialog("valor por defecto");
                Optional seleccion = textInputDialog.showAndWait();
                ObservableList lista = FXCollections.observableArrayList();
                lista.addAll(new Persona("Borja", "Martin", 13),
                        new Persona("Pedro", "Martin", 13),
                        new Persona("Jose", "Martin", 23456789),
                        new Persona("Luis", "Martin", 13));

                ChoiceDialog<Persona> dialogoChoice = new ChoiceDialog<>(lista.get(0), lista);
                Optional<Persona> seleccionPersona = dialogoChoice.showAndWait();

                FileChooser fileChooser = new FileChooser();
                //File file = fileChooser.showOpenDialog(dialogoFile.getScene().getWindow());
                File file = fileChooser.showSaveDialog(dialogoFile.getScene().getWindow());
                // System.out.println(file.getAbsolutePath());
                // File -- FileReader -- BufferedReader
                /*if (file.canRead()){
                    FileReader fileReader = null;
                    BufferedReader bufferedReader = null;

                    try {
                        fileReader = new FileReader(file);
                        bufferedReader = new BufferedReader(fileReader);
                        System.out.println(bufferedReader.readLine());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }*/
                // File -- FileWriter -- BufferedWriter

                if (file.getParentFile().canWrite()) {

                    FileWriter fileWriter = null;
                    BufferedWriter bufferedWriter = null;

                    try {
                        file.createNewFile();
                        fileWriter = new FileWriter(file);
                        bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(seleccion.get().toString());
                        bufferedWriter.newLine();
                        bufferedWriter.write(seleccionPersona.get().toString());
                        bufferedWriter.newLine();
                        bufferedWriter.write("asdasdasdasdasdasdasdasdasdasdasd");
                        bufferedWriter.close();
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("No hay permisos");
                }


            } else if (actionEvent.getSource() == dialogoBuscador) {

                FileChooser fileChooser = new FileChooser();
                File fichero = fileChooser.showOpenDialog(dialogoBuscador.getScene().getWindow());
                File[] listaFicheros = fichero.getParentFile().listFiles();
                for (File file : listaFicheros) {
                    System.out.println(file);
                    if (file.isDirectory()) {
                        listar(file);
                    }
                }
            } else if (actionEvent.getSource() == dialogoColor) {
                System.out.println(dialogoColor.getValue());
                Color color = dialogoColor.getValue();
                System.out.println("#" + color.toString().substring(2, color.toString().length() - 2));
            } else if (actionEvent.getSource() == dialogoFecha) {
                System.out.println(dialogoFecha.getValue());
                LocalDate localDate = dialogoFecha.getValue();
            } else if (actionEvent.getSource() == botonComunicar) {
                // Stage(ventana) -> Scene(Parent --> FXML + Controller) -> Nodes

                try {
                    //Parent root = FXMLLoader.load(getClass().getResource("ventana_adicional.fxml"));
                    // necesito la controladora del nuevo FXML
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ventana_adicional.fxml"));
                    Parent root = loader.load();
                    ControladorAdicional controladorAdicional = loader.getController();
                    //controladorAdicional.comunicarTexto(textoComunicar.getText());
                    controladorAdicional.comunicarTexto(new Persona("Borja","Apellido",123),
                            ControladorInicial.this);

                    Scene scene = new Scene(root,300,300);
                    Stage ventanaAdicional = new Stage();
                    ventanaAdicional.setScene(scene);
                    ventanaAdicional.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void listar(File directorio) {
        File[] listaFicheros = directorio.listFiles();
        for (File file : listaFicheros) {
            System.out.println(file);
        }
    }
}
