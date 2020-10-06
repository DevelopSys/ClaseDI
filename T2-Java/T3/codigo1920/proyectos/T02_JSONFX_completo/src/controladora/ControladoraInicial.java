package controladora;

import com.google.gson.Gson;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import utils.Pelicula;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControladoraInicial implements Initializable {

    @FXML
    ImageView imagen_ejemplo;

    @FXML
    ListView<Pelicula> lista;

    @FXML
    MenuItem menu_parte_uno, menu_parte_dos;

    @FXML
    BorderPane border_principal;

    ObservableList<Pelicula> listaPeliculas;

    private String urlImagen;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listaPeliculas = FXCollections.observableArrayList();
        lista.setItems(listaPeliculas);
        urlImagen = "https://image.tmdb.org/t/p/w500";
        acciones();
        String urlJson = "https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=en-US&page=1";
        try {
            URL url = new URL(urlJson);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            // System.out.printf(http.toString());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(http.getInputStream()));
            String lecturaJson = in.readLine();

            // si los datos vienen de varias fuentes
            /*String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }*/
            in.close();
            //lecturaJson = lecturaJson.toString();
            JSONObject jsonOriginal = new JSONObject(lecturaJson);
            //System.out.println(jsonOriginal);
            JSONArray jsonArrayGeneral = jsonOriginal.getJSONArray("results");
            //System.out.println(jsonArrayGeneral);
            //JSONObject jsonObjectPrimero = (JSONObject) jsonArrayGeneral.get(0);
            //System.out.println(jsonObjectPrimero);
            //String titulo = jsonObjectPrimero.getString("original_title");
            //System.out.println(titulo);

            for (int i =0;i<jsonArrayGeneral.length();i++){
                JSONObject jsonObject = jsonArrayGeneral.getJSONObject(i);
                Gson gson = new Gson();
                Pelicula pelicula = gson.fromJson(jsonObject.toString(),Pelicula.class);
                listaPeliculas.add(pelicula);
            }

            /*System.out.println(listaPeliculas.size());
            Image image = new Image(urlImagen+listaPeliculas.get(1).getPoster_path());
            imagen_ejemplo.setFitWidth(300);
            imagen_ejemplo.setFitHeight(300);
            imagen_ejemplo.setImage(image);*/

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void acciones() {
        lista.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pelicula>() {
            @Override
            public void changed(ObservableValue<? extends Pelicula> observable, Pelicula oldValue, Pelicula newValue) {
                Image image = new Image(urlImagen+newValue.getPoster_path());
                imagen_ejemplo.setFitHeight(400);
                imagen_ejemplo.setFitWidth(400);
                imagen_ejemplo.setImage(image);

            }
        });
        menu_parte_uno.setOnAction(new ManejadorPulsaciones());
        menu_parte_dos.setOnAction(new ManejadorPulsaciones());
    }


    private class ManejadorPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == menu_parte_uno){

            }else if (event.getSource() == menu_parte_dos){
                System.out.println("Elemento pulsado");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../layout/ventana_inicial_propio.fxml"));

                try {
                    Parent root = loader.load();
                    border_principal.setCenter(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
