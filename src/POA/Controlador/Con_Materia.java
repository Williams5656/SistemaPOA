/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;
import POA.Vista.Vis_Materias;
import POA.Modelo.MateriaBD;
import POA.Modelo.MateriaMD;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author A
 */
public class Con_Materia {
    public static Vis_Materias vista;
    private MateriaBD materia = new MateriaBD();
    
    public Con_Materia(Vis_Materias vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.getBtncancelar().addActionListener(e -> cancelar());
        vista.getBtnguardar().addActionListener(e -> guardar());
        vista.getTablamateria().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
        listam();
    }
    
    public void guardar() {

        String nombre = (String) vista.getComboCarrera_mat().getSelectedItem();
        materia.setNombre_carrera(nombre);
        String eje = (String) vista.getComboejeformacion().getSelectedItem();
        materia.setEje_formacion(eje);
        materia.setCod_materia(vista.getTxtcodmateria().getText());
        materia.setNombre_materia(vista.getTxtnombremateria().getText());
        String ciclo = (String) vista.getCombociclo().getSelectedItem();
        materia.setCiclo(ciclo);
        materia.setCreditos(vista.getTxtcreditos().getText());
        String plan = (String) vista.getComboplan().getSelectedItem();
        materia.setPlan(plan);
        materia.setArea(vista.getTxtareacarrera().getText());

        if (materia.insertar()) {
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            listam();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
    }

    public void seleccionar() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablamateria().getModel();
        String codigo = (String) modelo.getValueAt(vista.getTablamateria().getSelectedRow(), 0);
        System.out.println(codigo);
        List<MateriaMD> lista = materia.obtenerdatos(codigo);
        materia.setNombre_carrera(lista.get(0).getNombre_carrera());
        materia.setEje_formacion(lista.get(0).getEje_formacion());
        materia.setCod_materia(lista.get(0).getCod_materia());
        materia.setNombre_materia(lista.get(0).getNombre_materia());
        materia.setCiclo(lista.get(0).getCiclo());
        materia.setCreditos(lista.get(0).getCreditos());
        materia.setPlan(lista.get(0).getPlan());
        materia.setArea(lista.get(0).getArea());

        vista.getComboCarrera_mat().setSelectedItem(materia.getNombre_carrera());
        vista.getComboejeformacion().setSelectedItem(materia.getEje_formacion());
        vista.getTxtcodmateria().setText(materia.getCod_materia());
        vista.getTxtnombremateria().setText(materia.getNombre_materia());
        vista.getCombociclo().setSelectedItem(materia.getCiclo());
        vista.getTxtcreditos().setText(materia.getCreditos());
        vista.getComboplan().setSelectedItem(materia.getPlan());
        vista.getTxtareacarrera().setText(materia.getArea());
    }

    public void listam() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablamateria().getModel();
        List<MateriaMD> lista = materia.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablamateria().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablamateria().setValueAt(lista.get(i).getNombre_carrera(), i, 0);
            vista.getTablamateria().setValueAt(lista.get(i).getEje_formacion(), i, 1);
            vista.getTablamateria().setValueAt(lista.get(i).getCod_materia(), i, 2);
            vista.getTablamateria().setValueAt(lista.get(i).getNombre_materia(), i, 3);
            vista.getTablamateria().setValueAt(lista.get(i).getCiclo(), i, 4);
            vista.getTablamateria().setValueAt(lista.get(i).getCreditos(), i, 5);
            vista.getTablamateria().setValueAt(lista.get(i).getPlan(), i, 6);
            vista.getTablamateria().setValueAt(lista.get(i).getArea(), i, 7);
        }
    }

    public void nuevo() {
        
        vista.getComboCarrera_mat().setSelectedItem("");
        vista.getComboejeformacion().setSelectedItem("");
        vista.getTxtcodmateria().setText("");
        vista.getTxtnombremateria().setText("");
        vista.getCombociclo().setSelectedItem("");
        vista.getTxtcreditos().setText("");
        vista.getComboplan().setSelectedItem("");
        vista.getTxtareacarrera().setText("");
    }
    
   public void cancelar() {
       
   }
   
}
