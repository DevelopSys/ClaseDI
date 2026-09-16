import java.io.File;

public class MainFile {

    public static void main(String[] args) {
        File file = new File("src/main/java/files/other/test");
        file.createNewFile();

        System.out.println(file.getAbsolutePath());
    }
}
