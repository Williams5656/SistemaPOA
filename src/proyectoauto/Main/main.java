/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoauto.Main;
import proyectoauto.Controlador.*;
import proyectoauto.Vista.*;
/**
 *
 * @author willi
 */
public class main {
    public static void main(String[] args) {
        vis_inicio vista = new vis_inicio();
        con_inicio inicio = new con_inicio(vista);
        
    }
}
