package com.example.repasocomunicacion_ret;

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
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class GeneralController implements Initializable {

    @FXML
    private Button botonCorreo;

    @FXML
    private Button botonDNI;

    @FXML
    private Button botonNombre;

    @FXML
    private Button botonTelefono;

    @FXML
    private TableColumn<?, ?> colCorreo;

    @FXML
    private TableColumn<?, ?> colDNI;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableView<Usuario> tabla;

    private ObservableList<Usuario> listaUsuarios;

    @FXML
    private Label labelCorreo;

    @FXML
    private Label labelDNI;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelTelefono;

    @FXML
    private MenuItem menuAdd;

    @FXML
    private MenuItem menuAyuda;

    @FXML
    private MenuItem menuDNI;

    @FXML
    private MenuItem menuRemove;

    @FXML
    private MenuItem menuReset;

    @FXML
    private MenuItem menuSalir;

    private int id = 1;

    private FilteredList<Usuario> listaFiltrada;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            URL urlLectura = new URL("https://api.chucknorris.io/jokes/categories");
            HttpURLConnection connection = (HttpURLConnection) urlLectura.openConnection();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder stringBuilder = new StringBuilder();
            String linea = null;

            while ((linea = reader.readLine()) != null) {
                stringBuilder.append(linea);
            }

            JSONArray array = new JSONArray(stringBuilder.toString());
            for (int i = 0; i < array.length(); i++) {
                System.out.println(array.getString(i));
            }


            URL urlChiste = new URL("https://api.chucknorris.io/jokes/random?category=" + array.getString(6));
            connection = (HttpURLConnection) urlChiste.openConnection();
            reader =
                    new BufferedReader(new InputStreamReader(connection.getInputStream()));

            stringBuilder = new StringBuilder();
            linea = null;

            while ((linea = reader.readLine()) != null) {
                stringBuilder.append(linea);
            }

            JSONObject object = new JSONObject(stringBuilder.toString());
            System.out.println(object.getString("value"));


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        instancias();
        configurarTabla();
        acciones();
    }

    private void configurarTabla() {
        tabla.setItems(listaFiltrada);
        //listaUsuarios.add(new Usuario(1,"asdads","asad","awdasd",123));
        colID.setCellValueFactory(new PropertyValueFactory("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDNI.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
    }

    private void instancias() {
        listaUsuarios = FXCollections.observableArrayList();
        listaFiltrada = new FilteredList<>(listaUsuarios);
        Usuario usuario = new Usuario(0, "labelNombre",
                "labelCorreo", "2345", 123);
        listaUsuarios.add(usuario);
    }

    private void acciones() {
        menuSalir.setOnAction(new ManejoPulsaciones());
        menuAdd.setOnAction(new ManejoPulsaciones());
        menuDNI.setOnAction(new ManejoPulsaciones());
        menuReset.setOnAction(new ManejoPulsaciones());
        menuRemove.setOnAction(new ManejoPulsaciones());
        botonNombre.setOnAction(new ManejoPulsaciones());
        botonCorreo.setOnAction(new ManejoPulsaciones());
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == menuSalir) {
                System.exit(0);
            } else if (actionEvent.getSource() == botonNombre) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("nombre.fxml"));
                try {
                    Parent root = loader.load();
                    Stage ventana = new Stage();
                    Scene scene = new Scene(root, 400, 400);
                    NombreController nombreController = loader.getController();
                    nombreController.setController(GeneralController.this);
                    ventana.setScene(scene);
                    ventana.show();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (actionEvent.getSource() == botonCorreo) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("correo.fxml"));
                try {
                    Parent root = loader.load();
                    Scene scene = new Scene(root, 400, 400);
                    Stage ventana = new Stage();
                    CorreoController controller = loader.getController();
                    controller.setController(GeneralController.this);
                    ventana.setScene(scene);
                    ventana.show();
                } catch (Exception e) {

                }
            } else if (actionEvent.getSource() == menuAdd) {
                // prguntar por todos los campos if ()
                Usuario usuario = new Usuario(id, labelNombre.getText(),
                        labelCorreo.getText(), "1234A", 123);
                listaUsuarios.add(usuario);
                limpiarTextos();
                id++;
            } else if (actionEvent.getSource() == menuRemove) {
                if (tabla.getSelectionModel().getSelectedIndex() > -1) {
                    listaUsuarios.remove(tabla.getSelectionModel().getSelectedIndex());
                }
            } else if (actionEvent.getSource() == menuDNI) {
                listaFiltrada.setPredicate(new Predicate<Usuario>() {
                    @Override
                    public boolean test(Usuario usuario) {
                        return usuario.getDni().equalsIgnoreCase("1234A");
                    }
                });
            } else if (actionEvent.getSource() == menuReset) {
                listaFiltrada.setPredicate(new Predicate<Usuario>() {
                    @Override
                    public boolean test(Usuario usuario) {
                        return true;
                    }
                });
            }
        }


    }

    public void limpiarTextos() {
        labelCorreo.setText("");
        labelNombre.setText("");
        labelTelefono.setText("");
        labelDNI.setText("");

    }

    public void setNombre(String nombre) {
        this.labelNombre.setText(nombre);
    }

    public void setCorreo(String correo) {
        this.labelCorreo.setText(correo);
    }
}
