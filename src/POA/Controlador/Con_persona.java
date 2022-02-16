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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
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
    protected static String Imagen, Dest, Orig;

    public Con_persona(vis_Persona vista) {
        this.vista = vista;
        vista.setVisible(true);
        Letras.no_espacios(vista.getTxtCedula());
        Numeros.solo_numeros(vista.getTxtCedula());
        Letras.numero_letras(vista.getTxtCedula(), 9);
        Letras.solo_letras(vista.getTxtNombre());
        Letras.solo_letras(vista.getTxtApellido());
        Letras.no_espacios(vista.getTxtCelular());
        Numeros.solo_numeros(vista.getTxtCelular());
        Letras.no_espacios(vista.getTxtCorreo());
        comprobar_ced();
        val_correo();

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
                ImageIcon ic = (ImageIcon) vista.getLbFoto().getIcon();
                per.setFoto(ic.getImage());
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                String fecha = formato.format(vista.getFecha().getDate());
                per.setFecha_nacimiento(fecha);
                int b = JOptionPane.showConfirmDialog(null, "Confirme los datos: \nCodigo: " + vista.getTxtCedula().getText() + "\nNombre: " + vista.getTxtNombre().getText() + "\nApellidos: " + vista.getTxtApellido().getText() + "\nDireccion: " + vista.getTxtDireccion().getText() + "\nCorreo: " + vista.getTxtCorreo().getText() + "\nTelefono: " + vista.getTxtCelular().getText(), "Confirmar Compra", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                int a = JOptionPane.showConfirmDialog(null, "Esta seguro de guardar la compra", "Confirmar Compra", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
            vista.getBtnModificar().setEnabled(false);
            vista.getTxtNombre().setText("");
            vista.getTxtApellido().setText("");
            vista.getTxtDireccion().setText("");
            vista.getTxtCorreo().setText("");
            Orig = "src/Imagenes/imagen.png";
            ImageIcon icon = new ImageIcon(Orig);
            ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(vista.getLbFoto().getWidth(), vista.getLbFoto().getHeight(), Image.SCALE_DEFAULT));
            vista.getLbFoto().setText(null);
            vista.getLbFoto().setIcon(icono);
        }

        public void lista() {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTablePersonas().getModel();
            List<PersonaMD> lista3 = per.mostrardatos();
            int columnas = modelo.getColumnCount();
            for (int j = vista.getTablePersonas().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
                for (int i = 0; i < lista3.size(); i++) {
                    modelo.addRow(new Object[columnas]);
                    vista.getTablePersonas().setValueAt(lista3.get(i).getCedula(), i, 0);
                    vista.getTablePersonas().setValueAt(lista3.get(i).getNombres(), i, 1);
                    vista.getTablePersonas().setValueAt(lista3.get(i).getApellidos(), i, 2);
                    vista.getTablePersonas().setValueAt(lista3.get(i).getDireccion(), i, 3);
                    vista.getTablePersonas().setValueAt(lista3.get(i).getCorreo(), i, 4);
                    vista.getTablePersonas().setValueAt(lista3.get(i).getTelefono(), i, 5);
                    vista.getTablePersonas().setValueAt(lista3.get(i).getFecha_nacimiento(), i, 6);
                }

            }

        }
        
        public void modificar() {
        
        per.setCedula(vista.getTxtCedula().getText());
        per.setNombres(vista.getTxtNombre().getText());
        per.setApellidos(vista.getTxtApellido().getText());
        
        String fechanac = Integer.toString(vista.getFecha().getCalendar().get(Calendar.DAY_OF_MONTH)) + "/" + Integer.toString(vista.getFecha().getCalendar().get(Calendar.MONTH) + 1) + "/" + Integer.toString(vista.getFecha().getCalendar().get(Calendar.YEAR));
        per.setFecha_nacimiento(fechanac);
        
        
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
    }

}
