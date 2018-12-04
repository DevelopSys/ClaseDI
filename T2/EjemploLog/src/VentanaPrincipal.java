import utils.Persona;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class VentanaPrincipal extends JFrame{

    private JPanel root;
    private JButton loginButton;
    private JButton registrarButton;
    Hashtable<char[], Persona> listaPersonas;

    public VentanaPrincipal() throws HeadlessException {

        listaPersonas = new Hashtable<>();
        setContentPane(root);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();

    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegistrarButton() {
        return registrarButton;
    }

    public void registrarUsuarios(Persona p){
        if (!listaPersonas.containsKey(p.getPass())){
            //TODO registro
        }
        else {
            //TODO aviso ya existe
            JOptionPane.showMessageDialog(this,"Usuario ya existe","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void comprobarUsuario(String nombre, char[] pass ){
        if (listaPersonas.containsKey(pass)){

        }
        else {
            JOptionPane.showMessageDialog(this,"Usuario no encontrado","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
