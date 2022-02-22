/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Controlador;

import POA.Modelo.Permisos;
import POA.Modelo.permisosBD;
import POA.Vista.Vis_Permisos;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IsaacMejia
 */
public class Con_permisos {

    public static Vis_Permisos vista;
    permisosBD bdPermisos = new permisosBD();

    public Con_permisos(Vis_Permisos vista) {
        this.vista = vista;
        vista.getTxtidRol().setEditable(false);
        vista.setVisible(true);
        vista.getBtnGuardar().addActionListener(l -> validar());
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
            estado = Boolean.parseBoolean(vista.getTablapermisos().getValueAt(i, 2).toString());
            bdPermisos.setEstado(estado);
            bdPermisos.Modificar(idrol, id);
        }
    }

    public void guardarPermisos() {
        int idrol = Integer.parseInt(vista.getTxtidRol().getText());
        int id = 0;
        String nombrPermiso;
        boolean estado;
        for (int i = 0; i < vista.getTablapermisos().getRowCount(); i++) {
            id = Integer.parseInt(vista.getTablapermisos().getValueAt(i, 0).toString());
            nombrPermiso = vista.getTablapermisos().getValueAt(i, 1).toString();
            estado = Boolean.parseBoolean(vista.getTablapermisos().getValueAt(i, 2).toString());
            bdPermisos.setId(id);
            bdPermisos.setNombre_permiso(nombrPermiso);
            bdPermisos.setEstado(estado);
            bdPermisos.setId_rol(idrol);
            bdPermisos.insertar();
        }
    }    
}
