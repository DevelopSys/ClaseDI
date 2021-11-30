package com.example.repaso;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.*;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String urlJSON = "https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=en-US&page=1";
        InputStream inputStream;
        try {
            inputStream = new URL(urlJSON).openStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
            String respuesta = bf.readLine();
            JSONObject objetoGeneral = new JSONObject(respuesta);
            JSONArray arrayPeliculas = objetoGeneral.getJSONArray("results");
            for (int i = 0; i < arrayPeliculas.length(); i++) {
                JSONObject pelicula = arrayPeliculas.getJSONObject(i);
                String titulo = pelicula.getString("original_title");
                String descripcion = pelicula.getString("overview");
                System.out.println(titulo);
                System.out.println(descripcion);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}