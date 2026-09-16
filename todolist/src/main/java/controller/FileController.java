package controller;

import model.Task;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileController {
    private File file;
    private FileWriter fileWriter;
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
}
