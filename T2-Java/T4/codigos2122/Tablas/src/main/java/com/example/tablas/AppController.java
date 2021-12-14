package com.example.tablas;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.concurrent.Task;
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
import javafx.util.Callback;
import org.json.*;

import java.io.*;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class AppController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private TableColumn columnaID, columnaIdioma, columnaPopularidad, columnaTitulo;

    @FXML
    private TableView tablaPeliculas;

    @FXML
    private TextField textoFiltrar;

    @FXML
    private MenuItem menuTablas, menuDialogos;

    private ObservableList<Pelicula> listaPeliculas;

    private FilteredList<Pelicula> listaFiltrada;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        lecturaJSON();
        asociarElementos();
        acciones();
    }

    private void lecturaJSON() {


        Task tareaSecundaria = new Task() {
            @Override
            protected Object call() throws Exception {
                // lectura JSON
                String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=en-US&page=1";
                InputStream lectura = null;
                BufferedReader bufferedReader = null;
                try {
                    lectura = new URL(url).openStream();
                    bufferedReader = new BufferedReader(new InputStreamReader(lectura));
                    StringBuffer respuesta = new StringBuffer();
                    String linea = "";

                    while ((linea = bufferedReader.readLine()) != null) {
                        // siempre y cuando tengas lectura de linea
                        respuesta.append(linea);
                    }

                    JSONObject jsonObject = new JSONObject(respuesta.toString());
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject peliculaActual = jsonArray.getJSONObject(i);
                        String titulo = peliculaActual.getString("original_title");
                        String descripcion = peliculaActual.getString("overview");
                        String imagen = "https://image.tmdb.org/t/p/w500" + peliculaActual.getString("poster_path");
                        String idioma = peliculaActual.getString("original_language");
                        int id = peliculaActual.getInt("id");
                        double popularidad = peliculaActual.getDouble("popularity");
                        listaPeliculas.add(new Pelicula(id, titulo, idioma, imagen, descripcion, popularidad));

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        new Thread(tareaSecundaria).run();

    }

    private void rellenarListas() {
        listaPeliculas.add(new Pelicula(1, "asd", "asd", "asd", "asd", 12.9));
    }

    private void asociarElementos() {
        tablaPeliculas.setItems(listaFiltrada);
    }

    private void acciones() {
        textoFiltrar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                //System.out.println(newValue);
                listaFiltrada.setPredicate(new Predicate<Pelicula>() {
                    @Override
                    public boolean test(Pelicula pelicula) {
                        return pelicula.getTitulo().toLowerCase().contains(newValue.toLowerCase());
                    }
                });
            }
        });
        menuTablas.setOnAction(this);
        menuDialogos.setOnAction(this);
    }

    private void instancias() {
        listaPeliculas = FXCollections.observableArrayList();
        listaFiltrada = new FilteredList(listaPeliculas);
        columnaID.setCellValueFactory(new PropertyValueFactory("id"));
        columnaTitulo.setCellValueFactory(new PropertyValueFactory("titulo"));
        columnaPopularidad.setCellValueFactory(new PropertyValueFactory("popularidad"));
        columnaIdioma.setCellValueFactory(new PropertyValueFactory("idioma"));
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == menuTablas){
            System.out.println("Seleccionado menu tablas");
        } else if (actionEvent.getSource() == menuDialogos) {
            System.out.println("Seleccionado menu diálogos");
            Stage stage = (Stage) textoFiltrar.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(AppController.class.getResource("dialogos-view.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader.load();

            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            stage.setWidth(root.getScene().getWidth());
            stage.setHeight(root.getScene().getHeight());

            stage.setScene(scene);
        }
    }
}