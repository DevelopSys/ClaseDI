package com.example.filtradoligas;

import com.google.gson.Gson;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button botonFiltrar;

    @FXML
    private ImageView imagenEquipo;

    @FXML
    private Label ligaEquipo;

    @FXML
    private ListView<String> listaPaises;
    private ObservableList<String> listaObserverPaises;

    @FXML
    private ListView<Equipo> listaEquipos;
    private ObservableList<Equipo> listaObserverEquipos;



    @FXML
    private MenuItem menuDetalle;

    @FXML
    private MenuItem menuSalir;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listaObserverPaises = FXCollections.observableArrayList();
        listaPaises.setItems(listaObserverPaises);

        listaObserverEquipos = FXCollections.observableArrayList();
        listaEquipos.setItems(listaObserverEquipos);
        listaEquipos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Equipo>() {
            @Override
            public void changed(ObservableValue<? extends Equipo> observableValue, Equipo equipo, Equipo t1) {
                imagenEquipo.setImage(new Image(t1.strTeamBadge));
                ligaEquipo.setText(t1.strLeague);
            }
        });
        menuDetalle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("dialog-view.fxml"));
                try {
                    Parent root = loader.load();
                    Dialog dialogDetalle = new Dialog();
                    DialogController dialogController = loader.getController();
                    dialogController.setDetalle(listaEquipos.getSelectionModel().getSelectedItem());
                    dialogDetalle.getDialogPane().setContent(root);
                    dialogDetalle.getDialogPane().getButtonTypes().setAll(ButtonType.OK);
                    dialogDetalle.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        botonFiltrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (listaPaises.getSelectionModel().getSelectedIndex()>-1){

                cargarEquipos(listaPaises.getSelectionModel().getSelectedItem());
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("No hay elemento seleccionado");
                    alert.show();
                }
            }
        });
        menuSalir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alertSalir = new Alert(Alert.AlertType.CONFIRMATION);
                alertSalir.setContentText("Estas seguro que quieres salir");
                Optional<ButtonType> respuesta= alertSalir.showAndWait();
                if (respuesta.get() == ButtonType.OK){
                    System.exit(0);
                }
            }
        });
        cargarPaises();

    }

    public void cargarEquipos(String liga){

        URL url = null;
        try {
            url = new URL("https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?s=Soccer&c="+liga);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String respuesta = reader.readLine();
            JSONObject response = new JSONObject(respuesta);

            if (response.getJSONArray("teams")==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Ha ocurrido un error en el proceso");
                alert.show();
            } else {
                JSONArray teams =response.getJSONArray("teams");
                for (int i = 0; i < teams.length(); i++) {
                    JSONObject equipoJSON = teams.getJSONObject(i);
                    Equipo equipo = new Gson().fromJson(equipoJSON.toString(),Equipo.class);
                    listaObserverEquipos.add(equipo);
                }
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Ha ocurrido un error en el proceso");
            alert.show();
        }

    }
    private void cargarPaises() {
        //
        try {
            URL url = new URL("https://www.thesportsdb.com/api/v1/json/3/all_countries.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String respuesta = reader.readLine();
            JSONObject response = new JSONObject(respuesta);
            JSONArray contries = response.getJSONArray("countries");
            for (int i = 0; i < contries.length(); i++) {
                JSONObject pais = contries.getJSONObject(i);
                listaObserverPaises.add(pais.getString("name_en"));
            }
            
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}