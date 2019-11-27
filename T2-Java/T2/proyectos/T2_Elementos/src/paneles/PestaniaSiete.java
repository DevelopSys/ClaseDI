package paneles;

import utils.Persona;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class PestaniaSiete extends JPanel implements ActionListener, ChangeListener {

    JButton botonNormal, bDialogoInfo, bDialogoWarn, bDialogoError, bDialogoOpciones, bDialogoOpcionesPerso,
            bDialogoEntrada, bDialogoEntradaPersona, bFicheros, bColor;
    JLabel texto;
    JProgressBar barraProgreso;
    int opcion;

    JPopupMenu contextual;
    JMenuItem opcionUno, opcionDos;

    PestaniaSiete pestaniaSiete;


    public PestaniaSiete() {
        initGUI();
        configurarPopUp();
    }

    private void configurarPopUp() {
        contextual.add(opcionUno);
        contextual.add(opcionDos);
        opcionUno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.ALT_MASK));
    }

    public void initGUI() {
        instancias();
        configurarBarra();
        configurarPanel();
        acciones();
    }

    private void configurarBarra() {
        barraProgreso.setMinimum(0);
        barraProgreso.setMaximum(100);
        barraProgreso.setValue(0);
        barraProgreso.setStringPainted(true);
        barraProgreso.setBorderPainted(true);

    }

    private void acciones() {
        botonNormal.addActionListener(this);
        bDialogoInfo.addActionListener(this);
        bDialogoWarn.addActionListener(this);
        bDialogoError.addActionListener(this);
        bDialogoOpciones.addActionListener(this);
        bDialogoOpcionesPerso.addActionListener(this);
        bDialogoEntrada.addActionListener(this);
        bDialogoEntradaPersona.addActionListener(this);
        bFicheros.addActionListener(this);
        bColor.addActionListener(this);
        barraProgreso.addChangeListener(this);
        opcionUno.addActionListener(this);
        this.addMouseListener(new ManejoRaton());


    }

    private void configurarPanel() {
        this.add(botonNormal);
        this.add(barraProgreso);
        this.add(bDialogoInfo);
        this.add(bDialogoWarn);
        this.add(bDialogoError);
        this.add(bDialogoOpciones);
        this.add(bDialogoOpcionesPerso);
        this.add(bDialogoEntrada);
        this.add(bDialogoEntradaPersona);
        this.add(bFicheros);
        this.add(bColor);
        this.add(texto);
    }

    private void instancias() {
        botonNormal = new JButton("Pulsar");
        barraProgreso = new JProgressBar();
        bDialogoError = new JButton("Error");
        bDialogoWarn = new JButton("Aviso");
        bDialogoInfo = new JButton("Info");
        bDialogoOpciones = new JButton("Pregunta");
        bDialogoOpcionesPerso = new JButton("Pregunta perso");
        bDialogoEntrada = new JButton("Entrada");
        bDialogoEntradaPersona = new JButton("Entrada persona");
        bFicheros = new JButton("Ficheros");
        bColor = new JButton("Colores");
        texto = new JLabel("Texto");

        contextual = new JPopupMenu();
        opcionUno = new JMenuItem("Opción 1");
        opcionDos = new JMenuItem("Opción 2");

        pestaniaSiete = this;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonNormal) {
            barraProgreso.setValue(barraProgreso.getValue() + 25);
            if (barraProgreso.getValue() == 100) {
                getToolkit().beep();
            }
        } else if (e.getSource() == bDialogoInfo) {
            JOptionPane.showMessageDialog(PestaniaSiete.this, "ESte es un diálogo de información",
                    "Titulo del mensaje", JOptionPane.INFORMATION_MESSAGE, null);
        } else if (e.getSource() == bDialogoError) {

            JOptionPane.showMessageDialog(PestaniaSiete.this, "ESte es un diálogo de error",
                    "Titulo del mensaje", JOptionPane.ERROR_MESSAGE, null);

        } else if (e.getSource() == bDialogoWarn) {
            JOptionPane.showMessageDialog(PestaniaSiete.this, "ESte es un diálogo de warning",
                    "Titulo del mensaje", JOptionPane.WARNING_MESSAGE, null);
        } else if (e.getSource() == bDialogoOpciones) {
            opcion = JOptionPane.showConfirmDialog(PestaniaSiete.this,
                    "¿Segudo que quieres continuar?",
                    "Titulo del mensaje", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null);


            if (opcion == JOptionPane.YES_OPTION) {
                System.out.println("Pulsado si");
            } else if (opcion == JOptionPane.NO_OPTION) {
                System.out.println("Pulsado no");
            } else if (opcion == JOptionPane.CANCEL_OPTION) {
                System.out.println("Pulsado cancelar");
            }

        } else if (e.getSource() == bDialogoOpcionesPerso) {
            String[] opciones = {"Botón1", "Botón2", "Botón3"};
            Persona[] personas = {new Persona("Nombre1", "Apellido1", 123, 123, false),
                    new Persona("Nombre2", "Apellido2", 123, 123, false),
                    new Persona("Nombre3", "Apellido3", 123, 123, false)};
            int opcionPerso = JOptionPane.showOptionDialog(PestaniaSiete.this, "Selecciona una opción",
                    "Título del diálogo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    personas, personas[0]);
            switch (opcionPerso) {
                case 0:
                    System.out.println("Boton 1 pulsado");
                    break;
                case 1:
                    System.out.println("Boton 2 pulsado");
                    break;
                case 2:
                    System.out.println("Boton 3 pulsado");
                    break;
            }
        } else if (e.getSource() == bDialogoEntrada){
            String datoIntro = JOptionPane.showInputDialog(PestaniaSiete.this, "Introduce datos",
                    "Mensaje",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(datoIntro);
        } else if (e.getSource() == bDialogoEntradaPersona){
            Persona[] personas = {new Persona("Nombre1", "Apellido1", 123, 123, false),
                    new Persona("Nombre2", "Apellido2", 123, 123, false),
                    new Persona("Nombre3", "Apellido3", 123, 123, false)};

            Persona seleccionada = (Persona) JOptionPane.showInputDialog(PestaniaSiete.this,"Selecciona una persona",
                    "Titulo",JOptionPane.INFORMATION_MESSAGE,null,personas,personas[0]);
            System.out.println(seleccionada.getNombre());
        } else if (e.getSource() == bFicheros){
            JFileChooser fileChooser = new JFileChooser();
            int i = fileChooser.showSaveDialog(this);
            if (i == JFileChooser.APPROVE_OPTION){
                String f = fileChooser.getSelectedFile().getName();
                String ex = f.substring(f.indexOf(".")+1);
                System.out.println(ex);
            }else if (i == JFileChooser.CANCEL_OPTION){

            }
        } else if (e.getSource() == bColor){
            //JColorChooser colorChooser = new JColorChooser();
            Color c = JColorChooser.showDialog(this,"Titulo", Color.BLUE);
            texto.setForeground(c);
        } else if (e.getSource() == opcionUno){
            System.out.println("pulsado opcion 1");
        }
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        if (barraProgreso.getValue() == 100) {
            JOptionPane.showMessageDialog(PestaniaSiete.this, "Proceso completo",
                    "Titulo del mensaje", JOptionPane.INFORMATION_MESSAGE, null);

        }
    }

    class ManejoRaton extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            if (e.getButton() == MouseEvent.BUTTON3) {
                contextual.show(pestaniaSiete, e.getX(), e.getY());
            }

        }
    }

}
