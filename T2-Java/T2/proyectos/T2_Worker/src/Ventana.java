import sun.jvm.hotspot.code.PCDesc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Ventana extends JFrame {

    JButton boton1, boton2;
    JProgressBar barra;
    Container container;
    JPanel pCentro;
    Ventana ventana;

    public Ventana() throws HeadlessException {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarPanel();
        acciones();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void acciones() {
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*for (int i=0;i<101;i++){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    barra.setValue(i);
                }*/
                System.out.println("Boton");
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MiWorker worker = new MiWorker();
                worker.execute();
            }
        });
    }

    private void configurarPanel() {
        pCentro.add(boton1);
        pCentro.add(boton2);
        container.add(pCentro,BorderLayout.CENTER);
        container.add(barra,BorderLayout.SOUTH);
        barra.setStringPainted(true);
        barra.setMinimum(0);
        barra.setMaximum(100);

    }

    private void instancias() {
        ventana = this;
        boton1 = new JButton("Normal");
        boton2 = new JButton("Worker");
        barra = new JProgressBar();
        pCentro = new JPanel();
        container = getContentPane();
    }

    class MiWorker extends SwingWorker<Boolean,Integer>{

        @Override
        protected Boolean doInBackground() throws Exception {

            for(int i=0;i<101;i++){
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
            JOptionPane.showMessageDialog(ventana,"Tarea completada","Realizada",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
