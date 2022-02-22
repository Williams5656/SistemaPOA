/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.PersonaBD;
import POA.Modelo.PersonaMD;
import POA.Controlador.Con_rol;
import POA.Modelo.RolBD;
import POA.Modelo.RolMD;
import POA.Modelo.UsuarioBD;
import POA.Modelo.UsuarioMD;
import POA.Vista.Vis_Usuario;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
        vista.getLblmensaje().setVisible(true);
        vista.getBtnnuevo().addActionListener(e->nuevo());
        vista.getBtnguardar().addActionListener(e->guardar());
        vista.getBtnmodificar().addActionListener(e->modificar());
        vista.getBtneliminar().addActionListener(e->cambiarestado());
        vista.getBtncedula().addActionListener(e->buscarced());
        vista.getComborol().addActionListener(e-> roles());
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
    
    public void roles(){
        RolBD bdrol = new RolBD();
        List<RolMD> listar = bdrol.mostrardatos();
        
        for (int i = 0; i < listar.size(); i++) {
            vista.getComborol().addItem(listar.get(i).getNombre_rol());
        }
    }
    public void buscarced(){
        PersonaBD dbp = new PersonaBD();
        List<PersonaMD> lista = dbp.mostrardatos();
        UsuarioBD dbpu = new UsuarioBD();
        List<UsuarioMD> listau = dbpu.mostrardatos();
        for (int i = 0; i < lista.size(); i++) {
            
            if (vista.getTxtcedula().getText().equals(lista.get(i).getCedula())) {
                vista.getLblmensaje().setVisible(false);
                for (int j = 0; j < listau.size(); j++) {
                    if (vista.getTxtcedula().getText().equals(listau.get(j).getCedula())) {
                        cedexistente();
                    }else{
                        vista.getLblnombre().setText(lista.get(i).getNombres()+" "+lista.get(i).getApellidos());
                        cedcorrect();
                    }
                    
                    
                    
                }  
            }else{
                
                
            }
           
        }
        
        
    }
    public void cedexistente(){
        
        vista.getTxtcedula().setEditable(true);
        vista.getTxtcedula().setEditable(false);
        vista.getTxtUsuario().setEditable(false);
        vista.getTxtcontra().setEditable(false);
        vista.getLblmensaje().setVisible(false);
        vista.getLblnombre().setText("");
        vista.getComboestado().setEnabled(false);
        
        
    }
    public void cedcorrect(){
        
        vista.getTxtcedula().setEditable(true);
        vista.getTxtcedula().setEditable(true);
        vista.getTxtUsuario().setEditable(true);
        vista.getTxtcontra().setEditable(true);
        vista.getLblmensaje().setVisible(false);
        vista.getComboestado().setEnabled(true);
        
        
    }
    
    
    public void nuevo(){
        vista.getBtnguardar().setEnabled(true);
        vista.getBtnmodificar().setEnabled(false);
        vista.getTxtcedula().setEditable(true);
        vista.getTxtcedula().setText("");
        vista.getTxtUsuario().setText("");
        vista.getTxtcontra().setText("");
        vista.getLblmensaje().setVisible(true);
        vista.getLblnombre().setText("");
        vista.getComboestado().setSelectedIndex(0);
        
        
    }
    
    public void guardar(){
        
        bdusuario.setCedula(vista.getTxtcedula().getText());
        bdusuario.setNombreUsuario(vista.getTxtUsuario().getText());
        bdusuario.setContrasenia((vista.getTxtcontra().getText()));
        String estado = (String) vista.getComboestado().getSelectedItem();
        bdusuario.setEstado(estado);
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
    
    public void cambiarestado() {
        String estado = (String) vista.getComboestado().getSelectedItem();
       
            int resp2 = JOptionPane.showConfirmDialog(null, "Confirme si esta seguro el cambio de estado");
            if (resp2 == 0) {
                if (estado.equals("Activo")) {
                    if (bdusuario.desactivar(vista.getTxtcedula().getText())) {
                        JOptionPane.showMessageDialog(null, "Datos desactivados correctamente");
                        lista();
                        nuevo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al desactivar");
                    }
                }
                
                if (estado.equals("Inactivo")) {
                    if (bdusuario.activar(vista.getTxtcedula().getText())) {
                        JOptionPane.showMessageDialog(null, "Datos activados correctamente");
                        lista();
                        nuevo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al desactivar");
                    }
                }

            }
        

        
            
               

            
        

    }

    

    public void modificar() {
        bdusuario.setCedula(vista.getTxtcedula().getText());
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
        bdusuario.setCedula(lista.get(0).getCedula());
        bdusuario.setNombreUsuario(lista.get(0).getNombreUsuario());
        bdusuario.setContrasenia(lista.get(0).getContrasenia());
        bdusuario.setEstado(lista.get(0).getEstado());
        
        
        vista.getTxtcedula().setText(bdusuario.getCedula());
        vista.getTxtUsuario().setText(bdusuario.getNombreUsuario());
        vista.getTxtcontra().setText(bdusuario.getContrasenia());     
        vista.getComboestado().setSelectedItem(bdusuario.getEstado());
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
            vista.getTableUsuario().setValueAt(lista.get(i).getCedula(), i, 0);
            vista.getTableUsuario().setValueAt(lista.get(i).getNombreUsuario(), i, 1);
            vista.getTableUsuario().setValueAt(lista.get(i).getContrasenia(), i, 2);
            vista.getTableUsuario().setValueAt(lista.get(i).getEstado(), i, 3);            
            
        }
    }
    
}


