package controladoras;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ventanas.VentanaSecundaria;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControladoraInicial implements Initializable {

    @FXML
    Button botonParametros;
    @FXML
    MenuItem menuItemUno, menuItemDos;
    @FXML
    BorderPane borderGeneral;

    @FXML Button botonP2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<String> lista = new ArrayList();
        lista.add("Parametro uno");
        lista.add("Parametro dos");
        lista.add("Parametro tres");

        botonParametros.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Scene scene = botonParametros.getScene();
                Stage stage = (Stage) scene.getWindow();

                VentanaSecundaria ventanaSecundaria = new VentanaSecundaria(lista);
                stage.close();


            }
        });
        menuItemDos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource( "../layouts/parte_dos.fxml"));
                loader.setController(this);

                try {
                    borderGeneral.setCenter(loader.load());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        menuItemUno.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource( "../layouts/parte_uno.fxml"));
                //loader.setController(this);

                try {
                    borderGeneral.setCenter(loader.load());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
