package org.example.demo;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.example.demo.dao.EquipoDAO;
import org.example.demo.dao.LigaDAO;
import org.example.demo.model.Equipo;
import org.example.demo.model.Liga;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LigasController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private ComboBox<String> comboTemporadas;
    private ObservableList<String> listaTemporadas;

    @FXML
    private ListView<Equipo> listViewClasificacion;

    private ObservableList<Equipo> listaClasificacion;

    @FXML
    private ListView<Liga> listViewLigas;

    @FXML private Button btnAnadir, btnBorrar, btnConsultar;

    private ObservableList<Liga> listaLigas;
    private LigaDAO ligaDAO;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void acciones() {
        // btnAnadir.setOnAction(this);
        btnBorrar.setOnAction(this);
        btnConsultar.setOnAction(this);
        listViewLigas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Liga>() {
            @Override
            public void changed(ObservableValue<? extends Liga> observable, Liga oldValue, Liga newValue) {
                ligaDAO = new LigaDAO();
                    Task<Void> task = new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        listaTemporadas = ligaDAO.getTemporadas(newValue.getIdLeague());
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    comboTemporadas.setItems(listaTemporadas);
                                    comboTemporadas.getSelectionModel().select(-1);
                                }
                            });
                            return null;
                        }
                    };

                    Thread thread = new Thread(task);
                    thread.start();


            }
        });
        comboTemporadas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                EquipoDAO equipoDAO = new EquipoDAO();
                Liga liga = listViewLigas.getSelectionModel().getSelectedItem();
                try {
                    listaClasificacion = equipoDAO.getClasificacion(liga.getIdLeague(),newValue);
                    listViewClasificacion.setItems(listaClasificacion);
                } catch (IOException e) {
                    System.out.println("Error en la conexion, quieres ver otra liga");
                }
            }
        });

    }

    private void instancias() {
        ligaDAO = new LigaDAO();
        try {
            listaLigas = ligaDAO.getLigas();
            listViewLigas.setItems(listaLigas);
        } catch (IOException e) {
            System.out.println("Error a la hora de hacer la carga");
        }
        // listaLigas.addAll("Premier","Bundesliga","SerieA","BBVA La liga");


        //listaTemporadas = FXCollections.observableArrayList("2024-2025","2023-2022");
        //comboTemporadas.setItems(listaTemporadas);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == btnBorrar) {
            /*int index = listViewLigas.getSelectionModel().getSelectedIndex();
            if (index<0){
                System.out.println("No hay seleccion");
            } else {
                // posicion
                listaLigas.remove(index);
                listViewLigas.getSelectionModel().select(-1);
                // seleccionado
                // listaLigas.remove(listViewLigas.getSelectionModel().getSelectedItem());
            }*/
            int index = comboTemporadas.getSelectionModel().getSelectedIndex();
            if (index>-1){
                listaTemporadas.remove(comboTemporadas.getSelectionModel().getSelectedItem());
            }

        }
        else if (event.getSource() == btnAnadir){
            listaTemporadas.add("2021-2022");
            // listaLigas.add("Liga nueva");
        } else if (event.getSource() == btnConsultar){
            System.out.println("Consulta");
            // 1 crear la ventana
            Stage ventanaDetalle = new Stage();
            // 3 asociar a la escena el fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("detail-view.fxml"));
            try {
                Parent parent = loader.load();
                DetalleController detalleController = loader.getController();
                detalleController.getEquipo(listViewClasificacion.getSelectionModel().getSelectedItem());
                // 2 crear la escena
                Scene sceneDetalle = new Scene(parent);
                ventanaDetalle.setScene(sceneDetalle);
                ventanaDetalle.show();
                // 4 acceder a la actual
                Stage actual = (Stage) btnConsultar.getScene().getWindow();
                // 5 quitar actual
                actual.close();
            } catch (IOException e) {
                System.out.println("Error en la carga");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }

        }
    }
}
