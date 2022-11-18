package com.example.t4_json_ret;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
                    JSONObject resultadoUno = arrayResultados.getJSONObject(0);
                    //System.out.println(resultadoUno);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}