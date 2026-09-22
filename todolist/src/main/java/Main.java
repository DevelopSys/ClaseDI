import controller.TaskController;
import model.Person;
import model.PersonalTask;
import model.Task;
import model.WorkTask;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {

        /*
        TaskController controller = new TaskController();

        if(controller.addTask(new WorkTask("fallo", 3,
                new Person("Borja", "Martin", "correo@gmail.com", "123"),
                "Julio"))){
            System.out.println("Tarea agregada correctamente");
        } else {
            System.out.println("Fallo en agregar");
        }*/

        // Tenemos dos tipos de tareas
        // tarea personal -> ubicacion
        // tarea de trabajo -> fecha de expiracion

        File file = new File("src/main/java/files/data.obj");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        /*try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(new Person("Name", "Surname", "email@example.com", "123"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Object o = null;
            while ((o = ois.readObject())!= null){
                Person person = (Person) o;
                System.out.println(person.getName());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error en la codificacion de la clase");
        } catch (ClassCastException e){
            System.out.println("Los tipos son incompatibles");
        }
        finally {
            try {
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }*/

        // importacion y exportacion de todas las tareas en modo objeto
        // al finalizar el programa, se exportan a un obj
        // al iniciar el programa se cargan todas las tareas del obj

        String url = "https://dummyjson.com/posts";
        // "navegador"
        HttpClient client = HttpClient.newHttpClient();
        // peticion - metodo, url
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        // respuesta - cliente + request -> body
        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body().toString();
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONArray jsonArray = jsonObject.getJSONArray("posts");
            Gson gson = new Gson();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonPost = jsonArray.getJSONObject(i);
                String title = jsonPost.getString("title");
                System.out.println(title);
                // clase post con los datos identicos a los nombre de las KEYs
                if (jsonPost.keySet().contains("locate")) {
                    Post post = gson.fromJSON(jsonPost.toString(), PersonalTask.class);

                } else {
                    Post post = gson.fromJSON(jsonPost.toString(), WorkTask.class);
                }
            }

            // 1. IMPORTAR TODAS LAS TARDEAS DEL JSON EN LA LISTA
            // 2. DESDE EL JSON OBTENER TODAS LAS TAREAS CON LEVEL ALTA

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
