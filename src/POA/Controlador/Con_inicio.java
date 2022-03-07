package POA.Controlador;

import POA.Modelo.Permisos;
import POA.Modelo.UsuarioBD;
import POA.Modelo.UsuarioMD;
import POA.Modelo.permisosBD;
import POA.Vista.*;
import POA.Vista.*;
import POA.Vista.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC FACTORY
 */
public class Con_inicio {
    private final vis_inicioSesion vista;

    public Con_inicio(vis_inicioSesion vista) {
        vista.getLblcomp().setVisible(false);
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.getBtningresar().addActionListener(e -> {
            try {
                ingresar();
            } catch (SQLException ex) {
                Logger.getLogger(Con_inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    private void ingresar() throws SQLException {
        UsuarioBD dbp = new UsuarioBD();
        List<UsuarioMD> lista = dbp.mostrardatos();
        for (int i = 0; i < lista.size(); i++) {
            if (vista.getTxtusuario().getText().equals(lista.get(i).getNombreUsuario()) && vista.getTxtclave().getText().equals(lista.get(i).getContrasenia())&&lista.get(i).getEstado().equals("Activo")) {
                Vis_Principal vistamenu = new Vis_Principal();
                Con_principal menu = new Con_principal(vistamenu);
                vista.setVisible(false);
                vista.getLblcomp().setVisible(false);
                vistamenu.setVisible(true);
            }else{
                vista.getLblcomp().setVisible(true);
            }
        }
        validarRoles();
    }
    public void validarRoles() throws SQLException{
        int codrol;
        UsuarioBD dbp = new UsuarioBD();
        codrol=dbp.rol(vista.getTxtusuario().getText(),vista.getTxtclave().getText());
        System.out.println(codrol+" rol");
        permisosBD per=new permisosBD();
        List<Permisos> lista = per.cargarCheck(codrol);
        for (int i = 0; i < lista.size(); i++) {
            //Activar Botones
            if (i==0) {
                if (lista.get(i).isEstado()==true) {
                    Con_principal.vista.getBtn_asignacion().setEnabled(true);
                }else{
                    Con_principal.vista.getBtn_asignacion().setEnabled(false);
                }
            }
            if (i==1) {
                if (lista.get(i).isEstado()==true) {
                    Con_principal.vista.getBtn_perfil().setEnabled(true);
                }else{
                    Con_principal.vista.getBtn_perfil().setEnabled(false);
                }
            }
            if (i==2) {
                if (lista.get(i).isEstado()==true) {
                    Con_principal.vista.getBtn_usuario().setEnabled(true);
                }else{
                    Con_principal.vista.getBtn_usuario().setEnabled(false);
                }
            }
            if (i==3) {
                if (lista.get(i).isEstado()==true) {
                    Con_principal.vista.getBtn_persona().setEnabled(true);
                }else{
                    Con_principal.vista.getBtn_persona().setEnabled(false);
                }
            }
            if (i==4) {
                if (lista.get(i).isEstado()==true) {
                    Con_principal.vista.getBtn_roles().setEnabled(true);
                }else{
                    Con_principal.vista.getBtn_roles().setEnabled(false);
                }
            }
            if (i==5) {
                if (lista.get(i).isEstado()==true) {
                    Con_principal.vista.getBtn_carrera().setEnabled(true);
                }else{
                    Con_principal.vista.getBtn_carrera().setEnabled(false);
                }
            }
        }
    }

}
