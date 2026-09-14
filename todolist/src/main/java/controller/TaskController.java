package controller;

import model.Task;

import java.util.ArrayList;

public class TaskController {

    private ArrayList<Task> taskList;
    private long id;

    public TaskController() {
        taskList = new ArrayList<>();
        // id = 0
    }

    // anadir tarea
    public boolean addTask(Task task) {
        // añadir un tarea
        // añadir un id a cada tarea y que este se autoasigne
        if (task.getTitle().equals("fallo")) {
            return false;
        }
        id++;
        task.setId(id);
        return taskList.add(task);
    }
    // listar tareas
}
