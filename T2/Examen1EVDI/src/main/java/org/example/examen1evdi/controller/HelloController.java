package org.example.examen1evdi.controller;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.examen1evdi.HelloApplication;
import org.example.examen1evdi.model.Chiste;
import org.json.JSONArray;
import org.json.JSONObject;

public class HelloController implements Initializable {

    @FXML
    private Button btnCategoria;

    @FXML
    private Button btnChiste;

    @FXML
    private Button btnFav;

    @FXML
    private Button btnFavList;

    @FXML
    private ComboBox<String> comboCategoria;
    private ObservableList<String> listaCategorias;

    private ObservableList<String> listaFavs;

    @FXML
    private ImageView imagen;

    @FXML
    private Text textoChiste;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instances();
        initGUI();
        actions();

    }

    private void instances() {
        listaCategorias = FXCollections.observableArrayList(getCategorias());
        listaFavs = FXCollections.observableArrayList();
    }

    private void actions() {
        btnCategoria.setOnAction(event -> {
            if (comboCategoria.getSelectionModel().getSelectedItem()!=null){
            textoChiste.setText(getChisteCaegoria(comboCategoria.getSelectionModel().getSelectedItem()));
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("No hay categoria");
                alert.show();
            }
        });
        btnFav.setOnAction(event -> {
            if (!textoChiste.getText().isEmpty()){
                listaFavs.add(textoChiste.getText());
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("chiste favorito marcado");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("No hay chiste");
                alert.show();
            }
        });
        btnFavList.setOnAction(event -> {
            if (!listaFavs.isEmpty()){
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("favs.fxml"));
                try {
                    Parent root = loader.load();
                    FavController controller = loader.getController();
                    controller.setLista(listaFavs);
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Favs");
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("No hay chiste como favs");
                alert.show();
            }
        });
        btnChiste.setOnAction(event -> {
            textoChiste.setText(getChiste());
        });
    }

    private void initGUI() {
        imagen.setImage(new Image("https://api.chucknorris.io/img/chucknorris_logo_coloured_small@2x.png"));
        comboCategoria.setItems(listaCategorias);
    }


    private ArrayList<String> getCategorias() {
        ArrayList<String> list = new ArrayList<>();
        // 1 - cliente
        HttpClient client = HttpClient.newHttpClient();
        // 2 - peticion
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://api.chucknorris.io/jokes/categories"))
                .GET()
                .build();
        // 3 - repuesta
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            // 4 - json
            JSONArray array = new JSONArray(body);
            for (int i = 0; i < array.length(); i++) {
                list.add(array.getString(i));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    private String getChiste() {
        // 1 - cliente
        HttpClient client = HttpClient.newHttpClient();
        // 2 - peticion
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://api.chucknorris.io/jokes/random"))
                .GET()
                .build();
        // 3 - repuesta
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            // 4 - json
            JSONObject chiste = new JSONObject(body);
            // Gson gson = new Gson();
            // Chiste chisteObjeto = gson.fromJson(chiste.toString(), Chiste.class)
            return chiste.getString("value");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    private String getChisteCaegoria(String categoria) {
        // 1 - cliente
        HttpClient client = HttpClient.newHttpClient();
        // 2 - peticion
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://api.chucknorris.io/jokes/random?category=" + categoria))
                .GET()
                .build();
        // 3 - repuesta
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            // 4 - json
            JSONObject chiste = new JSONObject(body);
            // Gson gson = new Gson();
            // Chiste chisteObjeto = gson.fromJson(chiste.toString(), Chiste.class)
            return chiste.getString("value");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
