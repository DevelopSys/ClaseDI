package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sample.utils.Equipo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class VentanaPrincipal implements Initializable {

    String peticionAPI = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=Spain";
    ObservableList<Equipo> listaEquipos;
    @FXML
    ListView<Equipo> listView;
    @FXML
    ImageView imagen;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listaEquipos = FXCollections.observableArrayList();
        listView.setItems(listaEquipos);

        try {
            URL urlAPI = new URL(peticionAPI);
            HttpURLConnection http = (HttpURLConnection) urlAPI.openConnection();
            //System.out.println(http.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            String datos = bufferedReader.readLine();
            JSONObject jsonObject = new JSONObject(datos);
            //System.out.println(jsonObject);
            JSONArray arrayEquipos = jsonObject.getJSONArray("teams");
            //System.out.println(arrayEquipos);

            for (int i = 0; i < arrayEquipos.length(); i++) {
                JSONObject object = arrayEquipos.getJSONObject(i);
                String nombre = object.getString("strTeam");
                String anio = object.getString("intFormedYear");
                String escudo = object.getString("strTeamBadge");
                Equipo equipo = new Equipo(nombre,anio,escudo);
                //System.out.println(nombre);
                listaEquipos.addAll(equipo);
            }






        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        acciones();

    }

    private void acciones() {
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Equipo>() {
            @Override
            public void changed(ObservableValue<? extends Equipo> observableValue, Equipo equipo, Equipo t1) {
                //System.out.println(t1.getNombre());
                imagen.setImage(new Image(t1.getEscudo()));

            }
        });
    }

}
