import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelPrimos extends JPanel {

    JProgressBar barra;
    JButton bCalcular;
    JTextArea tAPrimos;
    JTextField tTPrimos;
    PanelPrimos panelPrimos;

    public PanelPrimos() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }

    private void acciones() {
        bCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*WorkerPropio workerPropio = new WorkerPropio();
                workerPropio.execute();*/
                MiWorker worker = new MiWorker(panelPrimos);
                worker.execute();
            }
        });
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public JTextArea gettAPrimos() {
        return tAPrimos;
    }

    public JTextField gettTPrimos() {
        return tTPrimos;
    }

    private void configurarPanel() {
        this.setBorder(BorderFactory.createTitledBorder("Calcular primos"));
        this.setLayout(new BorderLayout());
        this.add(configurarSuperior(), BorderLayout.NORTH);
        this.add(new JScrollPane(tAPrimos), BorderLayout.CENTER);
        this.add(barra, BorderLayout.SOUTH);
        barra.setStringPainted(true);
        tAPrimos.setEnabled(false);
    }

    private JPanel configurarSuperior() {

        JPanel pSuperior = new JPanel();
        pSuperior.setLayout(new GridBagLayout());
        pSuperior.add(new JLabel("Cuantos primos quieres calcular"),
                configurarConstraint(0, 0, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        pSuperior.add(tTPrimos,
                configurarConstraint(1, 0, 1, 1, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        pSuperior.add(bCalcular,
                configurarConstraint(0, 1, 2, 1, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        return pSuperior;

    }


    public GridBagConstraints configurarConstraint(int x, int y, int w, int h, double wx, double wy, int fill, int a) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        constraints.weightx = wx;
        constraints.weighty = wy;
        constraints.fill = fill;
        constraints.anchor = a;
        return constraints;
    }

    private void instancias() {
        barra = new JProgressBar();
        bCalcular = new JButton("Calcular");
        tAPrimos = new JTextArea();
        tTPrimos = new JTextField(10);
        panelPrimos = this;
    }

    /*class WorkerPropio extends SwingWorker<Boolean, Integer> {

        @Override
        protected Boolean doInBackground() throws Exception {

            for (int i = 0; i < 101; i++) {
                publish(i);
                Thread.sleep(100);
            }
            return true;
        }

        @Override
        protected void process(List<Integer> chunks) {
            super.process(chunks);
            barra.setValue(chunks.get(0));
        }

        @Override
        protected void done() {
            super.done();
            JOptionPane.showMessageDialog(panelPrimos,"Mensaje");

        }
    }*/

}















