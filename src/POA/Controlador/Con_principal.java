/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Vista.*;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;

/**
 *
 * @author USUARIO
 */
public class Con_principal {

    private final Vis_Principal vista;

    public Con_principal(Vis_Principal vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setExtendedState(MAXIMIZED_BOTH);
        vista.getBtn_perfil().addActionListener(e -> perfil());
//        vista.getBtn_asignacion().addActionListener(e -> asignacion());
//        vista.getBtn_roles().addActionListener(e -> roles());
//        vista.getBtn_salir().addActionListener(e -> salir());
//        vista.getBtn_nuevo().addActionListener(e -> nuevo());
        

    }

    private void perfil() {
        Vis_Perfil perfil = new Vis_Perfil();
        vista.getESCRITORIO().add(perfil);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = perfil.getSize();
        perfil.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Con_perfil per = new Con_perfil(perfil);
        
    }

//    private void asignacion() {
//        Vis_Asignacion user = new Vis_Asignacion();
//        vista.getESCRITORIO().add(user);
//        Dimension desktopSize = vista.getESCRITORIO().getSize();
//        Dimension FrameSize = user.getSize();
//        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
//        user.show();
//    }
//
//    private void roles() {
//        Vis_Roles user = new Vis_Roles();
//        vista.getESCRITORIO().add(user);
//        Dimension desktopSize = vista.getESCRITORIO().getSize();
//        Dimension FrameSize = user.getSize();
//        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
//        user.show();
//    }
//
//    private void salir() {
//        this.vista.getESCRITORIO().setVisible(false);
//        vis_inicioSesion user = new vis_inicioSesion();
//        user.setVisible(true);
//    }
//
//    private void nuevo() {
//        Vis_Usuario user = new Vis_Usuario();
//        vista.getESCRITORIO().add(user);
//        Dimension desktopSize = vista.getESCRITORIO().getSize();
//        Dimension FrameSize = user.getSize();
//        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
//        user.show();
//    }
}
