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
public class con_menu {
    private final vis_menu vista;
    public con_menu(vis_menu vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.getBtnautos().addActionListener(e->autos());
    }
    public void autos(){
        vis_autos visauto = new vis_autos();
        con_autos conautos = new con_autos(visauto);
        
    }
}
