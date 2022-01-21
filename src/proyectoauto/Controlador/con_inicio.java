/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoauto.Controlador;
import proyectoauto.Vista.*;

/**
 *
 * @author willi
 */
public class con_inicio {
    private final vis_inicio vista;
    public con_inicio(vis_inicio vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.getBtnguardar().addActionListener(e->guardar());
        
    }
    private void guardar(){
       vista.getTxtusuario().setText("Williams Trelles");
       vis_menu vistamenu = new vis_menu();
       con_menu menu = new con_menu(vistamenu);
       vista.setVisible(false);
    }
    
}
