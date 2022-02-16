/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.UsuarioBD;
import POA.Modelo.UsuarioMD;
import POA.Vista.Vis_Usuario;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class cont_usuario {
    private final Vis_Usuario vista;
    private UsuarioBD bdusuario = new UsuarioBD();

    public cont_usuario(Vis_Usuario vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.getBtnnuevo().addActionListener(e->nuevo());
        vista.getBtnguardar().addActionListener(e->guardar());
        vista.getBtnmodificar().addActionListener(e->modificar());
        vista.getBtneliminar().addActionListener(e->eliminar());
        vista.getTableUsuario().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
            
        });
        
//        validar();
        lista();
        
    }
    
//    public void validar(){
//        vista.getTxtcedula().addKeyListener(new TxtVNumeros(vista.getTxtcedula()));
//        vista.getTxtnombres().addKeyListener(new TxtVLetras(vista.getTxtnombres()));
//        vista.getTxtsalario().addKeyListener(new TxtVNumeros(vista.getTxtsalario()));
//        
//    }
    
    public void nuevo(){
        vista.getBtnguardar().setEnabled(true);
        vista.getBtnmodificar().setEnabled(false);
        vista.getTxtcedula().setEditable(true);
        vista.getTxtcedula().setText("");
        vista.getTxtUsuario().setText("");
        vista.getTxtcontra().setText("");
        
        
    }
    
    public void guardar(){
        
        bdusuario.setNombre(vista.getTxtcedula().getText());
        bdusuario.setNombreUsuario(vista.getTxtUsuario().getText());
        bdusuario.setContrasenia((vista.getTxtcontra().getText()));
        if (vista.getTxtcedula().getText().equals("")||vista.getTxtUsuario().getText().equals("")||vista.getTxtcontra().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No puede haber campos vacios");
            nuevo();
        }else{
            if (bdusuario.guardar()) {
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            lista();
            nuevo();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
        }
        
    }
    
    public void eliminar(){
        int resp2 = JOptionPane.showConfirmDialog(null, "Confirme si esta seguro de eliminar el registro");
            if (resp2 == 0) {
                
                    if (bdusuario.eliminar(vista.getTxtcedula().getText())) {
                        JOptionPane.showMessageDialog(null, "Datos eliminados correctamente");
                        lista();
                        nuevo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar");
                    }
                

            }
    }

    

    public void modificar() {
        bdusuario.setNombre(vista.getTxtcedula().getText());
        bdusuario.setNombreUsuario(vista.getTxtUsuario().getText());
        bdusuario.setContrasenia((vista.getTxtcontra().getText()));
        
        int resp2 = JOptionPane.showConfirmDialog(null, "Confirme si esta seguro modificar");
        if (resp2 == 0) {
            if (bdusuario.modificar(vista.getTxtcedula().getText())) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }
    }
    
    
    public void seleccionar(){
        vista.getBtnguardar().setEnabled(false);
        vista.getBtnmodificar().setEnabled(true);
        vista.getTxtcedula().setEditable(false);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTableUsuario().getModel();
        String cedula = (String) modelo.getValueAt(vista.getTableUsuario().getSelectedRow(), 0);
        System.out.println(cedula);
        List<UsuarioMD> lista = bdusuario.obtenerDatos(cedula);
        bdusuario.setNombre(lista.get(0).getNombre());
        bdusuario.setNombreUsuario(lista.get(0).getNombreUsuario());
        bdusuario.setContrasenia(lista.get(0).getContrasenia());
        
        vista.getTxtcedula().setText(bdusuario.getNombre());
        vista.getTxtUsuario().setText(bdusuario.getNombreUsuario());
        vista.getTxtcontra().setText(bdusuario.getContrasenia());        
    }
    
    public void lista(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTableUsuario().getModel();
        List<UsuarioMD> lista = bdusuario.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTableUsuario().getRowCount()-1;j >= 0; j--) {
            modelo.removeRow(j);        }
        
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTableUsuario().setValueAt(lista.get(i).getNombre(), i, 0);
            vista.getTableUsuario().setValueAt(lista.get(i).getNombreUsuario(), i, 1);
            vista.getTableUsuario().setValueAt(lista.get(i).getContrasenia(), i, 2);            
            
        }
    }
    
}


