/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo.Validadores;

import javax.swing.JTextField;

/**
 *
 * @author MIGUEL
 */
public class Cedula {
    
    
     public static boolean valcedula(JTextField ced) {
        String cedula=ced.getText();
        try {
            String[] data = cedula.split("");
            int verificador = Integer.parseInt(data[0] + data[1]);            
            if ((verificador < 1 || verificador > 24) && verificador!=30) {
                return false;
            }
            int[] digitos=new int[10];
            for (int i = 0; i < 10; i++) {
                digitos[i] = Integer.parseInt(data[i]);
            }
            if (digitos[2] > 6) {
                return false;
            }
            int sumatotal=0;
            for (int i = 0; i < 9; i++) {
                 int resultado_impares=0;
                int resultado_pares=0;
                if (i % 2 == 0) {
                    int sumarim=(digitos[i]*2);
                    if (sumarim > 9) {
                        sumarim=sumarim-9;
                    }
                    resultado_impares=resultado_impares+sumarim;
                } else {
                    resultado_pares=resultado_pares+digitos[i];
                }
                sumatotal=sumatotal+(resultado_impares+resultado_pares);                
            }
            if (sumatotal%10==0 && digitos[9]==0)return true;        
            else if(10-(sumatotal%10)==digitos[9]) return true;    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
