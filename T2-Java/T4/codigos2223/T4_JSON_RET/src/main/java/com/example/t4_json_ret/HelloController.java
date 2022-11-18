package com.example.t4_json_ret;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    @FXML private Button botonJSON;

    @FXML private Spinner spinner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        spinner
                .setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100));

        acciones();

    }

    private void acciones() {

        botonJSON.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // peticion https
                // 1-URL
                // 2-Conexion por https
                // 3-Interpretar la respuesta
                // 4-String - JSON
                String urlQuery = "https://randomuser.me/api/?results=5";
                try {
                    URL url = new URL(urlQuery);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    BufferedReader bufferedInputStream =
                            new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    StringBuilder lectura = new StringBuilder();
                    String linea = null;
                    while ((linea = bufferedInputStream.readLine())!=null){
                        lectura.append(linea);
                    }

                    JSONObject jsonGeneral = new JSONObject(lectura.toString());
                    JSONArray arrayResultados = jsonGeneral.getJSONArray("results");
                    for (int i = 0; i < arrayResultados.length(); i++) {
                        JSONObject resultadoUno = arrayResultados.getJSONObject(i);
                        resultadoUno.getJSONObject("name").getString("title");
                        resultadoUno.getJSONObject("name").getString("first");
                        resultadoUno.getJSONObject("name").getString("last");
                        JSONObject jsonNombre = resultadoUno.getJSONObject("name");
                        String title = jsonNombre.getString("title");
                        String first = jsonNombre.getString("first");
                        String last = jsonNombre.getString("last");
                        System.out.printf("%s %s %s%n", title,first,last);
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}