import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Entrada {

    public static void main(String[] args) throws IOException, JSONException {

        /*String linkUrl = "https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=en-US&page=1";
        URL url = new URL(linkUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        BufferedReader lector = new BufferedReader
                (new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String linea;
        while ((linea=lector.readLine())!=null){
            builder.append(linea);
        }

        JSONObject jsonObject = new JSONObject(builder.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object = (JSONObject) jsonArray.get(i);
            Gson gson = new Gson();
            Pelicula pelicula = gson.fromJson(object.toString(),Pelicula.class);
            System.out.println(pelicula.getOriginal_title());
        }*/

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana v = new Ventana();
            }
        });

    }
}
