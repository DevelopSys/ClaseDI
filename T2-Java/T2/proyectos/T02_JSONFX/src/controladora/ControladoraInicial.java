package controladora;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraInicial implements Initializable {

    @FXML
    ImageView imagen_ejemplo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        String urlJson = "https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=en-US&page=1";
        try {
            URL url = new URL(urlJson);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            // System.out.printf(http.toString());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(http.getInputStream()));
            String lecturaJson = in.readLine();

            // si los datos vienen de varias fuentes
            /*String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }*/
            in.close();
            //lecturaJson = lecturaJson.toString();
            JSONObject jsonOriginal = new JSONObject(lecturaJson);
            //System.out.println(jsonOriginal);
            JSONArray jsonArrayGeneral = jsonOriginal.getJSONArray("results");
            //System.out.println(jsonArrayGeneral);
            //JSONObject jsonObjectPrimero = (JSONObject) jsonArrayGeneral.get(0);
            //System.out.println(jsonObjectPrimero);
            //String titulo = jsonObjectPrimero.getString("original_title");
            //System.out.println(titulo);

            for (int i =0;i<jsonArrayGeneral.length();i++){
                JSONObject jsonObject = jsonArrayGeneral.getJSONObject(i);
                String titulo = jsonObject.getString("original_title");
                System.out.println(titulo);

            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
