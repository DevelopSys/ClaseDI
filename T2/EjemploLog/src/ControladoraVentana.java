import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladoraVentana implements ActionListener {


    VentanaPrincipal ventanaPrincipal;

    public ControladoraVentana(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        acciones();
    }

    private void acciones() {
        ventanaPrincipal.getLoginButton().addActionListener(this);
        ventanaPrincipal.getRegistrarButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaPrincipal.getLoginButton()){
            DialogoLogin d = new DialogoLogin(ventanaPrincipal);
            d.setVisible(true);
        }else if (e.getSource() == ventanaPrincipal.getRegistrarButton()){
            DialogoRegistrar d = new DialogoRegistrar(ventanaPrincipal);
            d.setVisible(true);
        }
    }
}
