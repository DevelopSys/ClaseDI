package paneles;

import utils.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelRegistro extends JPanel {

    JSpinner nDI, nPmdm, nAd, nPsp;
    SpinnerNumberModel mDi, mPmdm, mAd, mPsp;
    JTextField tNombre, tDNI;

    public PanelRegistro() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarPanel();
        acciones();


    }

    private void configurarPanel() {
        this.setLayout(new GridLayout(6, 2));
        this.add(new JLabel("Nombre"));
        this.add(tNombre);
        this.add(new JLabel("DNI"));
        this.add(tDNI);
        this.add(new JLabel("Nota DI"));
        this.add(nDI);
        this.add(new JLabel("Nota PMDM"));
        this.add(nPmdm);
        this.add(new JLabel("Nota PSP"));
        this.add(nPsp);
        this.add(new JLabel("Nota AD"));
        this.add(nAd);
    }

    public SpinnerNumberModel getmDi() {
        return mDi;
    }

    public SpinnerNumberModel getmPmdm() {
        return mPmdm;
    }

    public SpinnerNumberModel getmAd() {
        return mAd;
    }

    public SpinnerNumberModel getmPsp() {
        return mPsp;
    }

    public JTextField gettNombre() {
        return tNombre;
    }

    public JTextField gettDNI() {
        return tDNI;
    }

    public Persona devolverPersona() {
        Persona p = new Persona(tNombre.getText(), tDNI.getText(), Integer.valueOf(mDi.getValue().toString()),
                Integer.valueOf(mPmdm.getValue().toString()), Integer.valueOf(mPsp.getValue().toString()),
                Integer.valueOf(mAd.getValue().toString()));
        vaciarCampos();
        return p;
    }

    private void vaciarCampos() {
        mDi.setValue(0);
        mPmdm.setValue(0);
        mPsp.setValue(0);
        mAd.setValue(0);
        tNombre.setText("");
        tDNI.setText("");
    }

    private void acciones() {
        tNombre.addKeyListener(new ManejoTeclas());
        tDNI.addKeyListener(new ManejoTeclas());
    }

    private void instancias() {
        mDi = new SpinnerNumberModel(0, 0, 10, 1);
        nDI = new JSpinner(mDi);
        mPmdm = new SpinnerNumberModel(0, 0, 10, 1);
        nPmdm = new JSpinner(mPmdm);
        mAd = new SpinnerNumberModel(0, 0, 10, 1);
        nAd = new JSpinner(mAd);
        mPsp = new SpinnerNumberModel(0, 0, 10, 1);
        nPsp = new JSpinner(mPsp);
        tNombre = new JTextField();
        tDNI = new JTextField();
    }

    class ManejoTeclas extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            char caracter = e.getKeyChar();
            if (e.getSource() == tNombre) {
                if (Character.isDigit(caracter)) {
                    e.consume();
                }
            } else if (e.getSource() == tDNI) {
                if (tDNI.getText().length() > 10) {
                    e.consume();
                }
            }
        }
    }
}
