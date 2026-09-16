import java.io.*;

public class MainFile {

    public static void main(String[] args) {
        File file = new File("src/main/java/files/task.txt");
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        try {
            file.createNewFile();
            fileWriter = new FileWriter(file);
            fileWriter.write("Tareas");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(file.getAbsolutePath());
    }
}
