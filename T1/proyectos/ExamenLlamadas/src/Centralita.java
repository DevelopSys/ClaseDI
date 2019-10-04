import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Centralita {

    ArrayList<Llamada> listaLlamadas;
    double acumuladorCoste;

    public Centralita() {
        this.listaLlamadas = new ArrayList();
    }

    public void registarLlamada(Llamada llamada){
        listaLlamadas.add(llamada);
    }

    public void calcularCostes(){
        for (Llamada item : listaLlamadas) {
            acumuladorCoste += item.getCoste();
        }

        System.out.printf("El coste acululado es: %.2f %n",acumuladorCoste);
    }

    public void mostrarDatos(){
        for (Llamada item: listaLlamadas) {
            item.mostrarDatos();
        }
    }

    public void exportarDatos(){
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutput;
        File f = new File("src/documentos/llamadas.obj");
        try {
            fileOutput = new FileOutputStream(f);
            objectOutputStream = new ObjectOutputStream(fileOutput);
            objectOutputStream.writeObject(listaLlamadas);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e){
                e.printStackTrace();
            }
        }
    }
}
