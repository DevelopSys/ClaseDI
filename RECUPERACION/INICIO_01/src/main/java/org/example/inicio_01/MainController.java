package org.example.inicio_01;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class MainController implements Initializable {

    @FXML
    private TextField inputNombre;

    @FXML
    private Button botonEnviar;

    @FXML
    private ListView<String> listaDatos;

    private ObservableList<String> listaPalabras;
    @FXML private Button botonPalabra;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listaPalabras = FXCollections.observableArrayList();
        listaPalabras.add("Palabra uno");
        listaPalabras.add("Palabra dos");
        listaPalabras.add("Palabra tres");
        listaPalabras.add("Palabra cuatro");

        listaDatos.setItems(listaPalabras);

        botonEnviar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // pulsar
                // Stage -> Scene -> Nodes (FXML)
                Stage ventana = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("second.fxml"));
                try {
                    Parent root = loader.load();
                    SecondController secondController =loader.getController();
                    secondController.comunicarDato(inputNombre.getText());
                    Scene scene = new Scene(root, 500,500);
                    ventana.setScene(scene);
                    ventana.show();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        botonPalabra.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(listaDatos.getSelectionModel().getSelectedItem());
                listaDatos.getSelectionModel().select(-1);
            }
        });
    }
}
