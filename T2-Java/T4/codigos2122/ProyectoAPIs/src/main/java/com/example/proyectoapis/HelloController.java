package com.example.proyectoapis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable, EventHandler<ActionEvent> {


    @FXML
    private Button chisteAleatorioCategoria, chisteAleatorios;

    @FXML
    private ComboBox comboCategorias;

    @FXML
    private ImageView imagen;

    @FXML
    private ListView listaChistes;

    private ObservableList listaCategorias, listaChistesAleatorios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarElementos();
        leerCategorias();
        acciones();
    }

    private void acciones() {
        chisteAleatorioCategoria.setOnAction(this);
        chisteAleatorios.setOnAction(this);
    }

    private void leerCategorias() {
        Task tareaSecundaria = new Task() {
            @Override
            protected Object call() throws Exception {
                String url = "https://api.chucknorris.io/jokes/categories";
                InputStream inputStream = new URL(url).openStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                //System.out.println(bufferedReader.readLine());
                StringBuffer stringBuffer = new StringBuffer();
                String linea = "";
                while ((linea = bufferedReader.readLine()) != null) {
                    stringBuffer.append(linea);
                }

                String respuesta = stringBuffer.toString();
                JSONArray categorias = new JSONArray(respuesta);
                //System.out.println(categorias);
                for (int i = 0; i < categorias.length(); i++) {
                    listaCategorias.add(categorias.getString(i));
                }

                return null;
            }
        };

        new Thread(tareaSecundaria).run();
    }

    private void asociarElementos() {
        listaChistes.setItems(listaChistesAleatorios);
        comboCategorias.setItems(listaCategorias);
    }

    private void instancias() {
        listaCategorias = FXCollections.observableArrayList();
        listaChistesAleatorios = FXCollections.observableArrayList();
    }

    private void consultarChiste() {
        String url = "https://api.chucknorris.io/jokes/random";
        InputStream inputStream = null;
        try {
            inputStream = new URL(url).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //System.out.println(bufferedReader.readLine());
            StringBuffer stringBuffer = new StringBuffer();
            String linea = "";
            while ((linea = bufferedReader.readLine()) != null) {
                stringBuffer.append(linea);
            }
            JSONObject chiste = new JSONObject(stringBuffer.toString());
            listaChistesAleatorios.add(chiste.getString("value"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void consultarChiste(String categoria) {

        String url;
        if (categoria == null) {
            url = "https://api.chucknorris.io/jokes/random";
        } else {
            url = "https://api.chucknorris.io/jokes/random?category=" + categoria;
        }
        //String url = "https://api.chucknorris.io/jokes/random";


        //String
        InputStream inputStream = null;
        try {
            inputStream = new URL(url).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //System.out.println(bufferedReader.readLine());
            StringBuffer stringBuffer = new StringBuffer();
            String linea = "";
            while ((linea = bufferedReader.readLine()) != null) {
                stringBuffer.append(linea);
            }
            JSONObject chiste = new JSONObject(stringBuffer.toString());
            listaChistesAleatorios.add(chiste.getString("value"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == chisteAleatorioCategoria) {
            if (comboCategorias.getSelectionModel().getSelectedIndex() != -1) {
                consultarChiste(comboCategorias.getSelectionModel().getSelectedItem().toString());
            } else {
                System.out.println("No hay selección");
            }
        } else if (actionEvent.getSource() == chisteAleatorios) {
            consultarChiste(null);
        }
    }
}