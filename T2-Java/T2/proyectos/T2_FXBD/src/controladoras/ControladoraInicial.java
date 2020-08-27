package controladoras;

import basedatos.Conexion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class ControladoraInicial implements Initializable {

    @FXML
    private MenuItem menu_agregar, menu_eliminar, menu_consultar, menu_conectar,menu_actualizar ;

    @FXML
    private BorderPane border;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        menu_actualizar.setOnAction(new ManejoPulsaciones());
        menu_agregar.setOnAction(new ManejoPulsaciones());
        menu_conectar.setOnAction(new ManejoPulsaciones());
        menu_eliminar.setOnAction(new ManejoPulsaciones());
        menu_consultar.setOnAction(new ManejoPulsaciones());

    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
          if (event.getSource() == menu_agregar){

                FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("../layouts/agregar.fxml"));

                try {
                    border.setCenter(loader.load());

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if (event.getSource() == menu_eliminar){

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../layouts/eliminar.fxml"));
                try {
                    border.setCenter(loader.load());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if (event.getSource() == menu_actualizar){

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../layouts/actualizar.fxml"));
                try {
                    border.setCenter(loader.load());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else if (event.getSource() == menu_consultar){

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../layouts/consultar.fxml"));
                try {
                    border.setCenter(loader.load());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
