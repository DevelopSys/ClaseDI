import javax.swing.*;
import java.awt.event.*;

public class DialogoGrafico extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private VentanaDialogos v;
    private JLabel textField;

    public DialogoGrafico(String s, VentanaDialogos v, JLabel t) {
        this.v = v;
        this.textField = t;
        setContentPane(contentPane);
        setModal(true);
        setTitle(s);
        getRootPane().setDefaultButton(buttonCancel);
        pack();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

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
    }

    private void onOK() {
        // add your code here
        //v.getLabelPerso().setText("Contestacion");
        textField.setText("contestacion");
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
