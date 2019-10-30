import paneles.PestaniaCuatro;
import paneles.PestaniaDos;
import paneles.PestaniaTres;
import paneles.PestaniaUno;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    Container container;
    // panel personalizado
    PestaniaUno pestaniaUno;
    PestaniaDos pestaniaDos;
    PestaniaTres pestaniaTres;
    PestaniaCuatro pestaniaCuatro;
    JTabbedPane panelPestanias;

    public void initGUI(){

        instancias();
        configurarContainer();
        this.setSize(new Dimension(300,300));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //this.pack();
    }

    private void configurarContainer() {
        container.add(panelPestanias);
        panelPestanias.addTab("Botones",pestaniaUno);
        panelPestanias.addTab("Check y radios",pestaniaDos);
        panelPestanias.addTab("Textos",pestaniaTres);
        panelPestanias.addTab("TextosRespaso",pestaniaCuatro);
    }

    private void instancias() {
        container = this.getContentPane();
        panelPestanias = new JTabbedPane(SwingConstants.TOP);
        pestaniaUno = new PestaniaUno();
        pestaniaDos = new PestaniaDos();
        pestaniaTres = new PestaniaTres();
        pestaniaCuatro = new PestaniaCuatro();
    }
}
