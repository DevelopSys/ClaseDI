package controller;

import model.Accion;
import model.Estrategia;
import model.Juego;
import model.RPG;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ApiController {

    private HttpClient cliente;
    private HttpResponse response;
    private HttpRequest request;

    public List<Juego> importJSON() {

        List<Juego> lista = new ArrayList<>();
        cliente = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("asdasd"))
                .GET().build();
        try {
            response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body().toString();
            JSONArray array = new JSONArray(body);

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                object.getString("titulo");
                object.getString("titulo");
                object.getString("titulo");
                object.getString("titulo");
                object.getString("titulo");
                String tipo = object.getString("tipo");
                Juego juego = null;
                switch (tipo){
                    case "RPG"-> juego = new RPG();
                    case "Accion"-> juego = new Accion();
                    case "Estrategia"-> juego = new Estrategia();
                }
                lista.add(juego);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return lista;
    }
}
