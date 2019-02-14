package controladora;

import dialogos.DialogoIntro;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraPerso implements Initializable {

    @FXML
    ListView listaCoches;

    @FXML
    Button bAgregar, bMostrar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bAgregar.setOnAction(new ManejoAcciones());
        bMostrar.setOnAction(new ManejoAcciones());
    }

    class ManejoAcciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource()==bAgregar){
                /*Alert dConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
                dConfirmacion.show();*/

                /*Dialog dialogPerso = new Dialog();
                dialogPerso.setTitle("");
                dialogPerso.setHeaderText("");
                dialogPerso.getDialogPane().getButtonTypes().addAll();
                GridPane p = new GridPane();
                dialogPerso.getDialogPane().setContent(p);*/

                Stage stage = new Stage();
                dialogos.DialogoIntro dialogoIntro = new DialogoIntro();
                try {
                    dialogoIntro.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else if (event.getSource()==bMostrar){

            }
        }
    }
}
