package controller;

import model.Person;
import model.PersonalTask;
import model.Task;
import model.WorkTask;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    private File file;
    private FileWriter fileWriter;
    private BufferedReader bufferedReader;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String basePath = "src/main/java/files/";

    public void exportAll(List<Task> listAll) throws IOException {
        file = new File(basePath + "all.csv");
        if (!file.exists()) {
            file.createNewFile();
        }
        fileWriter = new FileWriter(file);
        fileWriter.write("id,title,level,mail,type");
        for (int i = 0; i < listAll.size() - 1; i++) {
            fileWriter.write(listAll.get(i).toCSV() + "\n");
        }
        fileWriter.write(listAll.getLast().toCSV());

    }

    public void exportByMail(List<Task> listMail, String mail) throws IOException {
        file = new File(basePath + mail + ".csv");
        if (!file.exists()) {
            file.createNewFile();
        }
        fileWriter = new FileWriter(file);
        fileWriter.write("id,title,level,mail,type");
        for (int i = 0; i < listMail.size() - 1; i++) {
            fileWriter.write(listMail.get(i).toCSV() + "\n");
        }
        fileWriter.write(listMail.getLast().toCSV());


    }

    public void exportByMailAll(List<Task> listMail, String mail) throws IOException {
        if (mail == null) {
            file = new File(basePath + "all.csv");
        } else {
            file = new File(basePath + mail + ".csv");
        }

        if (!file.exists()) {
            file.createNewFile();
        }
        fileWriter = new FileWriter(file);
        fileWriter.write("id,title,level,mail,type");
        for (int i = 0; i < listMail.size() - 1; i++) {
            fileWriter.write(listMail.get(i).toCSV() + "\n");
        }
        fileWriter.write(listMail.getLast().toCSV());


    }

    public ArrayList<Task> importTask() {
        ArrayList<Task> list = new ArrayList<>();
        file = new File(basePath + "import.csv");


        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String linea = bufferedReader.readLine();
            Task task = null;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] data = linea.split(",");
                if (data[4].equalsIgnoreCase("personal")) {
                    task = new PersonalTask(data[1],Integer.valueOf(data[2]),
                            new Person(null, null,data[3], null), null);
                } else {
                    task = new WorkTask(data[1],Integer.valueOf(data[2]),
                            new Person(null, null,data[3], null), null);
                }
                list.add(task);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return list;
    }

    public void exportObjectTask(ArrayList<Task> tasks){
        file = new File(basePath+"data.obj");
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(tasks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Task> importObjectTask(){
        ArrayList<Task> list = new ArrayList();

        file = new File(basePath+"data.obj");
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            list = (ArrayList<Task>) ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassCastException e){
            System.out.println("Clases incompatibles");
        }

        finally {
            try {
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return list;
    }
}
