/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Vista.Vis_Perfil;

/**
 *
 * @author USUARIO
 */
public class Con_perfil {
    private final Vis_Perfil vista;
    
    public Con_perfil(Vis_Perfil vista) {
        this.vista = vista;
        vista.setVisible(true);
        
    };
}
