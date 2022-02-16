/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Vista.Vis_Usuario;

/**
 *
 * @author HP
 */
public class con_usuario {
    private final Vis_Usuario vista;

    public con_usuario(Vis_Usuario vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.getBtnguardar().addActionListener(e -> guardar());
    };
    
    private void guardar(){
        System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }
    
}
