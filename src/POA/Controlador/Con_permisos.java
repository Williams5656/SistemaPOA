/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Controlador;

import static POA.Controlador.Con_rol.vista;
import POA.Modelo.Permisos;
import POA.Modelo.permisosBD;
import POA.Vista.Vis_Permisos;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author IsaacMejia
 */
public class Con_permisos {

    public static Vis_Permisos vista;
    permisosBD bdPermisos = new permisosBD();
    DefaultTableModel modelo = new DefaultTableModel();

    public Con_permisos(Vis_Permisos vista) {
        this.vista = vista;
        vista.getTxtidRol().setEditable(false);
        vista.setVisible(true);
        vista.getBtnGuardar().addActionListener(l -> validar());
        lista();
    }

    public void lista() {
        modelo = new DefaultTableModel() {
            //cargar los campos
            public boolean iscelleditable(int fila, int columna) {
                if (columna == 3) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        modelo.addColumn("id");
        modelo.addColumn("nombre_permisos");
        modelo.addColumn("Estado");

        Object[] fila = new Object[2];
        fila[0] = 1;
        fila[1] = "Boton Asignacion";
        modelo.addRow(fila);

        Object[] fila1 = new Object[2];
        fila1[0] = 2;
        fila1[1] = "Boton Perfil";
        modelo.addRow(fila1);

        Object[] fila2 = new Object[2];
        fila2[0] = 3;
        fila2[1] = "Boton Usuarios";
        modelo.addRow(fila2);

        Object[] fila3 = new Object[2];
        fila3[0] = 4;
        fila3[1] = "Boton Persona";
        modelo.addRow(fila3);

        Object[] fila4 = new Object[2];
        fila4[0] = 5;
        fila4[1] = "Boton Roles";
        modelo.addRow(fila4);

        Object[] fila5 = new Object[2];
        fila5[0] = 6;
        fila5[1] = "Boton Carrera";
        modelo.addRow(fila5);

        vista.getTablapermisos().setModel(modelo);
        check(2, vista.getTablapermisos());

    }

    public void check(int colum, JTable table) {

        TableColumn tc = vista.getTablapermisos().getColumnModel().getColumn(colum);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
    }

    public void validar() {
        int idrol = Integer.parseInt(vista.getTxtidRol().getText());
        int rol = bdPermisos.Validar(idrol);
        System.out.println("bbb" + idrol);
        System.out.println("aaa" + rol);
        if (rol == 0) {
            guardarPermisos();
        } else {
            modificar();
        }
    }

    public void modificar() {
        int id = 0;
        int idrol = Integer.parseInt(vista.getTxtidRol().getText());

        boolean estado;
        for (int i = 0; i < vista.getTablapermisos().getRowCount(); i++) {
            id = Integer.parseInt(vista.getTablapermisos().getValueAt(i, 0).toString());
            if (vista.getTablapermisos().getValueAt(i, 2) == null) {
                estado = false;
            } else {
                estado = Boolean.parseBoolean(vista.getTablapermisos().getValueAt(i, 2).toString());
            }
            bdPermisos.setEstado(estado);
            bdPermisos.Modificar(idrol, id);
           
        }
        JOptionPane.showMessageDialog(null, "Editado correctamente");
    }

    public void guardarPermisos() {
        int idrol = Integer.parseInt(vista.getTxtidRol().getText());
        int id = 0;
        String nombrPermiso;
        boolean estado;
        for (int i = 0; i < vista.getTablapermisos().getRowCount(); i++) {
            id = Integer.parseInt(vista.getTablapermisos().getValueAt(i, 0).toString());
            nombrPermiso = vista.getTablapermisos().getValueAt(i, 1).toString();
            if (vista.getTablapermisos().getValueAt(i, 2) == null) {
                estado = false;
            } else {
                estado = Boolean.parseBoolean(vista.getTablapermisos().getValueAt(i, 2).toString());
            }
            bdPermisos.setId(id);
            bdPermisos.setNombre_permiso(nombrPermiso);
            bdPermisos.setEstado(estado);
            bdPermisos.setId_rol(idrol);
            bdPermisos.insertar();
            
        }
        JOptionPane.showMessageDialog(null, "Guardado correctamente");
    }
    
}
