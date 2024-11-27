package org.example.usuarios.dao;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.usuarios.model.Producto;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiDAO {

    String urlCategorias =  "https://dummyjson.com/products/categories";
    String urlProductos = "https://dummyjson.com/products/category/";

    public ObservableList getAllProducts(String category){

        ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
        try {
            URL url = new URL(urlProductos+category);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
            JSONArray jsonArray = jsonObject.getJSONArray("products");

            for (int i = 0; i < jsonArray.length(); i++) {
                Gson gson = new Gson();
                Producto producto = gson.fromJson(jsonArray.getJSONObject(i).toString(),Producto.class);
                listaProductos.add(producto);
            }
            return listaProductos;
        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
    public ObservableList getAllCategories(){

        ObservableList<String> listaCategorias = FXCollections.observableArrayList();
        try {
            URL url = new URL(urlCategorias);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            JSONArray jsonArray = new JSONArray(bufferedReader.readLine());
            for (int i = 0; i < jsonArray.length(); i++) {
                // Gson gson = new Gson();
                // Producto producto = gson.fromJson(jsonArray.getJSONObject(i).toString(),Producto.class);
                JSONObject product = jsonArray.getJSONObject(i);
                String slug = product.getString("slug");
                listaCategorias.add(slug);
            }
            return listaCategorias;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
