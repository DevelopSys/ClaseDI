import utils.Persona;

import javax.swing.*;
import java.awt.event.*;

public class DialogoRegistrar extends JDialog implements ActionListener {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textoNombre;
    private JTextField textoApellido;
    private JTextField textoEdad;
    private JTextField textoCorreo;
    private JPasswordField textoPass;
    private VentanaPrincipal ventanaPrincipal;

    public DialogoRegistrar(VentanaPrincipal ventanaPrincipal)  {
        this.ventanaPrincipal = ventanaPrincipal;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(this);
        buttonCancel.addActionListener(this);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        pack();
    }

    private void onOK() {
        // add your code here
        ventanaPrincipal.registrarUsuarios(new Persona(textoNombre.getText().toString()
                ,textoApellido.getText().toString()
                ,textoCorreo.getText().toString()
                ,textoPass.getPassword(),
                Integer.valueOf(textoEdad.getText().toString())));
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonOK){
           onOK();
        }
        else if (e.getSource() == buttonCancel){
          onCancel();
        }
    }
}
