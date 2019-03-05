package controladora;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import utils.Equipo;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContoladoraMain implements Initializable {

    @FXML
    ListView lista;
    @FXML
    Label descripcion;

    @FXML
    ImageView imagen;

    ObservableList<Equipo> listaEquipos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        instancias();
        try {
            realizarPeticion();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        lista.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Equipo equipo = (Equipo) newValue;
                URL url = null;
                try {
                    url = new URL(equipo.getUrl());
                    BufferedImage imageURL = ImageIO.read(url);
                    Image image = SwingFXUtils.toFXImage(imageURL,null);
                    imagen.setImage(image);
                    descripcion.setText(equipo.getDescripcion());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    private void instancias() {
        listaEquipos = FXCollections.observableArrayList();
        lista.setItems(listaEquipos);
    }


    public void realizarPeticion() throws IOException, JSONException {
        JSONArray array = null;

        String url = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=Spain";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println(myResponse.toString());
        JSONArray array1 = myResponse.getJSONArray("teams");
        for (int i = 0; i<array1.length();i++){

            JSONObject object = (JSONObject) array1.get(i);
            String nombre = (String) object.get("strTeam");
            String estadio = (String) object.get("strStadium");
            String description = (String) object.get("strDescriptionES").toString();
            String imagen = (String) object.get("strTeamBadge").toString();
            Equipo e = new Equipo(nombre,estadio,description,imagen);
            listaEquipos.add(e);

        }
        //array = myResponse.getJSONArray("results");
        //return array;
    }
}
