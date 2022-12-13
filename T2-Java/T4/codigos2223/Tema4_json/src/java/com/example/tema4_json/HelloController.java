package com.example.tema4_json;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import model.Usuario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    @FXML
    private Button botonJSON;

    @FXML
    private ComboBox<String> comboGenero;
    private ObservableList<String> listaGenero;

    @FXML
    private ImageView imagenPersona;

    @FXML
    private ListView<Usuario> listaPersonas;
    private ObservableList<Usuario> listaUsuarios;

    @FXML
    private Spinner<Integer> spinnerResultados;

    @FXML
    private Label textoDireccion;

    @FXML
    private Label textoMail;

    @FXML
    private Label textoNombre;

    @FXML
    private Label textoTelefono;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        instancias();
        asociarDatos();
        acciones();


    }

    private void asociarDatos() {
        comboGenero.setItems(listaGenero);

        spinnerResultados.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100));
    }

    private void instancias() {

        listaUsuarios= FXCollections.observableArrayList();

        listaGenero= FXCollections.observableArrayList();
        listaGenero.addAll("Todos","Male","Female");
    }

    private void acciones() {

        botonJSON.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String urlBase = "https://randomuser.me/api/?results=%s&gender=%s";

                try {
                    URL url = new URL(String.format(urlBase, String.valueOf(spinnerResultados.getValue()),comboGenero.getValue()));
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    StringBuilder lectura = new StringBuilder();

                    String linea = null;

                    while ((linea = br.readLine())!=null){
                        lectura.append(linea);
                    }
                    JSONObject jsonGeneral = new JSONObject(lectura.toString());
                    JSONArray arrayResultados = jsonGeneral.getJSONArray("results");

                    for (int i = 0; i < arrayResultados.length(); i++) {
                        JSONObject resultado = arrayResultados.getJSONObject(i);

                        JSONObject name = resultado.getJSONObject("name");

                        String titulo = name.getString("title");

                        String nombre = name.getString("first");

                        String apellido = name.getString("last");

                        String correo = resultado.getString("email");

                        String direcion = resultado.getJSONObject("location").getString("country");

                        String telefono = resultado.getString("phone");

                        String imagen = resultado.getJSONObject("picture").getString("large");

                        listaUsuarios.add(new Usuario(nombre,apellido,direcion,telefono,correo,imagen));
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}