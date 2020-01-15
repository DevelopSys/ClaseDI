package ventanas;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaUno extends Stage {

    public VentanaUno() {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../layouts/layout_ventana_uno.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root,600,400);
        this.setScene(scene);
        this.show();
    }

}
