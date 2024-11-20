package org.example.demo.dao;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.demo.model.Equipo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class EquipoDAO {
    private URL url;
    private HttpURLConnection connection;

    public ObservableList<Equipo> getClasificacion(String id, String sesson ) throws IOException {
        ObservableList<Equipo> listaClasificacion = FXCollections.observableArrayList();
        url = new URL(String.format("https://www.thesportsdb.com/api/v1/json/3/lookuptable.php?l=%s&s=%s",id,sesson));
        connection = (HttpURLConnection) url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String linea;
        StringBuffer buffer = new StringBuffer();
        while ((linea = bufferedReader.readLine())!=null){
            buffer.append(linea);
        }
        System.out.println(buffer.toString());
        JSONObject jsonObject = new JSONObject(buffer.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("table");
        Gson gson = new Gson();
        for (int i = 0; i < jsonArray.length(); i++) {
            Equipo equipo = gson.fromJson(jsonArray.getJSONObject(i).toString(), Equipo.class);
            listaClasificacion.add(equipo);
        }

        return listaClasificacion;
    }
}
