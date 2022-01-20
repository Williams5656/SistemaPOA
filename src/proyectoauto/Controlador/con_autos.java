/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoauto.Controlador;
import proyectoauto.Vista.*;
import proyectoauto.Modelo.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author willi
 */
public class con_autos {
    private final vis_autos vista;
    private AutoBD bdauto = new AutoBD();
    public con_autos(vis_autos vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.getBtnnuevo().addActionListener(e->nuevo());
        vista.getBtnguardar().addActionListener(e->guardar());
        vista.getBtnmodificar().addActionListener(e->modificar());
        vista.getTablaautos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
             selecionar();
            }
               
});
        lista();
    }
    public void modificar(){
       bdauto.setPlaca(vista.getTxtplaca().getText());
       String marca = (String) vista.getCombomarca().getSelectedItem();
       bdauto.setMarca(marca);
       String color = (String) vista.getCombocolor().getSelectedItem();
       bdauto.setColor(color);
       bdauto.setMotor(Integer.parseInt(vista.getTxtmotor().getText()));
       bdauto.setAnio(Integer.parseInt(vista.getTxtanio().getText()));
       bdauto.setModelo(vista.getTxtmodelo().getText());
       bdauto.setChasis(vista.getTxtchasis().getText());
       bdauto.setPrecio(Double.parseDouble(vista.getTxtprecio().getText()));
        int resp2 = JOptionPane.showConfirmDialog(null,"Confirme si esta seguro modificar.....");
        if(resp2== 0){
            if(bdauto.modificar(vista.getTxtplaca().getText())){
                JOptionPane.showMessageDialog(null,"Datos Actualizados");
                lista();
                nuevo();
            } else {
                 JOptionPane.showMessageDialog(null,"Error al modificar");
            }
        }
    }
    public void nuevo(){
    vista.getBtnguardar().setEnabled(true);
    vista.getBtnmodificar().setEnabled(false);
        vista.getTxtplaca().setText("");
        vista.getCombomarca().setSelectedItem("");
        vista.getCombocolor().setSelectedItem("");
        vista.getTxtmodelo().setText("");
        vista.getTxtanio().setText("");
        vista.getTxtchasis().setText("");
        vista.getTxtprecio().setText("");
        vista.getTxtmotor().setText("");
    }
    public void guardar(){
       bdauto.setPlaca(vista.getTxtplaca().getText());
       String marca = (String) vista.getCombomarca().getSelectedItem();
       bdauto.setMarca(marca);
       String color = (String) vista.getCombocolor().getSelectedItem();
       bdauto.setColor(color);
       bdauto.setMotor(Integer.parseInt(vista.getTxtmotor().getText()));
       bdauto.setAnio(Integer.parseInt(vista.getTxtanio().getText()));
       bdauto.setModelo(vista.getTxtmodelo().getText());
       bdauto.setChasis(vista.getTxtchasis().getText());
       bdauto.setPrecio(Double.parseDouble(vista.getTxtprecio().getText()));
       if(bdauto.insertar()){
           JOptionPane.showMessageDialog(null,"Datos Guardados Correctamente");
           lista();
           nuevo();
       } else
       {
          JOptionPane.showMessageDialog(null,"Error al Guardar"); 
       }
    }
    public void selecionar(){
        vista.getBtnguardar().setEnabled(false);
        vista.getBtnmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaautos().getModel();
        String placa = (String) modelo.getValueAt(vista.getTablaautos().getSelectedRow(), 0);
        System.out.println(placa);
        List<AutoMD> lista = bdauto.obtenerdatos(placa);
        bdauto.setPlaca(lista.get(0).getPlaca());
        bdauto.setMarca(lista.get(0).getMarca());
        bdauto.setModelo(lista.get(0).getModelo());
        bdauto.setAnio(lista.get(0).getAnio());
        bdauto.setColor(lista.get(0).getColor());
        bdauto.setChasis(lista.get(0).getChasis());
        bdauto.setPrecio(lista.get(0).getPrecio());
        bdauto.setMotor(lista.get(0).getMotor());
        
        vista.getTxtplaca().setText(bdauto.getPlaca());
        vista.getCombomarca().setSelectedItem(bdauto.getMarca());
        vista.getCombocolor().setSelectedItem(bdauto.getColor());
        vista.getTxtmodelo().setText(bdauto.getModelo());
        vista.getTxtanio().setText(bdauto.getAnio()+"");
        vista.getTxtchasis().setText(bdauto.getChasis());
        vista.getTxtprecio().setText(bdauto.getPrecio()+"");
        vista.getTxtmotor().setText(bdauto.getMotor()+"");
        
    }
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaautos().getModel();
        List<AutoMD> lista = bdauto.mostrardatos();
        int columnas = modelo.getColumnCount();
        for(int j = vista.getTablaautos().getRowCount()-1; j>=0;j--){
            modelo.removeRow(j);
        }
        
        for (int i = 0; i < lista.size(); i++) {
          modelo.addRow(new Object[columnas]);
          vista.getTablaautos().setValueAt(lista.get(i).getPlaca(),i,0);
          vista.getTablaautos().setValueAt(lista.get(i).getMarca(),i,1);
          vista.getTablaautos().setValueAt(lista.get(i).getModelo(),i,2);
          vista.getTablaautos().setValueAt(lista.get(i).getMotor(),i,3);
          vista.getTablaautos().setValueAt(lista.get(i).getAnio(),i,4);
          vista.getTablaautos().setValueAt(lista.get(i).getColor(),i,5);
          vista.getTablaautos().setValueAt(lista.get(i).getChasis(),i,6);
          vista.getTablaautos().setValueAt(lista.get(i).getPrecio(),i,7);
        }
        
    }
}
