package com.example.t3_tablas;

import com.example.t3_tablas.model.Usuario;
import com.google.gson.Gson;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import org.json.JSONObject;
import org.json.JSONArray;

public class MainController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private MediaView media;
    @FXML
    private TextField textoPais;
    @FXML
    private MenuItem menuGenero, menuNumero;
    @FXML
    private TableColumn<?, ?> columnaApellido;

    @FXML
    private TableColumn<?, ?> columnaCorreo;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private TableColumn<?, ?> columnaTelefono;

    @FXML
    private TableColumn<?, ?> columnaPais;

    @FXML
    private TableView<Usuario> tablaUsuarios;
    private ObservableList<Usuario> listaObservableUsuarios;

    private FilteredList<Usuario> listaUsuariosFiltrada;

    @FXML
    private Button botonAgregar, botonBorrar, botonVer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listaObservableUsuarios = FXCollections.observableArrayList();
        listaUsuariosFiltrada = new FilteredList(listaObservableUsuarios);
        tablaUsuarios.setItems(listaUsuariosFiltrada);

        columnaCorreo.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("first"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("phone"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory<>("last"));
        columnaPais.setCellValueFactory(new PropertyValueFactory<>("country"));

        cargarUsuarios("https://randomuser.me/api/?results=50");
        acciones();

        MediaPlayer player = new MediaPlayer(new Media("https://www.youtube.com/watch?v=Lyqhit860KM"));
        media.setMediaPlayer(player);
        player.setAutoPlay(true);

    }

    private void acciones() {
        botonAgregar.setOnAction(this);
        botonVer.setOnAction(this);
        botonBorrar.setOnAction(this);
        menuNumero.setOnAction(this);
        menuGenero.setOnAction(this);
        textoPais.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String>
                                        observableValue, String s, String t1) {
                listaUsuariosFiltrada.setPredicate(new Predicate<Usuario>() {
                    @Override
                    public boolean test(Usuario usuario) {
                        return usuario.getCountry().contains(t1);
                    }
                });
            }
        });
    }

    public void cargarUsuarios(String urlString){
        //
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lectura = reader.readLine();
            JSONObject response = new JSONObject(lectura);
            JSONArray results = response.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject user = results.getJSONObject(i);
                //Usuario usuario = new Gson().fromJson(user.toString(), Usuario.class);
                String nombre = user.getJSONObject("name").getString("first");
                String apellido = user.getJSONObject("name").getString("last");
                String telefono = user.getString("phone");
                String pais = user.getJSONObject("location").getString("country");
                String correo = user.getString("email");
                String genero = user.getString("gender");
                String imagen = user.getJSONObject("picture").getString("thumbnail");

                /*
                String first, String last, String email,
                   String country, String gender, String thumbnail, String phone
                * */
                listaObservableUsuarios.add(new Usuario(nombre,apellido,correo, pais,
                        genero,imagen,telefono));
            }


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonBorrar){
            int seleccion = tablaUsuarios.getSelectionModel().getFocusedIndex();
            if (seleccion>-1){
                listaObservableUsuarios.remove(seleccion);
                tablaUsuarios.getSelectionModel().select(null);
            }
        } else if (actionEvent.getSource() == botonAgregar){

        } else if (actionEvent.getSource() == botonVer){
            Usuario seleccion = tablaUsuarios.getSelectionModel().getSelectedItem();
            System.out.println(seleccion.getPhone());
        } else if (actionEvent.getSource() == menuGenero){
            String[] generos = new String[]{"Male","Female", "All"};
            ChoiceDialog<String> dialogGenero = new ChoiceDialog(generos[0],generos);
            dialogGenero.setContentText("Selecciona un genero");
            Optional<String> respuesta = dialogGenero.showAndWait();
            listaObservableUsuarios.clear();
            cargarUsuarios("https://randomuser.me/api/?results=50&gender="+respuesta.get());

        } else if (actionEvent.getSource() == menuNumero){
            int[] numeros = new int[100];
            for (int i = 1; i < 100; i++) {
                numeros[i] = i;
            }
            ChoiceDialog<Integer> dialogGenero = new ChoiceDialog(numeros,numeros[0]);
            dialogGenero.setContentText("Selecciona un numero");
            Optional<Integer> respuesta = dialogGenero.showAndWait();
            listaObservableUsuarios.clear();
            cargarUsuarios("https://randomuser.me/api/?results="+respuesta.get());
        }
    }
}