package controller;

import model.Task;

import java.io.IOException;
import java.util.ArrayList;

public class TaskController {

    private ArrayList<Task> taskList;
    private FileController fileController;
    private long id;

    public TaskController() {
        taskList = new ArrayList<>();
        fileController = new FileController();
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


    public void listTask() {

        taskList.stream().forEach(Task::showData);
        taskList.stream()
                .filter(task -> task.getPerson().getName().equals("nombre"))
                .toList().forEach(Task::showData);
        taskList.stream()
                .filter(task -> task.getLevel() == 1)
                .toList().forEach(Task::showData);
        taskList.stream()
                .filter(Task::isComplete)
                .toList().forEach(Task::showData);


    }

    public void exportTaskAll() {
        System.out.println("Logica de las tareas a exportar");
        try {
            fileController.exportByMailAll(taskList, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exportTaskByEmail(String mail) {
        System.out.println("Logica de las tareas a exportar");
        System.out.println("Existe algun task con ese email???");
        try {
            fileController.exportByMailAll(
                    taskList.stream().filter(task -> task.getPerson().getEmail().equalsIgnoreCase(mail)).toList()
                    , mail);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void importTask() {
        for (Task task : fileController.importTask()) {
            addTask(task);
        }
    }
}
