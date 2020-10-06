package ventanas;

import controladoras.ControladoraSecundaria;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class VentanaSecundaria extends Stage {

    private ArrayList lista;
    private ControladoraSecundaria controladoraSecundaria;

    public VentanaSecundaria(ArrayList list) {
        this.lista = list;
        initGUI();

    }

    private void initGUI() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../layouts/ventana_secundaria.fxml"));

        Parent root = null;
        try {
             root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        controladoraSecundaria = loader.getController();
        controladoraSecundaria.comunicarParametros(lista);
        Scene scene = new Scene(root,300,300);
        this.setScene(scene);
        this.show();
    }
}
