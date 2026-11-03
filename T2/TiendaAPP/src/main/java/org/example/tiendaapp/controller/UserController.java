package org.example.tiendaapp.controller;

import com.google.gson.Gson;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import org.example.tiendaapp.data.DataSet;
import org.example.tiendaapp.model.Product;
import org.example.tiendaapp.model.ResponseProduct;
import org.example.tiendaapp.model.User;
import org.json.JSONArray;
import org.json.JSONObject;

public class UserController implements Initializable {

    @FXML
    private Button btnCarr, btnComp, btnLog, btnVac;
    @FXML
    private TableColumn<?, ?> colId, colName, colPrice;
    @FXML
    private TextField editFiltrar;
    @FXML
    private TableView<Product> tableViewProducts;
    private ObservableList<Product> observableListProduct;
    @FXML
    private Text txtTot;
    private FilteredList<Product> filteredListProducts;
    private Task<List<Product>> taskJSON;
    private User currentUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instances();
        initGUI();
        actions();
    }

    private void actions() {
        editFiltrar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                // System.out.println(newValue);
                filteredListProducts.setPredicate(new Predicate<Product>() {
                    @Override
                    public boolean test(Product product) {
                        return product.getTitle().toLowerCase().contains(newValue.toLowerCase());
                    }
                });
            }
        });
        btnComp.setOnAction(event -> {
            // ver cual es el seleccionado
            // selectedModel -> selectedIndex / selecterItem
            Product productSelected = tableViewProducts.getSelectionModel().getSelectedItem();
            if (productSelected != null) {
                // productSelected.mostrarDatos();
                currentUser.addProduct(productSelected);
                tableViewProducts.getSelectionModel().select(-1);
                txtTot.setText(String.format("%.2f", currentUser.getTotal()));
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Info product");
                alert.setContentText("No hay seleccion");
                alert.show();
            }

        });
        btnVac.setOnAction(event -> {
            if (!currentUser.getProducts().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.getButtonTypes().addAll(ButtonType.FINISH);
                alert.setTitle("Vaciar");
                alert.setContentText(String.format("Actualmente tienes %d productos en carrito" +
                        ", ¿seguro que quieres vaciar?", currentUser.getProducts().size()));
                Optional<ButtonType> alerteResponse = alert.showAndWait();
                if (alerteResponse.get() == ButtonType.OK) {
                    currentUser.clearList();
                    txtTot.setText(String.format("%.2f", currentUser.getTotal()));
                }
                /*else if(alerteResponse.get() == ButtonType.CANCEL){

                }*/
            }
        });
    }

    private void initGUI() {
        Thread thread = new Thread(taskJSON);
        thread.setDaemon(true);
        thread.start();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("title"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        taskJSON.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                // taskJSON.getValue().forEach(Product::mostrarDatos);
                observableListProduct = FXCollections.observableArrayList(taskJSON.getValue());
                filteredListProducts = new FilteredList<>(observableListProduct);
                tableViewProducts.setItems(filteredListProducts);
            }
        });

    }

    private void instances() {
        taskJSON = new Task<List<Product>>() {
            @Override
            protected List<Product> call() throws Exception {
                Gson gson = new Gson();
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
                    /*JSONObject jsonObject = new JSONObject(body);
                    JSONArray jsonArray = jsonObject.getJSONArray("products");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        Product product = gson.fromJson(jsonObject1.toString(), Product.class);

                    }*/

                    System.out.println(body);
                    ResponseProduct responseProduct = gson.fromJson(body, ResponseProduct.class);
                    // responseProduct.getProducts().forEach(Product::mostrarDatos);
                    // System.out.println("Ejecutado");
                    return responseProduct.getProducts();

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                return new ArrayList<Product>();
            }
        };
    }

    public void setCurrentUser(String mail) {
        this.currentUser = DataSet.getUser(mail);
        txtTot.setText(String.format("%.2f", currentUser.getTotal()));
    }
}
