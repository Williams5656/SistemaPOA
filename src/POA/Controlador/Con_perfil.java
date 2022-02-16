/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.PerfilBD;
import POA.Modelo.PerfilMD;
import POA.Modelo.Validadores.Letras;
import POA.Vista.Vis_Perfil;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Con_perfil {

    private final Vis_Perfil vista;
    PerfilBD bdperfil = new PerfilBD();

    public Con_perfil(Vis_Perfil vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.getBtn_nuevo().addActionListener(e -> nuevo());
        vista.getBtn_guardar().addActionListener(e -> guardar());
        vista.getBtn_modificar().addActionListener(e -> modificar());
        vista.getBtn_eliminar().addActionListener(e -> eliminar());
        Letras.solo_letras(vista.getTxtNombre());
        vista.getTablaPerfil().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
        lista();
    }

    ;
    private void nuevo() {
        vista.getBtn_guardar().setEnabled(true);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_eliminar().setEnabled(false);
        vista.getTxtCodigo().setEditable(false);
        vista.getTxtCodigo().setText(String.valueOf(bdperfil.codigo()));
        vista.getTxtNombre().setText("");
        vista.getTxtDescripcion().setText("");
    }

    private void guardar() {
        if (vista.getTxtNombre().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE EL NOMBRE");
        } else if (vista.getTxtDescripcion().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE LA DESCRIPCION");
        } else  {
            bdperfil.setCodigo(Integer.parseInt(vista.getTxtCodigo().getText()));
            bdperfil.setNombre(vista.getTxtNombre().getText());
            bdperfil.setDescripcion(vista.getTxtDescripcion().getText());
            if (bdperfil.insertar()) {
                JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            }
        }

    }

    private void modificar() {
        vista.getTxtCodigo().setEnabled(false);
        bdperfil.setNombre(vista.getTxtNombre().getText());
        bdperfil.setDescripcion(vista.getTxtDescripcion().getText());
        int resp2 = JOptionPane.showConfirmDialog(null, "CONFIRME SI ESTA SEGURO DE MODIFICAR");
        if (resp2 == 0) {
            if (bdperfil.modificar(vista.getTxtCodigo().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR");
            }
        }
    }

    private void eliminar() {
        int resp2 = JOptionPane.showConfirmDialog(null, "CONFIRME SI ESTA SEGURO DE MODIFICAR");
        if (resp2 == 0) {
            if (bdperfil.eliminar(vista.getTxtCodigo().getText())) {
                JOptionPane.showMessageDialog(null, "ELIMINADO CORRECTAMENTE");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
            }
        }

    }

    private void seleccionar() {
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
        vista.getBtn_guardar().setEnabled(false);
        vista.getTxtCodigo().setEditable(false);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaPerfil().getModel();
        String maquillaje = (String) modelo.getValueAt(vista.getTablaPerfil().getSelectedRow(), 0);
        List<PerfilMD> lista = bdperfil.obtenerdatos(maquillaje);
        bdperfil.setCodigo(lista.get(0).getCodigo());
        bdperfil.setNombre(lista.get(0).getNombre());
        bdperfil.setDescripcion(lista.get(0).getDescripcion());

        vista.getTxtCodigo().setText(bdperfil.getCodigo() + "");
        vista.getTxtNombre().setText(bdperfil.getNombre());
        vista.getTxtDescripcion().setText(bdperfil.getDescripcion());
    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaPerfil().getModel();
        List<PerfilMD> lista = bdperfil.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablaPerfil().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }

        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablaPerfil().setValueAt(lista.get(i).getCodigo(), i, 0);
            vista.getTablaPerfil().setValueAt(lista.get(i).getNombre(), i, 1);
            vista.getTablaPerfil().setValueAt(lista.get(i).getDescripcion(), i, 2);
        }
    }
}
