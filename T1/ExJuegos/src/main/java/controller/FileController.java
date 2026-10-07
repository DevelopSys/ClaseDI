package controller;

import model.Juego;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileController {

    File file;
    PrintWriter printWriter;

    public void exportCSV(List<Juego> carrito){
        file = new File("src/main/java/resources/carrito.csv");
        printWriter = null;

        try {
            printWriter = new PrintWriter(new FileWriter(file));
            printWriter.println("id, titulo, desarrollador, clasificacion");
            for (int i = 0; i < carrito.size()-1; i++) {
                printWriter.println(carrito.get(i).toCSV());
            }
            printWriter.print(carrito.getLast().toCSV());

        } catch (IOException e) {
            System.out.println("error en la ruta del fichero");
        } finally {
            printWriter.close();
        }

    }
}
