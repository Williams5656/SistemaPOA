/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.PersonaBD;
import POA.Modelo.PersonaMD;
import POA.Modelo.Validadores.Cedula;
import POA.Modelo.Validadores.Letras;
import POA.Modelo.Validadores.Numeros;
import POA.Vista.vis_Persona;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MIGUEL
 */
public class Con_persona {

    private final vis_Persona vista;
    PersonaBD per = new PersonaBD();
    String error;
    protected static String Orig;

    public Con_persona(vis_Persona vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.getBtnNuevo().addActionListener(e -> nuevo());
        vista.getBtnGuardar().addActionListener(e -> guardar());
        vista.getBtnModificar().addActionListener(e -> modificar());
        vista.getBtnCargarFoto().addActionListener(e -> obtieneImagen());
        vista.getBtnCamEstado().addActionListener(e -> cambiarestado());
        vista.getBtnGuardar().setEnabled(false);
        vista.getBtnModificar().setEnabled(false);
        vista.getBtnCamEstado().setEnabled(false);
        vista.getBtnImprimir().setEnabled(false);
//        Letras.no_espacios(vista.getTxtCedula());
//        Numeros.solo_numeros(vista.getTxtCedula());
//        Letras.numero_letras(vista.getTxtCedula(), 9);
//        Letras.solo_letras(vista.getTxtNombre());
//        Letras.solo_letras(vista.getTxtApellido());
//        Letras.no_espacios(vista.getTxtCelular());
//        Numeros.solo_numeros(vista.getTxtCelular());
//        Letras.no_espacios(vista.getTxtCorreo());
//        comprobar_ced();
//        val_correo();
        vista.getTablePersonas().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    seleccionar();
                } catch (ParseException ex) {
                    Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        lista();

    }

    public void seleccionar() throws ParseException {
        vista.getBtnGuardar().setEnabled(false);
        vista.getBtnModificar().setEnabled(true);
        vista.getBtnCamEstado().setEnabled(true);
        vista.getBtnImprimir().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablePersonas().getModel();
        String cedula = (String) modelo.getValueAt(vista.getTablePersonas().getSelectedRow(), 0);
        System.out.println(cedula);
        List<PersonaMD> lista = per.obtenerdatos(cedula);
        per.setCedula(lista.get(0).getCedula());
        per.setNombres(lista.get(0).getNombres());
        per.setApellidos(lista.get(0).getApellidos());
        per.setFecha_nacimiento(lista.get(0).getFecha_nacimiento());
        per.setDireccion(lista.get(0).getDireccion());
        per.setCorreo(lista.get(0).getCorreo());
        per.setTelefono(lista.get(0).getTelefono());
        per.setEstado(lista.get(0).getEstado());

        vista.getTxtCedula().setText(per.getCedula());
        vista.getTxtNombre().setText(per.getNombres());
        vista.getTxtApellido().setText(per.getApellidos());
        vista.getTxtDireccion().setText(per.getDireccion());
        vista.getTxtCorreo().setText(per.getCorreo());
        vista.getTxtCelular().setText(per.getTelefono());

        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date d = formato.parse(per.getFecha_nacimiento());
            vista.getFecha().setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        Image img = lista.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(vista.getLbFoto().getWidth(), vista.getLbFoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vista.getLbFoto().setIcon(icon);
        } else {
            vista.getLbFoto().setIcon(null);
        }
    }

