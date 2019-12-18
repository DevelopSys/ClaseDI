import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Ventana extends JFrame {

    Container container;
    JList lista;
    DefaultListModel modeloLista;
    JButton boton;
    JLabel poster;

    public Ventana() throws HeadlessException {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarContainer();
        acciones();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    private void acciones() {
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeloLista.clear();
                new MiWorker().execute();
            }
        });
        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Pelicula seleccionada = (Pelicula) modeloLista.getElementAt(lista.getSelectedIndex());
                // https://image.tmdb.org/t/p/w500/
                String link = String.format("%s%s","https://image.tmdb.org/t/p/w500",seleccionada.getPoster_path());
                //System.out.println(link);
                URL urlImagen;
                try {
                    urlImagen = new URL(link);
                    BufferedImage imagenInternet = ImageIO.read(urlImagen);
                    poster.setIcon(new ImageIcon(imagenInternet));
                    pack();
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void configurarContainer() {
        container.add(configurarCentro(), BorderLayout.CENTER);
        container.add(boton, BorderLayout.SOUTH);
    }

    private JPanel configurarCentro() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(new JScrollPane(lista));
        panel.add(poster);
        return panel;
    }

    private void instancias() {
        container = getContentPane();
        poster = new JLabel();
        boton = new JButton("Cargar datos");
        modeloLista = new DefaultListModel();
        lista = new JList(modeloLista);
    }

    class MiWorker extends SwingWorker<Boolean, Void> {

        URL url;
        HttpURLConnection connection;
        BufferedReader lector;
        StringBuilder builder = new StringBuilder();

        @Override
        protected Boolean doInBackground() throws Exception {

            // TODO para leer la url
            System.out.println("ejecutado");

            try {
                url = new URL("https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=en-US&page=1");
                connection = (HttpURLConnection) url.openConnection();
                lector = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String linea;
            while ((linea = lector.readLine())!=null){
                builder.append(linea);
            }


            JSONObject jsonEntero = new JSONObject(builder.toString());
            JSONArray jsonArrayResultados = jsonEntero.getJSONArray("results");
            for (int i=0;i<jsonArrayResultados.length();i++){
                if (i==0){
                    boton.setEnabled(false);
                } else if (i==jsonArrayResultados.length()-1){
                    boton.setEnabled(true);
                }
                JSONObject objeto = jsonArrayResultados.getJSONObject(i);
                Gson gson = new Gson();
                Pelicula pelicula = gson.fromJson(objeto.toString(),Pelicula.class);
                modeloLista.addElement(pelicula);
                Thread.sleep(100);
            }



            return true;
        }
    }
}
