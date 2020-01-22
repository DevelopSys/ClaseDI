package controladoras;

import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utils.Persona;
import ventanas.VentanaDos;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class ControladoraVentanaUno implements Initializable {

    DropShadow sombra = new DropShadow();

    @FXML
    Button btnNormal, btnImagen, botonPantalla, botonSeleccion, bDialogoInfo,
            bDialogoConfirmacion, bDialogoInput, bDialogoBotones, bDialogoChoice,
            bDialogoPerso;

    @FXML
    Tab tabBotones, tabTextos;

    @FXML
    CheckBox check;

    @FXML
    RadioButton radioUno, radioDos, radioTres;

    @FXML
    JFXTextField textoMaterial;

    @FXML
    TextArea textoArea;

    @FXML
    ComboBox combo;

    @FXML
    ChoiceBox choice;

    @FXML
    ListView lista;

    @FXML
    TableView tabla;

    @FXML
    TableColumn columnaNombre, columnaApellido, columnaEdad, columnaDisponibilidad;

    @FXML TextField textoBuscar;


    ToggleGroup grupoRadios;
    FilteredList<Persona> listaFiltradas;
    


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //textoArea.setWrapText(true);


        instancias();
        personalizarBoton();
        personalizarCombo();
        personalizarLista();
        personalizarTabla();
        acciones();
    }

    private void personalizarTabla() {
        columnaNombre.setCellValueFactory(new PropertyValueFactory("propNombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory("propApellido"));
        columnaEdad.setCellValueFactory(new PropertyValueFactory("propEdad"));
        columnaDisponibilidad.setCellValueFactory(new PropertyValueFactory("propDisponibilidad"));

        ObservableList<Persona> listaTabla = FXCollections.observableArrayList();
        listaTabla.addAll(
                new Persona("sdf","Apellido1",123,false),
                new Persona("jghf","Apellido2",4234,true),
                new Persona("bvncb","Apellido3",45,true),
                new Persona("pioñjkl","Apellido$",9786,false));

        listaFiltradas = new FilteredList(listaTabla);
        tabla.setItems(listaFiltradas);
    }

    private void personalizarLista() {
        ObservableList listaElementos = FXCollections.observableArrayList();
        listaElementos.addAll(new Persona("Nombre", "Apellido"),
                new Persona("Nombre1", "Apellido1"),
                new Persona("Nombre2", "Apellido1"),
                new Persona("Nombre3", "Apellido1"),
                new Persona("Nombre4", "Apellido1"),
                new Persona("Nombre5", "Apellido1"));
        lista.setItems(listaElementos);
    }

    private void personalizarCombo() {
        combo.setPromptText("Selecciona un valor");
        combo.setVisibleRowCount(3);
        ObservableList itemCombo = FXCollections.observableArrayList();
        itemCombo.add(1);
        itemCombo.add(2);
        itemCombo.add(3);
        itemCombo.add(4);

        ObservableList itemChoice = FXCollections.observableArrayList();
        itemChoice.add(1);
        itemChoice.add(2);
        itemChoice.add(3);
        itemChoice.add(4);

        combo.setItems(itemCombo);
        choice.setItems(itemChoice);
    }

    private void instancias() {
        grupoRadios = new ToggleGroup();
        radioUno.setUserData(new Persona("Borja", "casado"));
        radioDos.setUserData(new Persona("Jose", "soltero"));
        radioTres.setUserData(new Persona("Luis", "casado"));
        grupoRadios.getToggles().addAll(radioUno, radioDos, radioTres);
    }

    private void personalizarBoton() {

        btnImagen.setBackground(null);
        btnImagen.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("../resources/button_ok.png"))));
    }

    private void acciones() {


        /*textoBuscar.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.print(event.getText());
            }
        });*/

        textoBuscar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                //System.out.print(newValue);
                listaFiltradas.setPredicate(new Predicate<Persona>() {
                    @Override
                    public boolean test(Persona persona) {
                        return persona.getNombre().contains(newValue);
                    }
                });
            }
        });


        botonSeleccion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Persona p = (Persona) lista.getSelectionModel()
                        .getSelectedItem();
                System.out.println(p.getEstado());
            }
        });
        botonPantalla.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaDos ventanaDos = new VentanaDos(textoMaterial.getText());
            }
        });
        btnNormal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(check.isSelected());
                //grupoRadios.getSelectedToggle();
            }
        });
        btnNormal.setOnMouseEntered(new ManejoRaton());
        btnNormal.setOnMouseExited(new ManejoRaton());
        btnImagen.setOnMousePressed(new ManejoRaton());
        btnImagen.setOnMouseReleased(new ManejoRaton());
        bDialogoInfo.setOnAction(new ManejoPulsaciones());
        bDialogoConfirmacion.setOnAction(new ManejoPulsaciones());
        bDialogoBotones.setOnAction(new ManejoPulsaciones());
        bDialogoInput.setOnAction(new ManejoPulsaciones());
        bDialogoChoice.setOnAction(new ManejoPulsaciones());
        bDialogoPerso.setOnAction(new ManejoPulsaciones());


        check.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    btnNormal.setDisable(true);
                } else {
                    btnNormal.setDisable(false);
                }
            }
        });
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                Persona seleccionado = (Persona) newValue.getUserData();
                System.out.println(seleccionado.getEstado()
                );
            }
        });
        lista.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Persona p = (Persona) newValue;
                System.out.println(p.getEstado());
            }
        });
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            if (event.getSource() == btnNormal) {
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    btnNormal.setEffect(sombra);
                } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                    btnNormal.setEffect(null);
                }
            } else if (event.getSource() == btnImagen) {
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    btnImagen.setEffect(sombra);
                } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                    System.out.println("soltado");
                    btnImagen.setEffect(null);
                }
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == bDialogoInfo) {
                Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
                dialogoInfo.setTitle("Título info");
                dialogoInfo.setHeaderText("Header info");
                dialogoInfo.setContentText("Contenido del diálogo de información");
                dialogoInfo.show();

            } else if (event.getSource() == bDialogoConfirmacion) {

                Alert dialogoConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoConfirmacion.setTitle("Título confirmacion");
                dialogoConfirmacion.setHeaderText("Header confirmacion");
                dialogoConfirmacion.setContentText("Contenido del diálogo de confirmacion");
                Optional<ButtonType> resultado = dialogoConfirmacion.showAndWait();

                if (resultado.get() == ButtonType.OK) {
                    System.out.println("pulsado ok");
                } else if (resultado.get() == ButtonType.CANCEL) {
                    System.out.println("pulsado cancelar");
                }


            } else if (event.getSource() == bDialogoBotones) {

                ButtonType b1 = new ButtonType("ejemplo1");
                ButtonType b2 = new ButtonType("ejemplo2");
                ButtonType b3 = new ButtonType("ejemplo3");

                Alert dialogoBotones = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoBotones.setTitle("Título confirmacion");
                dialogoBotones.setHeaderText("Header confirmacion");
                dialogoBotones.setContentText("Contenido del diálogo de confirmacion");
                dialogoBotones.getButtonTypes().setAll(b1, b2, b3);
                Optional<ButtonType> resultado = dialogoBotones.showAndWait();

                if (resultado.get() == b1) {
                    System.out.println("pulsado ok");
                }

            } else if (event.getSource() == bDialogoInput) {

                TextInputDialog dialogoInput = new TextInputDialog("texto por defecto");
                dialogoInput.setHeaderText("Cabecera input");
                dialogoInput.setTitle("Titulo input");
                dialogoInput.setContentText("Introduce nombre");
                Optional<String> respuesta = dialogoInput.showAndWait();
                if (respuesta.isPresent()) {
                    System.out.println(respuesta.get());
                } else {
                    System.out.println("no ha contestado");
                }


            } else if (event.getSource() == bDialogoChoice) {

                List listaOpciones = new ArrayList();
                listaOpciones.add(new Persona("nombre1", "asdasd"));
                listaOpciones.add(new Persona("nombre2", "asdasd"));
                listaOpciones.add(new Persona("nombre3", "asdasd"));
                listaOpciones.add(new Persona("nombre4", "asdasd"));
                ChoiceDialog<Persona> dialogoChoice = new ChoiceDialog(listaOpciones.get(0), listaOpciones);
                dialogoChoice.setTitle("titulo");
                dialogoChoice.setContentText("selecciona una opcion");
                dialogoChoice.setHeaderText("header");
                Optional<Persona> resultado = dialogoChoice.showAndWait();
                if (resultado.isPresent()) {
                    System.out.println(resultado.get().getEstado());
                } else {
                    System.out.println("No ha seleccionado persona");
                }


            } else if (event.getSource() == bDialogoPerso) {
                TextField tNombre = new TextField();
                tNombre.setPromptText("promnt");
                TextField tApellido = new TextField();
                tApellido.setPromptText("promnt");
                Dialog dialogo = new Dialog();
                dialogo.setTitle("titulo perso");
                dialogo.setHeaderText("header perso");
                GridPane gridContaint = new GridPane();
                gridContaint.setHgap(10);
                gridContaint.setVgap(10);
                gridContaint.add(new Label("Nombre"), 0, 0);
                gridContaint.add(tNombre, 1, 0);

                gridContaint.add(new Label("Apellido"), 0, 1);
                gridContaint.add(tApellido, 1, 1);

                dialogo.getDialogPane().getButtonTypes().setAll(ButtonType.APPLY, ButtonType.CANCEL);

                dialogo.getDialogPane().setContent(gridContaint);
                Optional<ButtonType> resultado = dialogo.showAndWait();
                if (resultado.get() == ButtonType.APPLY) {
                    System.out.println(tNombre.getText());
                } else if (resultado.get() == ButtonType.CANCEL) {

                }


            }
        }
    }

}
