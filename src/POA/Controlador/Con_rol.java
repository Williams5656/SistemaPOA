/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.*;
import POA.Modelo.Validadores.Letras;
import POA.Modelo.Validadores.Numeros;
import POA.Vista.*;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Myrian
 */
public class Con_rol {

    private final Vis_Roles vista;
    RolBD bdrol = new RolBD();
    int fila = -1;
    int n;

    public Con_rol(Vis_Roles vista) {
        this.vista = vista;
        vista.setVisible(true);
        activarbotones();
        nuevo();
        vista.getTxt_numero().setEditable(false);
        Numeros.solo_numeros(vista.getTxt_id());
        Letras.solo_letras(vista.getTxt_nombrerol());
        vista.getBtn_ingresar().addActionListener(l -> {
            try {
                cargarDialogo(1);
            } catch (SQLException ex) {
                Logger.getLogger(Con_rol.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        vista.getBtn_editar().addActionListener(l -> {
            try {
                cargarDialogo(2);
            } catch (SQLException ex) {
                Logger.getLogger(Con_rol.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        vista.getBtn_guardar_rol().addActionListener(l -> {
            try {
                DefinirMetodo(n);
            } catch (SQLException ex) {
                Logger.getLogger(Con_rol.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        vista.getBtn_eliminar().addActionListener(l -> eliminar());
        vista.getTabla_rol().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
        vista.getBtn_ver_permiso().addActionListener(l -> Permiso());
        vista.getBtn_cancelar().addActionListener(l -> vista.getVista_NuevoRol().dispose());
        lista();
    }

    public void activarbotones() {
        vista.getBtn_editar().setEnabled(false);
        vista.getBtn_eliminar().setEnabled(false);
        vista.getBtn_ver_permiso().setEnabled(true);
        vista.getBtn_editar_permiso().setEnabled(false);
    }

    private void cargarDialogo(int origen) throws SQLException {
        vista.getVista_NuevoRol().setSize(550, 550);//dimensiones
        vista.getVista_NuevoRol().setLocationRelativeTo(vista);//posicion
        fila = vista.getTabla_rol().getSelectedRow();
        if (origen == 1) {//selecciona ingresar
            nuevo();
            vista.getVista_NuevoRol().setTitle("Ingresar Rol");
            n = 1;
            vista.getTxt_numero().setText(String.valueOf(bdrol.codigo()));
            vista.getVista_NuevoRol().setVisible(true);
            vista.getTxt_id().setEditable(true);
        } else {
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "SELECCIONE UN DATO DE LA TABLA", "", 2);
            } else {//ingresar modificar
                vista.getVista_NuevoRol().setTitle("Editar Rol");
                n = 2;
                vista.getVista_NuevoRol().setVisible(true);
                vista.getTxt_id().setEditable(false);
            }

        }
    }

    boolean validarId() {
        int codigo = Integer.parseInt(vista.getTxt_id().getText());
        List<RolMD> lista_id = bdrol.obtenerDatos(1);
        for (int i = 0; i < lista_id.size(); i++) {
            if (codigo == (lista_id.get(i).getId_rol())) {
                JOptionPane.showMessageDialog(null, "EL CODIGO YA EXISTE!", "Verificacion", 0);
                return false;
            }
        }
        return true;
    }

    public void verPermiso() {
        System.out.println("hola");
       Vis_Principal principal = new Vis_Principal();
        Vis_Permisos permisos = new Vis_Permisos();
        Con_permisos perm = new Con_permisos(permisos);
        principal.getESCRITORIO().add(permisos);
        principal.getESCRITORIO().show();
        permisos.setVisible(true);
        Dimension desktopSize = principal.getESCRITORIO().getSize();
        Dimension FrameSize = permisos.getSize();
        permisos.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }
    public void Permiso() {
        Vis_Principal p = new Vis_Principal();
        Con_principal principal = new Con_principal(p);
        principal.permisos();
    }
    

    public void DefinirMetodo(int n) throws SQLException {
        if (n == 1) {//ingresar
            fila = vista.getTabla_rol().getSelectedRow();
            guardar();
        } else if (n == 2) {//modificar
            fila = vista.getTabla_rol().getSelectedRow();
            modificar();
        }
    }

    public void modificar() {

        bdrol.setId_rol(Integer.parseInt(vista.getTxt_id().getText()));
        bdrol.setNumero_rol(Integer.parseInt(vista.getTxt_numero().getText()));
        bdrol.setNombre_rol(vista.getTxt_nombrerol().getText());
        bdrol.setObservaciones(vista.getTxt_observaciones().getText());
        int res = JOptionPane.showConfirmDialog(null, "Confirme");
        if (res == 0) {
            if (bdrol.Modificar(Integer.parseInt(vista.getTxt_id().getText()))) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }
    }

    public void guardar() {
        if (!vista.getTxt_numero().getText().equals("") && !vista.getTxt_id().getText().equals("") && !vista.getTxt_nombrerol().getText().equals("")) {
            if (validarId() == true) {
                bdrol.setNumero_rol(Integer.parseInt(vista.getTxt_numero().getText()));
                bdrol.setId_rol(Integer.parseInt(vista.getTxt_id().getText()));
                bdrol.setNombre_rol(vista.getTxt_nombrerol().getText());
                bdrol.setObservaciones(vista.getTxt_observaciones().getText());
                if (bdrol.insertar()) {
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                    lista();
                    nuevo();
                    vista.getTxt_numero().setText(String.valueOf(bdrol.codigo()));
                } else {
                    JOptionPane.showMessageDialog(null, "ERRROR AL GUARDAR");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "LLENAR TODOS L0S CAMPOS");
        }
    }

    public void seleccionar() {
        vista.getBtn_eliminar().setEnabled(true);
        vista.getBtn_editar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_rol().getModel();
        int id = (int) modelo.getValueAt(vista.getTabla_rol().getSelectedRow(), 1);
        List<RolMD> lista = bdrol.obtenerDatos(id);
        bdrol.setNumero_rol(lista.get(0).getNumero_rol());
        bdrol.setId_rol(lista.get(0).getId_rol());
        bdrol.setNombre_rol(lista.get(0).getNombre_rol());
        bdrol.setObservaciones(lista.get(0).getObservaciones());

        vista.getTxt_id().setText(bdrol.getId_rol() + "");
        vista.getTxt_numero().setText(bdrol.getNumero_rol() + "");
        vista.getTxt_nombrerol().setText(bdrol.getNombre_rol());
        vista.getTxt_observaciones().setText(bdrol.getObservaciones());
    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_rol().getModel();
        List<RolMD> lista = bdrol.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTabla_rol().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTabla_rol().setValueAt(lista.get(i).getNumero_rol(), i, 0);
            vista.getTabla_rol().setValueAt(lista.get(i).getId_rol(), i, 1);
            vista.getTabla_rol().setValueAt(lista.get(i).getNombre_rol(), i, 2);
            vista.getTabla_rol().setValueAt(lista.get(i).getObservaciones(), i, 3);
        }
    }

    private void eliminar() {
        int resp2 = JOptionPane.showConfirmDialog(null, "Confirme si esta seguro de ELIMINAR.....");
        if (resp2 == 0) {
            if (bdrol.Eliminar(Integer.parseInt(vista.getTxt_id().getText()))) {
                JOptionPane.showMessageDialog(null, "Datos Eliminados");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        }
    }

    public void nuevo() {
        vista.getTxt_id().setText("");
        vista.getTxt_numero().setText("");
        vista.getTxt_nombrerol().setText("");
        vista.getTxt_observaciones().setText("");
        activarbotones();
    }

}
