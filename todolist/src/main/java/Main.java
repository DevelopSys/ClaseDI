import controller.TaskController;
import model.Person;
import model.PersonalTask;
import model.Task;
import model.WorkTask;

import java.io.*;

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
        }*/
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Person person = (Person) ois.readObject();
            System.out.println(person.getName());
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
        }

        // importacion y exportacion de todas las tareas en modo objeto
        // al finalizar el programa, se exportan a un obj
        // al iniciar el programa se cargan todas las tareas del obj

    }


}
