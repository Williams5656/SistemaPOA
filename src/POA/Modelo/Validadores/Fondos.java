/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo.Validadores;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author MIGUEL
 */
public class Fondos {

    private static class panel_imagen extends JPanel {

        private Image imagen;

        public panel_imagen() {
            imagen = null;
        }

        public panel_imagen(String nombre_imagen) {
            if (nombre_imagen != null) {
                imagen = new ImageIcon(getClass().getResource(nombre_imagen)).getImage();

            }
        }

        public void setImagen(String nombre_imagen) {
            if (nombre_imagen != null) {
                imagen = new ImageIcon(getClass().getResource(nombre_imagen)).getImage();
            } else {
                imagen = null;
            }
            repaint();
        }

        @Override
        public void paint(Graphics g) {
            if (imagen != null) {
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
                this.setOpaque(false);
            } else {
                this.setOpaque(true);
            }
            super.paint(g);
        }
    }

    public static class fondo_internalframe extends JInternalFrame {

        private panel_imagen pi = new panel_imagen();

        public fondo_internalframe() {
            setContentPane(pi);
        }

        public void setImage(String nombre_imagen) {
            pi.setImagen(nombre_imagen);
        }

    }

    public static panel_imagen fondo_panel(String ruta) {
        
        panel_imagen pi = new panel_imagen();
        
        pi.setImagen(ruta);
        
        return pi;
    }
}
