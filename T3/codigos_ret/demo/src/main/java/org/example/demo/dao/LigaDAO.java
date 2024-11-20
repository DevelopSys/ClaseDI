package org.example.demo.dao;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.demo.model.Liga;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class LigaDAO {

    private URL url;
    private HttpURLConnection connection;

    public ObservableList<Liga> getLigas() throws IOException {
        url = new URL("https://www.thesportsdb.com/api/v1/json/3/all_leagues.php\n");
        connection = (HttpURLConnection) url.openConnection();
        BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader(connection.getInputStream()));
        JSONObject result = new JSONObject(bufferedReader.readLine());
        JSONArray results = result.getJSONArray("leagues");
        Gson gson = new Gson();
        ObservableList<Liga> listaLigas = FXCollections.observableArrayList();
        for (int i = 0; i < results.length(); i++) {
            JSONObject ligaJSON = results.getJSONObject(i);
            Liga liga = gson.fromJson(ligaJSON.toString(), Liga.class);
            if (liga.getStrSport().equalsIgnoreCase("soccer")){
                listaLigas.add(liga);
            }
        }

        return listaLigas;
    }
    public ObservableList<String> getTemporadas(String id) throws IOException {
        url = new URL("https://www.thesportsdb.com/api/v1/json/3/search_all_seasons.php?id="+id);
        connection = (HttpURLConnection) url.openConnection();
        ObservableList<String> temporadas = FXCollections.observableArrayList();
        BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader(connection.getInputStream()));
        JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
        JSONArray array = jsonObject.getJSONArray("seasons");
        for (int i = 0; i < array.length(); i++) {
            JSONObject temporada= array.getJSONObject(i);
            String tempoStr = temporada.getString("strSeason");
            temporadas.add(tempoStr);
        }

        return temporadas;
    }

}
