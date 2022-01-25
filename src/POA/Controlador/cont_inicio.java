package POA.Controlador;

import POA.Vista.Vis_Principal;
import POA.Vista.vis_inicioSesion;
import POA.Vista.*;

/**
 *
 * @author PC FACTORY
 */
public class cont_inicio {

    private final vis_inicioSesion vista;

    public cont_inicio(vis_inicioSesion vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.getBtningresar().addActionListener(e -> ingresar());

    }

    private void ingresar() {
        if (vista.getTxtusuario().getText().equals("admin") && vista.getTxtclave().getText().equals("1234")) {
            Vis_Principal vistamenu = new Vis_Principal();
            vista.setVisible(false);
            vistamenu.setVisible(true);
        }else{
            vista.getTxtusuario().setText("");
            vista.getTxtclave().setText("");
        }
        

    }

}
