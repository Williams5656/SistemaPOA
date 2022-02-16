package POA.Controlador;

import POA.Vista.*;
import POA.Vista.*;
import POA.Vista.*;

/**
 *
 * @author PC FACTORY
 */
public class Con_inicio {

    private final vis_inicioSesion vista;

    public Con_inicio(vis_inicioSesion vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.getBtningresar().addActionListener(e -> ingresar());

    }

    private void ingresar() {
        if (vista.getTxtusuario().getText().equals("admin") && vista.getTxtclave().getText().equals("1234")) {
            Vis_Principal vistamenu = new Vis_Principal();
            Con_principal menu = new Con_principal(vistamenu);
            vista.setVisible(false);
            vistamenu.setVisible(true);
        }else{
            vista.getTxtusuario().setText("");
            vista.getTxtclave().setText("");
        }
        

    }

}
