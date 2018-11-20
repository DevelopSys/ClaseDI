import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladoraVentana implements ActionListener {

    Ventana ventana;

    public ControladoraVentana(Ventana ventana) {
        this.ventana = ventana;
        acciones();
    }

    private void acciones() {

        ventana.getBotonPUno().addActionListener(this);
        ventana.getBotonPDos().addActionListener(this);
        ventana.getPanel1().getBoton().addActionListener(this);
    }

    // o en el constructor
    public void setControladora(Ventana ventana){
        this.ventana = ventana;
    }


    @Override
    public void actionPerformed(ActionEvent e) {



        if (e.getSource() == ventana.getBotonPUno()){
            ventana.getCardLayout().show(ventana.getpCentro(),Ventana.tag_uno);
        }else if(e.getSource() == ventana.getBotonPDos()){
            ventana.getCardLayout().show(ventana.getpCentro(),Ventana.tag_dos);
        } else if (e.getSource() == ventana.getPanel1().getBoton()){
            String texto = ventana.getPanel1().getNombre().getText();
            //ventana.getPanel2().getEtiqueta().setText(texto);
            //ventana.getCardLayout().show(ventana.getpCentro(),Ventana.tag_dos);
            Ventana2 v = new Ventana2(texto);
        }
    }
}
