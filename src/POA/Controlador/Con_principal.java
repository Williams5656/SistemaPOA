/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Vista.Vis_Perfil;
import POA.Vista.Vis_Principal;
import POA.Vista.Vis_Roles;
import POA.Vista.Vis_Usuario;
import POA.Vista.vis_Persona;
import POA.Vista.vis_inicioSesion;
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
        vista.getBtn_persona().addActionListener(e -> persona());
        vista.getBtn_roles().addActionListener(e -> roles());
        vista.getBtn_salir().addActionListener(e -> salir());
        vista.getBtn_usuario().addActionListener(e -> usuario());

    }

    private void perfil() {
         Vis_Perfil zap = new Vis_Perfil();
        vista.getESCRITORIO().add(zap);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = zap.getSize();
        zap.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Con_perfil zapatos = new Con_perfil(zap);

    }

    private void persona() {
        vis_Persona persona = new vis_Persona();
        vista.getESCRITORIO().add(persona);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = persona.getSize();
        persona.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Con_persona per = new Con_persona(persona);

    }

    private void roles() {
        Vis_Roles user = new Vis_Roles();
        vista.getESCRITORIO().add(user);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        user.show();
    }

    private void salir() {
        vis_inicioSesion visin = new vis_inicioSesion();
        vista.setVisible(false);
        visin.setVisible(true);
        Con_inicio inicio = new Con_inicio(visin);
    }

    private void usuario() {
        Vis_Usuario user = new Vis_Usuario();
        vista.getESCRITORIO().add(user);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        cont_usuario us = new cont_usuario(user);
    }

//    private void asignacion() {
//        Vis_Asignacion user = new Vis_Asignacion();
//        vista.getESCRITORIO().add(user);
//        Dimension desktopSize = vista.getESCRITORIO().getSize();
//        Dimension FrameSize = user.getSize();
//        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
//        user.show();
//    }
}
