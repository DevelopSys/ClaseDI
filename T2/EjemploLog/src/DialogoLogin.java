import utils.Persona;

import javax.swing.*;
import java.awt.event.*;

public class DialogoLogin extends JDialog implements ActionListener {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nombreDialogoLog;
    private JPasswordField passDialogoLog;
    private  VentanaPrincipal ventanaPrincipal;

    public DialogoLogin(VentanaPrincipal principal) {
        setContentPane(contentPane);
        this.ventanaPrincipal = principal;
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
        if (nombreDialogoLog.getText().isEmpty() || passDialogoLog.getPassword().length>0){
           ventanaPrincipal.comprobarUsuario(nombreDialogoLog.getText(),passDialogoLog.getPassword());
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonOK){
            onOK();
        }else if (e.getSource()==buttonCancel){
            onCancel();
        }
    }
}
