package paneles;

import componentes.TextoPerso;
import utils.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PestaniaCinco extends JPanel implements ActionListener {

    JSpinner spinnerNumeros, spinnerLista, spinnerEdad;
    SpinnerNumberModel modeloSpinnerNumeros;
    SpinnerListModel modeloSpinnerLista;
    ArrayList datosSpinner;
    JTextField tNombre, tApellido, tNumero;
    JCheckBox cDisponible;
    JPanel pSuperior, pCentro;
    JButton bAgregar;


    public PestaniaCinco() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarSpinnerList();
        configurarPanel();
        acciones();
    }

    private void acciones() {
        tNumero.addKeyListener(new ManejoTeclas());
        bAgregar.addActionListener(this);
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configurarSuperior(),BorderLayout.NORTH);
        this.add(configurarCentro(), BorderLayout.CENTER);
    }

    private JPanel configurarCentro() {
        pCentro.setLayout(new GridBagLayout());
        // Fila 0
        configurarGridBag(0,0,1,1,0,0.2,
                GridBagConstraints.WEST,GridBagConstraints.NONE,
                new JLabel("Nombre"));
        configurarGridBag(1,0,1,1,1,0.2,
                GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,
                tNombre);

        // Fila 1

        configurarGridBag(0,1,1,1,0,0.2,
                GridBagConstraints.WEST,GridBagConstraints.NONE,
                new JLabel("Apellido"));
        configurarGridBag(1,1,1,1,1,0.2,
                GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,
                tApellido);


        // Fila 2 Nueva

        configurarGridBag(0,2,1,1,0,0.2,
                GridBagConstraints.WEST,GridBagConstraints.NONE,
                new JLabel("Edad"));
        configurarGridBag(1,2,1,1,1,0.2,
                GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,
                spinnerEdad);


        // Fila 2

        configurarGridBag(0,3,1,1,0,0.2,
                GridBagConstraints.WEST,GridBagConstraints.NONE,
                new JLabel("Teléfono"));
        configurarGridBag(1,3,1,1,1,0.2,
                GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,
                tNumero);

        // Fila 3

        configurarGridBag(0,4,1,1,0,0.2,
                GridBagConstraints.WEST,GridBagConstraints.NONE,
                new JLabel("Disponibilidad"));
        configurarGridBag(1,4,1,1,1,0.2,
                GridBagConstraints.WEST,GridBagConstraints.NONE,
                cDisponible);

        // Fila 4

        configurarGridBag(0,5,2,1,0,0.2,
                GridBagConstraints.CENTER,GridBagConstraints.NONE,
                bAgregar);

        return pCentro;
    }

    private void configurarGridBag(int pX, int pY, int tX, int tY,
                                   double peX, double peY, int anc,
                                   int fill, JComponent component){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = pX;
        constraints.gridy = pY;
        constraints.gridwidth = tX;
        constraints.gridheight = tY;
        constraints.weightx = peX;
        constraints.weighty = peY;
        constraints.fill = fill;
        constraints.anchor = anc;
        pCentro.add(component,constraints);
    }

    private JPanel configurarSuperior() {
        pSuperior.add(spinnerNumeros);
        pSuperior.add(spinnerLista);
        return pSuperior;
    }

    public void configurarSpinnerList(){
        datosSpinner.add("Nombre1");
        datosSpinner.add("Nombre2");
        datosSpinner.add("Nombre3");
        datosSpinner.add("Nombre4");
        modeloSpinnerLista.setList(datosSpinner);
    }

    private void instancias() {
        modeloSpinnerNumeros = new SpinnerNumberModel(18,18,99,1);
        modeloSpinnerLista = new SpinnerListModel();
        spinnerNumeros = new JSpinner(modeloSpinnerNumeros);
        spinnerLista = new JSpinner(modeloSpinnerLista);
        spinnerEdad = new JSpinner(modeloSpinnerNumeros);
        datosSpinner = new ArrayList();
        tNombre = new JTextField();
        tApellido = new JTextField();
        tNumero = new JTextField();
        cDisponible = new JCheckBox();
        bAgregar = new JButton("Agregar persona");
        pCentro = new JPanel();
        pSuperior = new JPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bAgregar){
            if (tNumero.getText().isEmpty()||tApellido.getText().isEmpty() || tNumero.getText().isEmpty()){
                System.out.println("Faltan datos");
            } else {

                System.out.println(spinnerEdad.getModel().getValue());
                String nombre = tNombre.getText();
                String apellido = tApellido.getText();
                int telefono = Integer.valueOf(tNumero.getText());
                boolean disponibilidad = cDisponible.isSelected();
                Persona persona = new Persona(nombre,apellido,telefono,disponibilidad);
                datosSpinner.add(persona);
            }
        }

    }

    class ManejoTeclas extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            char tecla = e.getKeyChar();
            if (!Character.isDigit(tecla)){
                e.consume();
            } else if (tNumero.getText().length()>9){
                e.consume();
            }
        }
    }


}
