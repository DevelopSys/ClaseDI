package org.example.gestor;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    private Button btnConsulta;

    @FXML
    private TextField campoGenero, campoResultados;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnConsulta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // url -> "https://www.miapi/json/peticion"
                // httpConnection
                // bufferedReader
                String urlString = "https://randomuser.me/api/?results=%s&gender=%s";
                try {
                    URL urlConnection = new URL(String.format(urlString,campoResultados.getText(), campoGenero.getText()));
                    HttpURLConnection connection = (HttpURLConnection) urlConnection.openConnection();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    String linea = null;
                    StringBuffer stringBuffer = new StringBuffer();
                    // cuando no puedas leer mas lineas, termina
                    while ((linea = reader.readLine()) != null) {
                        stringBuffer.append(linea);
                    }

                    JSONObject jsonObject = new JSONObject(stringBuffer.toString());
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        Gson gson = new Gson();
                        JSONObject persona = jsonArray.getJSONObject(i);
                        UsuarioJSON usuarioJSON = gson.fromJson(persona.toString(), UsuarioJSON.class);
                        System.out.println(usuarioJSON.getEmail() +" "+usuarioJSON.getNat());
                        /*JSONObject name = persona.getJSONObject("name");
                        /*String title = name.getString("title");
                        String first = name.getString("first");
                        String last = name.getString("last");
                        String genero = persona.getString("gender");
                        String mail = persona.getString("email");
                        String telefono = persona.getString("phone");
                        System.out.printf("Title: %s, First: %s, Last: %s\n", title, first, last);
                        System.out.printf("Mail: %s, genero: %s, telefono: %s\n", mail, genero, telefono);*/
                    }

                } catch (MalformedURLException e) {
                    System.out.println("URL invalida");
                } catch (IOException e) {
                    System.out.println("Error en la conexion del servidor");
                }
            }
        });
    }
}
