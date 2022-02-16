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
    
    public static void solo_letras(JTextField t){
        t.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!t.getText().matches("[a-zA-ZñÑ_ ]*")) {
                    e.consume();
                }
            }
        }
        );
    }
    
    public static boolean soloespacios(JTextField t){ //devuelve booleano si el campo posee solo espacios
        String a=t.getText();
        for (int i = 0; i < a.length()-1; i++) {
            if(a.charAt(i)==' ' && a.charAt(i+1)==32) return false;
        }
        return true;
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
        String a=t.getText().toLowerCase();
        a = a.trim();
        a = a.replaceAll("\\s{2,}", " ");
        return a;
    }
    
    public static void numero_letras(JTextField t, int a){ // determina el numero maximo de letras
        t.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                if (t.getText().length()>a) e.consume();
                }
            }
        );        
    }
}
