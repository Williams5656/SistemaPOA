package POA.Controlador;

import POA.Modelo.UsuarioBD;
import POA.Modelo.UsuarioMD;
import POA.Vista.*;
import POA.Vista.*;
import POA.Vista.*;
import java.util.List;

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
        vista.getBtningresar().addActionListener(e -> ingresar());

    }

    private void ingresar() {
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
        
        

    }

}
