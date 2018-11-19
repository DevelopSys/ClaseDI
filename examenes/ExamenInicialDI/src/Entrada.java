import javax.swing.*;
import java.lang.invoke.SwitchPoint;

public class Entrada {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana v = new Ventana();
            }
        });
    }
}
