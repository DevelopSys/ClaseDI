package com.example.t3_tablas;

import com.example.t3_tablas.model.Usuario;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import org.json.JSONObject;
import org.json.JSONArray;

public class MainController implements Initializable {
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

    @FXML
    private Button botonAgregar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listaObservableUsuarios = FXCollections.observableArrayList();
        tablaUsuarios.setItems(listaObservableUsuarios);

        columnaCorreo.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("first"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("phone"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory<>("last"));
        columnaPais.setCellValueFactory(new PropertyValueFactory<>("country"));

        cargarUsuarios();

    }

    public void cargarUsuarios(){
        //
        try {
            URL url = new URL("https://randomuser.me/api/?results=50");
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
}