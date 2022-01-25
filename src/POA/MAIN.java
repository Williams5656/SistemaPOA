/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA;
import POA.Controlador.cont_inicio;
import POA.Vista.vis_inicioSesion;
/**
 *
 * @author WillyComputers
 */
public class MAIN {
    public static void main(String[] args) {
        vis_inicioSesion vista =new vis_inicioSesion();
        cont_inicio inicio = new cont_inicio(vista);
        System.out.println("Inicio");
    }
}
