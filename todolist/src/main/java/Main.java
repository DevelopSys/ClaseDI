import controller.TaskController;
import model.Person;
import model.PersonalTask;
import model.Task;
import model.WorkTask;

public class Main {

    public static void main(String[] args) {

        TaskController controller = new TaskController();

        if(controller.addTask(new WorkTask("fallo", 3,
                new Person("Borja", "Martin", "correo@gmail.com", "123"),
                "Julio"))){
            System.out.println("Tarea agregada correctamente");
        } else {
            System.out.println("Fallo en agregar");
        }

        // Tenemos dos tipos de tareas
        // tarea personal -> ubicacion
        // tarea de trabajo -> fecha de expiracion


    }


}
