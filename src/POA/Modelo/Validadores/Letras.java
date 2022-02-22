/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo.Validadores;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author MIGUEL
 */
public class Letras {

    public static void solo_letras(JTextField t) {
        t.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!t.getText().matches("[a-zA-ZñÑ_ ]*")) {
                    e.consume();
                }
            }
        }
        );
        t.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.toString(e.getKeyChar()).matches("[a-zA-ZñÑ_ ]*")) {
                    e.consume();
                }
            }
        }
        );
    }

    public static void dosespacios(JTextField t) { //consume elespacio si es pulsado dos veces
        t.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String a = t.getText();
                if (a.length() > 0) {
                    if (a.charAt(a.length() - 1) == 32 && e.getKeyChar() == 32) {
                        e.consume();
                    }
                }
            }
        }
        );

    }

    public static void no_espacios(JTextField t) { // evita que se puedan colocar espacios
        t.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 32) {
                    e.consume();
                }
            }
        }
        );
    }

    public static String dato_final(JTextField t) { // borra espacios en blanco al principio , final y espacios dobles o mas entre palabras
        String a = t.getText().toLowerCase();
        a = a.trim();
        a = a.replaceAll("\\s{2,}", " ");
        return a;
    }

    public static void numero_letras(JTextField t, int a) { // determina el numero maximo de letras
        t.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (t.getText().length() > a) {
                    e.consume();
                }
            }
        }
        );
    }
}
