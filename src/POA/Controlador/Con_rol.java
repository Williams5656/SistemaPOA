/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.*;
import POA.Vista.*;
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
        vista.getBtn_ingresar().addActionListener(l->{
            try {
                cargarDialogo(1);
            } catch (SQLException ex) {
                Logger.getLogger(Con_rol.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
    private void cargarDialogo(int origen) throws SQLException {
        vista.getVista_NuevoRol().setSize(950, 400);
        vista.getVista_NuevoRol().setLocationRelativeTo(vista);
        fila = vista.getTabla_rol().getSelectedRow();
        if (origen == 1) {
            n = 1;
            vista.getVista_NuevoRol().setVisible(true);
        } else {
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "SELECCIONE UN DATO DE LA TABLA", "", 2);
            } else {
                // cargarDatos();
                vista.getVista_NuevoRol().setTitle("Editar Rol");
                n = 2;
                vista.getVista_NuevoRol().setVisible(true);
            }

        }
    }
    public void guardar(){
        if (!vista.getTxt_numero().getText().equals("")&&!vista.getTxt_id().getText().equals("")&&!vista.getTxt_nombrerol().getText().equals("")) {
            bdrol.setNumero_rol(Integer.parseInt(vista.getTxt_numero().getText()));
            bdrol.setId_rol(Integer.parseInt(vista.getTxt_id().getText()));
            bdrol.setNombre_rol(vista.getTxt_nombrerol().getText());
            bdrol.setObservaciones(vista.getTxt_observaciones().getText());
            if (bdrol.insertar()) {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                lista();
                nuevo();

            } else {
                JOptionPane.showMessageDialog(null, "ERRROR AL GUARDAR");
            }
        }else {
            JOptionPane.showMessageDialog(null, "LLENAR TODOS L0S CAMPOS");
        }
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
    public void nuevo(){
        vista.getTxt_id().setText("");
        vista.getTxt_numero().setText("");
        vista.getTxt_nombrerol().setText("");
        vista.getTxt_observaciones().setText("");
    }
    
    
}
