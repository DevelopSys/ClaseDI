package com.example.listas;

import com.example.listas.utils.Pelicula;
import com.example.listas.utils.Persona;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListaController implements Initializable {

    @FXML
    private ChoiceBox choice;

    @FXML
    private ComboBox combo;

    @FXML
    private ListView listView;

    @FXML
    private Label labelCombo, labelChoice;

    @FXML
    private Button btnComprobar;

    @FXML private ImageView imageView;

    private Task tareaJson;

    private ObservableList<Persona> listaCombo, listaChoice;

    private ObservableList<Pelicula> listaPeliculas;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(Thread.currentThread());
        instancias();
        iniciarListas();
        asociarElementos();
        lecturaJSON();
        acciones();

    }

    private void acciones() {
        btnComprobar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Thread(tareaJson).start();
            }
        });
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object newValue) {
                Pelicula peliculaSeleccionada = (Pelicula) newValue;
                imageView.setImage(new Image(peliculaSeleccionada.getImagen()));

            }
        });
    }
    private void lecturaJSON() {
        tareaJson = new Task() {
            @Override
            protected Object call() throws Exception {
                // tarea muy pesada
                String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=es-ES&page=1";
                InputStream inputStream = new URL(url).openStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String respuesta = bufferedReader.readLine();
                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(respuesta);
                System.out.println(json);
                /*try {
                    InputStream inputStream = new URL(url).openStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String respuesta = bufferedReader.readLine();
                    JSONObject jsonGeneral = new JSONObject(respuesta);
                    JSONArray arrayResultados = jsonGeneral.getJSONArray("results");

                    for (int i = 0; i < arrayResultados.length(); i++) {
                        System.out.println(Thread.currentThread());
                        JSONObject objetoPelicula = arrayResultados.getJSONObject(i);
                        String titulo = objetoPelicula.getString("original_title");
                        String descricion = objetoPelicula.getString("overview");
                        int id = objetoPelicula.getInt("id");
                        double popularidad = objetoPelicula.getDouble("popularity");
                        String imagen = "https://image.tmdb.org/t/p/w500" + objetoPelicula.getString("poster_path");
                        Pelicula pelicula = new Pelicula(id, titulo, descricion, imagen, popularidad);
                        listaPeliculas.add(pelicula);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                return null;
            }
        };



    }

    private void iniciarListas() {
        listaCombo.addAll(new Persona("Borja", "Martin", "123A", 123, 12)
                , new Persona("Pedro", "Herrera", "123A", 123, 12)
                , new Persona("Marcos", "Gomez", "123A", 123, 12));

        listaChoice.addAll(new Persona("Borja", "Martin", "123A", 123, 12)
                , new Persona("Pedro", "Herrera", "123A", 123, 12)
                , new Persona("Marcos", "Gomez", "123A", 123, 12));
    }

    private void asociarElementos() {
        choice.setItems(listaChoice);
        combo.setItems(listaCombo);
        listView.setItems(listaPeliculas);
    }

    private void instancias() {
        listaPeliculas = FXCollections.observableArrayList();
        listaCombo = FXCollections.observableArrayList();
        listaChoice = FXCollections.observableArrayList();
    }
}