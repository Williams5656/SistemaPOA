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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MIGUEL
 */
public class Con_persona {

    private final vis_Persona vista;
    PersonaBD per = new PersonaBD();

    public Con_persona(vis_Persona vista) {
        this.vista = vista;
        vista.setVisible(true);
        Letras.no_espacios(vista.getTxtCedula());
        Numeros.solo_numeros(vista.getTxtCedula());
        Letras.numero_letras(vista.getTxtCedula(), 9);
        Letras.solo_letras(vista.getTxtNombre());
        Letras.solo_letras(vista.getTxtApellido());
        Letras.no_espacios(vista.getTxtCelular());
        Numeros.solo_numeros(vista.getTxtCelular());
        Letras.no_espacios(vista.getTxtCorreo());
        

    }

    public void comprobar_cerd() {
        vista.getTxtCedula().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!Cedula.valcedula(vista.getTxtCedula())) {

                }
            }
        }
        );

    }

    public void val_correo() {
        vista.getTxtCorreo().addFocusListener(new FocusAdapter() {
             @Override
            public void focusLost(FocusEvent e) {
                Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                Matcher mather = pattern.matcher(vista.getTxtCorreo().getText());
                if(!mather.find()); 
            }

        }
        );
    }
}
