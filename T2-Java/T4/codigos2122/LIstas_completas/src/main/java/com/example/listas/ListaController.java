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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;
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
    private Button btnComprobar, btnDetalle;

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
        btnDetalle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (listView.getSelectionModel().getSelectedIndex()<0){
                    System.out.println("No hay seleccion en la lista");
                } else {
                    Stage stage = new Stage();
                    FXMLLoader loader = null;
                    Parent root = null;
                    DetailController detailController = null;
                    try {
                        loader = new FXMLLoader(getClass()
                                .getResource("detalle-view.fxml"));
                        root = loader.load();
                        detailController = loader.getController();
                        detailController.comunicarPelicula((Pelicula) listView.getSelectionModel().getSelectedItem(),ListaController.this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Scene scene = new Scene(root,400,400);
                    stage.setScene(scene);
                    stage.setTitle("Detalle");
                    stage.show();
                }
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
                //String respuesta = bufferedReader.readLine();
                String linea = null;
                StringBuffer stringBuffer = new StringBuffer();

                while ( (linea=bufferedReader.readLine())!=null ){
                    stringBuffer.append(linea);
                }
                JSONObject jsonObject = new JSONObject(stringBuffer.toString());
                JSONArray arrayPeliculas = jsonObject.getJSONArray("results");
                for (int i = 0; i < arrayPeliculas.length(); i++) {
                    JSONObject pelicula = arrayPeliculas.getJSONObject(i);
                    int id = pelicula.getInt("id");
                    String titulo = pelicula.getString("original_title");
                    String descripcion = pelicula.getString("overview");
                    double popularidad = pelicula.getDouble("popularity");
                    String imagen= "https://image.tmdb.org/t/p/w500"
                            +pelicula.getString("poster_path");
                    Pelicula peliculaActual = new Pelicula(id,titulo
                            ,descripcion,imagen,popularidad);
                    listaPeliculas.add(peliculaActual);
                    //https://image.tmdb.org/t/p/w500/

                }



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

    public void metodoContesar(String mensaje){
        System.out.println(mensaje);
    }

    private void instancias() {
        listaPeliculas = FXCollections.observableArrayList();
        listaCombo = FXCollections.observableArrayList();
        listaChoice = FXCollections.observableArrayList();
    }
}