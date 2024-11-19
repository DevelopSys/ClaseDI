package org.example.ligas;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        // URL
        try {
            URL url = new URL("https://www.thesportsdb.com/api/v1/json/3/all_leagues.php");
            // HTTPCOnnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // BufferedReader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // JSON
            JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
            JSONArray jsonArray = jsonObject.getJSONArray("leagues");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject league = jsonArray.getJSONObject(i);
                String name =league.getString("strLeague");
                String id =league.getString("idLeague");
                System.out.println("Nombre: "+name+" Id: "+id);
            }

            System.out.println(jsonObject);
        } catch (MalformedURLException e){
            System.out.println("URL mal escrita");
        } catch (IOException e) {
            System.out.println("Error en la conexion");
        }


    }
}