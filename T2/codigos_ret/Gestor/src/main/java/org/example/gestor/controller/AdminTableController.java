package org.example.gestor.controller;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.gestor.MyApp;
import org.example.gestor.model.Usuario;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class AdminTableController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private Button btnAnadir;

    @FXML
    private Button btnDetalle;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnModificar;

    @FXML
    private TableColumn<?, ?> columnaCorreo;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private TableColumn<?, ?> columnaTelefono;

    @FXML
    private TableView<Usuario> tableUsuarios;

    private ObservableList<Usuario> listaUsuarios;

    @FXML
    private TextField textoFiltro;
    private FilteredList<Usuario> listaFiltrada;

    @FXML
    private MenuItem menuInfoMain, menuInfo, menuAdd, menuBorrar, menuUpdate, menuCerrar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        initGUI();
        acciones();
    }

    private void initGUI() {
        menuCerrar.setMnemonicParsing(true);
        menuCerrar.setGraphic(new ImageView(new Image(MyApp.class.getResourceAsStream("cerrar.png"))));
    }

    private void acciones() {
        menuInfo.setOnAction(this);
        menuBorrar.setOnAction(this);
        menuInfoMain.setOnAction(this);
        menuUpdate.setOnAction(this);
        menuCerrar.setOnAction(this);
        menuAdd.setOnAction(this);
        btnAnadir.setOnAction(this);
        btnDetalle.setOnAction(this);
        btnEliminar.setOnAction(this);
        btnModificar.setOnAction(this);
        textoFiltro.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                listaFiltrada.setPredicate(new Predicate<Usuario>() {
                    @Override
                    public boolean test(Usuario usuario) {
                        return String.valueOf(usuario.getTelefono()).contains(newValue);
                    }
                });
            }
        });
    }

    private void instancias() {
        listaUsuarios = FXCollections.observableArrayList();
        listaUsuarios.addAll(
                new Usuario("Borja1", "Martin1", "correo@gmail.com1", "1234", 123, 1),
                new Usuario("Borja2", "Martin2", "correo@gmail.com2", "1234", 1234, 2),
                new Usuario("Borja3", "Martin3", "correo@gmail.com3", "1234", 12345, 3)
        );
        listaFiltrada = new FilteredList<>(listaUsuarios);
        tableUsuarios.setItems(listaFiltrada);
        columnaCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == btnAnadir) {
            listaUsuarios.add(new Usuario("Nuevon", "Nuevoa", "Nuevoc", "1234", 1234, 1));
        } else if (event.getSource() == menuCerrar) {
            System.exit(0);
        } else if (event.getSource() == btnDetalle) {
            if (tableUsuarios.getSelectionModel().getSelectedIndex() != -1) {
                Usuario seleccionado = tableUsuarios.getSelectionModel().getSelectedItem();
                System.out.println(seleccionado.getIdPerfil());
            }
        } else if (event.getSource() == btnEliminar) {
            // el seleccionado de la tabla
            if (tableUsuarios.getSelectionModel().getSelectedIndex() != -1) {
                Usuario seleccionado = tableUsuarios.getSelectionModel().getSelectedItem();
                int seleccionadoIndex = tableUsuarios.getSelectionModel().getSelectedIndex();
                listaUsuarios.remove(seleccionado);
            }
        } else if (event.getSource() == btnModificar) {
            if (tableUsuarios.getSelectionModel().getSelectedIndex() != -1) {
                Usuario seleccionado = tableUsuarios.getSelectionModel().getSelectedItem();
                seleccionado.setNombre("BorjaModificado");
            }
        }else if (event.getSource() == menuInfoMain) {
            Alert alertaInfor = new Alert(Alert.AlertType.WARNING);
            alertaInfor.setTitle("Informacion");
            alertaInfor.setHeaderText("Informacion del gestor");
            alertaInfor.setContentText("Este software es de la asignatura de DI");
            alertaInfor.show();
        } else if (event.getSource() == menuBorrar) {
            Alert alertaInfor = new Alert(Alert.AlertType.CONFIRMATION);
            alertaInfor.setTitle("Confirmacion");
            alertaInfor.setHeaderText("Proceso de borrado");
            alertaInfor.setContentText("¿Estas seguro que quieres borrar el elemento?");

            ButtonType b1 = new ButtonType("Creo que si");
            ButtonType b2 = new ButtonType("Creo que no");
            alertaInfor.getButtonTypes().setAll(ButtonType.CLOSE,b1,b2);
            Optional<ButtonType> optional = alertaInfor.showAndWait();
            if (optional.get() == b1){
                System.out.println("Has pulsado que si");
            } else if( optional.get() == b2){
                System.out.println("Has pulsado que no");
            } else if (optional.get() == ButtonType.CLOSE) {
                System.out.println("Has cerrado");
            }
        } else if (event.getSource() == menuUpdate){
            TextInputDialog textInputDialog = new TextInputDialog();
            textInputDialog.setTitle("Introduce");
            textInputDialog.setHeaderText("Datos a introducir");
            textInputDialog.setContentText("Introduce tu nombre para continiar");
            Optional<String> opcional = textInputDialog.showAndWait();
            System.out.println(opcional.get());
        } else if (event.getSource() == menuInfo) {
            // String[] listaOpciones = new String[]{"Opcion 1","Opcion 2", "Opcion 3"};
            Usuario[] listaOpciones = new Usuario[]{new Usuario("Borja","Martin"),new Usuario("Juan", "Gomez"),new Usuario("Luis","Aguado")};
            ChoiceDialog<Usuario> choiceDialog = new ChoiceDialog(listaOpciones[0],listaOpciones);
            choiceDialog.setTitle("Selecciona");
            choiceDialog.setHeaderText("Seleccion de opcion");
            choiceDialog.setHeaderText("Selecciona la opcion correspodiente");
            Optional<Usuario> optional = choiceDialog.showAndWait();
            System.out.println("La seleccion es "+optional.get().getApellido());
            if (optional.get().getApellido().equalsIgnoreCase("martin")){
                Alert dialogo = new Alert(Alert.AlertType.CONFIRMATION);
                dialogo.setContentText("Quieres cerrar la app");
                Optional<ButtonType> option = dialogo.showAndWait();
                if (option.get() == ButtonType.OK){
                    System.exit(0);
                }
            }

        } else if (event.getSource() == menuAdd) {
            Stage stage = new Stage();
            stage.setTitle("Dialogo de añadir");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }

    }
}
