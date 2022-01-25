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
        
        
        //Habilitar el boton guardar
        vista.getBtningresar().addActionListener(e->guardar());
        
    }
    
    private void guardar(){
        vista.getTxtusuario().setText("USUARIOS");
        Vis_Principal vistamenu = new Vis_Principal();
        vista.setVisible(false);
    }
     
     
    
}
