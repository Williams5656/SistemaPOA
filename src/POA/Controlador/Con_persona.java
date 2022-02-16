/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.PersonaBD;
import POA.Modelo.Validadores.Cedula;
import POA.Modelo.Validadores.Letras;
import POA.Modelo.Validadores.Numeros;
import POA.Vista.vis_Persona;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 *
 * @author MIGUEL
 */
public class Con_persona {
    private final vis_Persona vista;
    PersonaBD per=new PersonaBD();

    public Con_persona(vis_Persona vista) {
        this.vista=vista;
        vista.setVisible(true);
        Letras.no_espacios(vista.getTxtCedula());
        Numeros.solo_numeros(vista.getTxtCedula());
        Letras.numero_letras(vista.getTxtCedula(), 9);
        
        
        
    }
    
    public void comprobar_cerd(){
        vista.getTxtCedula().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!Cedula.valcedula(vista.getTxtCedula())){
                    
                }
            }
        }
        );
        
    }
    
    
}
