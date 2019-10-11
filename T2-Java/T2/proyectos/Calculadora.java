import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {

    Container container;
    JButton b1, b2, b3, b4, bSuma, bResta, bIgual;
    JTextField pantalla;
    JPanel superior, central, centralCientifica;
    boolean operando = false;
    int op1, op2;
    int tipoOperacion;

    public void initGUI() {


        instancias();
        configurarContainer();
        setSize(new Dimension(300, 200));
        setLocationRelativeTo(null);
        acciones();
        setVisible(true);

    }

    private void configurarContainer() {
        container.add(configurarSuperior(), BorderLayout.NORTH);
        container.add(configurarCentro(), BorderLayout.CENTER);
    }

    private JPanel configurarCentro() {
        central.setLayout(new GridLayout(4, 2, 10, 10));
        central.add(b1);
        central.add(b2);
        central.add(b3);
        central.add(b4);
        central.add(bSuma);
        central.add(bResta);
        central.add(bIgual);

        return central;
    }

    private JPanel configurarSuperior() {
        superior.setLayout(new BorderLayout());
        superior.add(pantalla, BorderLayout.CENTER);
        return superior;
    }

    private void acciones() {
        Component[] componentes = central.getComponents();
        for (Component item : componentes) {

            ((JButton) item).addActionListener(this);
        }
    }

    private void instancias() {
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        bSuma = new JButton("+");
        bResta = new JButton("-");
        bIgual = new JButton("=");
        pantalla = new JTextField();
        container = this.getContentPane();
        central = new JPanel();
        superior = new JPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "1");
            }
            else
                pantalla.setText("1");

        } else if (e.getSource() == b2) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "2");
            }
            else
                pantalla.setText("2");
        } else if (e.getSource() == b3) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "3");
            }
            else
                pantalla.setText("3");
        } else if (e.getSource() == b4) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "4");
            }
            else{
                pantalla.setText("4");
                operando=false;
            }
        } else if (e.getSource() == bSuma) {
            operando = true;
            op1 = Integer.valueOf(pantalla.getText());
            tipoOperacion = 1;
        } else if (e.getSource() == bResta) {
            operando = true;
            op1 = Integer.valueOf(pantalla.getText());
            tipoOperacion = 2;
            
        } else if (e.getSource() == bIgual) {
            op2 = Integer.valueOf(pantalla.getText());
            int resultado=0;
            switch (tipoOperacion){
                case 1:
                    resultado = op1+op2;
                    break;
                case 2:
                    resultado = op1-op2;
                    break;

            }

            pantalla.setText(Integer.toString(resultado));
        }
    }
}