    public void comprobar_ced() {
        vista.getTxtCedula().addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                if (!Cedula.valcedula(vista.getTxtCedula())) {
                    men_error(vista.getTxtCedula().getName());
                }
            }
        }
        );

    }

    public void val_correo() {
        vista.getTxtCorreo().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                Matcher mather = pattern.matcher(vista.getTxtCorreo().getText());
                if (!mather.find()) {
                    men_error(vista.getTxtCorreo().getName());
                }
            }

        }
        );
    }

    public void men_error(String a) {
        if (a.equals(vista.getTxtCedula().getName())) {
            error = "Cedula Erronea";
        }
        if (a.equals(vista.getTxtNombre().getName())) {
            error = "Nombre Erroneo";
        }
        if (a.equals(vista.getTxtApellido().getName())) {
            error = "Apellido Erroneo";
        }
        if (a.equals(vista.getTxtCorreo().getName())) {
            error = "Correo Erroneo";
        }
        if (a.equals(vista.getTxtDireccion().getName())) {
            error = "Direccion Erronea";
        }
        if (a.equals(vista.getTxtCelular().getName())) {
            error = "Celular Erroneo";
        }
        if (a.equals(vista.getFecha().getName())) {
            error = "Fecha Erronea";
        }
        pro_error err = new pro_error();
        err.run();
    }

    public class pro_error extends Thread {

        @Override
        public void run() {
            try {
                vista.getLbError().setText(error);
                vista.getLbError().setVisible(true);
                Thread.sleep(3000);
                vista.getLbError().setVisible(false);
                error = "";
            } catch (InterruptedException ex) {
                Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void guardar() {
        if (vista.getTxtNombre().getText().equals("") || vista.getTxtNombre().getText().equals("") || vista.getTxtApellido().getText().equals("") || vista.getTxtDireccion().getText().equals("") || vista.getTxtCorreo().getText().equals("") || vista.getTxtCelular().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            per.setCedula(vista.getTxtCedula().getText());
            per.setNombres(vista.getTxtNombre().getText());
            per.setApellidos(vista.getTxtApellido().getText());
            per.setDireccion(vista.getTxtDireccion().getText());
            per.setCorreo(vista.getTxtCorreo().getText());
            per.setTelefono(vista.getTxtCelular().getText());
            per.setEstado("ACTIVO");
            ImageIcon ic = (ImageIcon) vista.getLbFoto().getIcon();
            per.setFoto(ic.getImage());
            SimpleDateFormat formato6 = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = formato6.format(vista.getFecha().getDate());
            per.setFecha_nacimiento(fecha);
            int b = JOptionPane.showConfirmDialog(null, "Confirme los datos: \nCedula: " + vista.getTxtCedula().getText() + "\nNombre: " + vista.getTxtNombre().getText() + "\nApellidos: " + vista.getTxtApellido().getText() + "\nDireccion: " + vista.getTxtDireccion().getText() + "\nCorreo: " + vista.getTxtCorreo().getText() + "\nTelefono: " + vista.getTxtCelular().getText() + "\nEstado: " + per.getEstado(), "Confirmar Compra", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            int a = JOptionPane.showConfirmDialog(null, "Esta seguro de guardar", "Confirmar persona", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (a == 0 && b == 0) {
                if (per.insertar()) {
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                    nuevo();
                    lista();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                }
            }
        }
    }

    public void nuevo() {
        vista.getBtnGuardar().setEnabled(true);
        vista.getBtnImprimir().setEnabled(false);
        vista.getBtnCamEstado().setEnabled(false);
        vista.getBtnGuardar().setEnabled(true);
        vista.getBtnModificar().setEnabled(false);
        vista.getTxtNombre().setText("");
        vista.getTxtCedula().setText("");
        vista.getTxtCelular().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getTxtDireccion().setText("");
        vista.getTxtCorreo().setText("");
        vista.getFecha().setDate(null);
        Orig = "src/POA.Vista.img/imagen.png";
        ImageIcon icon = new ImageIcon(Orig);
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(vista.getLbFoto().getWidth(), vista.getLbFoto().getHeight(), Image.SCALE_DEFAULT));
        vista.getLbFoto().setText(null);
        vista.getLbFoto().setIcon(icono);
    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablePersonas().getModel();
        List<PersonaMD> lista9 = per.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablePersonas().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
            for (int i = 0; i < lista9.size(); i++) {
                modelo.addRow(new Object[columnas]);
                vista.getTablePersonas().setValueAt(lista9.get(i).getCedula(), i, 0);
                vista.getTablePersonas().setValueAt(lista9.get(i).getNombres(), i, 1);
                vista.getTablePersonas().setValueAt(lista9.get(i).getApellidos(), i, 2);
                vista.getTablePersonas().setValueAt(lista9.get(i).getFecha_nacimiento(), i, 3);
                vista.getTablePersonas().setValueAt(lista9.get(i).getDireccion(), i, 4);
                vista.getTablePersonas().setValueAt(lista9.get(i).getCorreo(), i, 5);
                vista.getTablePersonas().setValueAt(lista9.get(i).getTelefono(), i, 6);
                vista.getTablePersonas().setValueAt(lista9.get(i).getEstado(), i, 7);
            }

        }

    }

    private void obtieneImagen() {
        vista.getLbFoto().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vista.getLbFoto().getWidth(), vista.getLbFoto().getHeight(), Image.SCALE_DEFAULT);
                vista.getLbFoto().setIcon(new ImageIcon(icono));
                vista.getLbFoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void modificar() {

        per.setCedula(vista.getTxtCedula().getText());
        per.setNombres(vista.getTxtNombre().getText());
        per.setApellidos(vista.getTxtApellido().getText());
        SimpleDateFormat formato6 = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato6.format(vista.getFecha().getDate());
        per.setFecha_nacimiento(fecha);

        per.setDireccion(vista.getTxtDireccion().getText());
        per.setCorreo(vista.getTxtCorreo().getText());
        per.setTelefono(vista.getTxtCelular().getText());
        ImageIcon ic = (ImageIcon) vista.getLbFoto().getIcon();
        per.setFoto(ic.getImage());

        int resp2 = JOptionPane.showConfirmDialog(null, "¿Desea Modificar?");
        if (resp2 == 0) {
            if (per.Modificar(vista.getTxtCedula().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS MODIFICADOS");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }

        }

    }

    public void buscar() {
        if (vista.getTxtBuscar().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTablePersonas().getModel();
            List<PersonaMD> lista1 = per.mostrardatos();
            int columnas = modelo.getColumnCount();
            for (int j = vista.getTablePersonas().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
                for (int i = 0; i < lista1.size(); i++) {
                    if (lista1.get(i).getCedula().equals(vista.getTxtBuscar().getText())) {
                        modelo.addRow(new Object[columnas]);
                        vista.getTablePersonas().setValueAt(lista1.get(i).getCedula(), i, 0);
                        vista.getTablePersonas().setValueAt(lista1.get(i).getNombres(), i, 1);
                        vista.getTablePersonas().setValueAt(lista1.get(i).getApellidos(), i, 2);
                        vista.getTablePersonas().setValueAt(lista1.get(i).getDireccion(), i, 3);
                        vista.getTablePersonas().setValueAt(lista1.get(i).getCorreo(), i, 4);
                        vista.getTablePersonas().setValueAt(lista1.get(i).getTelefono(), i, 5);
                        vista.getTablePersonas().setValueAt(lista1.get(i).getFecha_nacimiento(), i, 6);
                    }
                }
            }
        }
        nuevo();
    }

    public void cambiarestado() {
        List<PersonaMD> lista = per.mostrardatos();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCedula().equalsIgnoreCase(vista.getTxtCedula().getText())) {
                if (lista.get(i).getEstado().equalsIgnoreCase("ACTIVO")) {
                    per.setEstado("INACTIVO");

                } else {
                    per.setEstado("ACTIVO");
                }
            }
        }
        if (per.cambiarestado((vista.getTxtCedula().getText()))) {
            JOptionPane.showMessageDialog(null, "ESTADO MODIFICADO");
            lista();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }

    }

}
