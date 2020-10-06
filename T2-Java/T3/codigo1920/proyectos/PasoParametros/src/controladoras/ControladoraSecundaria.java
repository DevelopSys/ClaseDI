package controladoras;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControladoraSecundaria implements Initializable {

    @FXML
    Label labelRecibir;

    @Override
    public void initialize(URL location, ResourceBundle resources) {




    }

    public void comunicarParametros(ArrayList<String> list){
        System.out.println(list.size());
        for (String elemento:list) {
            labelRecibir.setText(labelRecibir.getText()+" "+elemento);
        }

    }
}
