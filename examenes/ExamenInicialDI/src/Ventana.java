import javafx.scene.control.Spinner;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class Ventana extends JFrame implements ActionListener, FocusListener {

    Container container;
    JTextField editNombre, editApellido;
    JFormattedTextField editTelefono;
    JLabel apellidoInfo, telefonoInfo, situacionInfo;
    JCheckBox checkTrabajando;
    JPanel panelRegisto, panelInfo, panelCentral;
    JButton botonRegistro, botonInfo, botonRegistrar;
    ButtonGroup grupoSituacion;
    CardLayout cardLayout;
    JSpinner nombre;
    ArrayList personas;
    SpinnerListModel modeloSpinner;

    public Ventana() throws HeadlessException {

        instancias();
        initGUI();
        acciones();
    }

    private void acciones() {
        botonRegistro.addActionListener(this);
        botonInfo.addActionListener(this);
        botonRegistrar.addActionListener(this);

        nombre.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Persona p = (Persona) nombre.getModel().getValue();
                ponerDatos(p);
            }
        });
    }

    public void ponerDatos(Persona persona) {
        apellidoInfo.setText(persona.getApellido());
        telefonoInfo.setText(String.valueOf(persona.getTelefono()));
        situacionInfo.setText(String.valueOf(persona.getSituacion()));
    }

    private void initGUI() {
        configuracionGeneral();
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Examen DI");
    }

    private void configuracionGeneral() {
        container.setLayout(new BorderLayout());
        JPanel pNorte = new JPanel();
        pNorte.add(botonRegistro);
        pNorte.add(botonInfo);
        pNorte.add(botonRegistrar);
        container.add(pNorte, BorderLayout.NORTH);
        container.add(configurarCentral(), BorderLayout.CENTER);

    }

    public JPanel configurarCentral() {

        panelCentral.setBorder(new EmptyBorder(30, 30, 30, 30));
        panelCentral.setLayout(cardLayout);
        panelCentral.add(configurarRegistro(), "registro");
        panelCentral.add(congifurarInfo(), "info");

        return panelCentral;
    }

    public JPanel configurarRegistro() {
        panelRegisto.setLayout(new GridLayout(4, 2));
        panelRegisto.add(new JLabel("Nombre"));
        panelRegisto.add(editNombre);
        panelRegisto.add(new JLabel("Apellido"));
        panelRegisto.add(editApellido);
        panelRegisto.add(new JLabel("Teléfono"));
        panelRegisto.add(editTelefono);
        panelRegisto.add(new JLabel("Situación"));
        panelRegisto.add(checkTrabajando);

        return panelRegisto;
    }

    public JPanel congifurarInfo() {

        panelInfo.setLayout(new GridBagLayout());
        agregarElemento(0, 0, 2, 1, 1, 0.5, GridBagConstraints.CENTER, nombre);
        agregarElemento(0, 1, 1, 1, 1, 0.5, GridBagConstraints.CENTER, new JLabel("Apellido"));
        agregarElemento(1, 1, 1, 1, 1, 0.5, GridBagConstraints.CENTER, apellidoInfo);
        agregarElemento(0, 2, 1, 1, 1, 0.5, GridBagConstraints.CENTER, new JLabel("Teléfono"));
        agregarElemento(1, 2, 1, 1, 1, 0.5, GridBagConstraints.CENTER, telefonoInfo);
        agregarElemento(0, 3, 1, 1, 1, 0.5, GridBagConstraints.CENTER, new JLabel("Situacion"));
        agregarElemento(1, 3, 1, 1, 1, 0.5, GridBagConstraints.CENTER, situacionInfo);
        return panelInfo;
    }

    public void agregarElemento(int x, int y, int tamx, int tamy, double pesx, double pesy, int posicion, JComponent component) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = tamx;
        constraints.gridheight = tamy;
        constraints.weightx = pesx;
        constraints.weighty = pesy;
        constraints.anchor = posicion;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panelInfo.add(component, constraints);


    }

    private void instancias() {
        container = getContentPane();
        editNombre = new JTextField();
        editApellido = new JTextField();
        editTelefono = new JFormattedTextField();
        apellidoInfo = new JLabel();
        telefonoInfo = new JLabel();
        situacionInfo = new JLabel();
        panelCentral = new JPanel();
        panelRegisto = new JPanel();
        panelInfo = new JPanel();
        botonInfo = new JButton("Información");
        botonRegistro = new JButton("Registro");
        botonRegistrar = new JButton("", new ImageIcon(getClass().getResource("./recursos/registrar.png")));
        botonRegistrar.setBorderPainted(false);
        botonRegistrar.setBackground(null);
        cardLayout = new CardLayout();
        personas = new ArrayList();
        personas.add(new Persona("asd", "asd", true, 234));
        personas.add(new Persona("dfgdfg", "rtyrty", true, 234));
        modeloSpinner = new SpinnerListModel(personas);
        nombre = new JSpinner(modeloSpinner);
        checkTrabajando = new JCheckBox();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonInfo) {
            cardLayout.show(panelCentral, "info");
        } else if (e.getSource() == botonRegistro) {
            cardLayout.show(panelCentral, "registro");
        } else if (e.getSource() == botonRegistrar) {
            if (!(editTelefono.getText().isEmpty() || editNombre.getText().isEmpty() || editTelefono.getText().isEmpty())){
                Persona p = new Persona(editNombre.getText().toString(),editApellido.getText().toString(), checkTrabajando.isSelected(),Integer.valueOf(editTelefono.getText()));
                personas.add(p);
                limpiarDatos();
            }
        }
    }

    public void limpiarDatos(){
        editNombre.setText("");
        editApellido.setText("");
        editTelefono.setValue(0);
        checkTrabajando.setSelected(false);
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
