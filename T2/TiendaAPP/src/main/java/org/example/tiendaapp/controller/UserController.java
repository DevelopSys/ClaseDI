package org.example.tiendaapp.controller;

import com.google.gson.Gson;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.JSONObject;

public class UserController implements Initializable {

    @FXML
    private Button btnCarr, btnComp, btnLog, btnVac;
    @FXML
    private TableColumn<?, ?> colId, colName, colPrice;
    @FXML
    private TextField editFiltrar;
    @FXML
    private TableView<?> tableViewProducts;
    @FXML
    private Text txtTot;

    private Task<?> taskJSON;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instances();
        initGUI();
        // cargar JSON en la tabla

    }

    private void initGUI() {
        Thread thread = new Thread(taskJSON);
        thread.setDaemon(true);
        thread.start();
    }

    private void instances() {
        taskJSON =  new Task<Object>() {
            @Override
            protected Object call() throws Exception {
                try {
                    String URL = "https://dummyjson.com/products";
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(URL))
                            .GET()
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                    String body = response.body();
                    System.out.println(body);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                return null;
            }
        };
    }
}
