package POA.Controlador;

import POA.Vista.Vis_Carrera;
import POA.Modelo.CarreraMD;
import POA.Modelo.CarreraBD;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class con_carrera {

    private final Vis_Carrera vista;
    private CarreraBD carrera = new CarreraBD();

    public con_carrera(Vis_Carrera vista) {
        this.vista = vista;
        vista.setVisible(true);
       //vista.setLocationRelativeTo(null);

        vista.getBtnNuevo().addActionListener(e -> nuevo());
        vista.getBtnGuardar().addActionListener(e -> guardar());
        vista.getBtnModificar().addActionListener(e -> modificar());
        vista.getBtnEliminar().addActionListener(e -> eliminar());
     

        vista.getTablaCarrera().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
        listam();

    }

    public void guardar() {

        carrera.setNombre_carrera(vista.getTxtNombre_carrera().getText());
        carrera.setCodigo_carrera(vista.getTxtCodigo_carrera().getText());
        carrera.setFecha_inicio(vista.getTxtFecha_inicio().getText());
        String modalidad = (String) vista.getCmbModalidad().getSelectedItem();
        carrera.setModalidad(modalidad);
        carrera.setCoordinador(vista.getTxtCoordinador().getText());

//        String horario = (String) vista.getCmbHorario().getSelectedItem();
//        carrera.setHorario(horario);

        if (carrera.insertar()) {
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            listam();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }

    }

    public void seleccionar() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaCarrera().getModel();
        String codigo = (String) modelo.getValueAt(vista.getTablaCarrera().getSelectedRow(), 0);
        System.out.println(codigo);
        List<CarreraMD> lista = carrera.obtenerdatos(codigo);
        carrera.setCodigo_carrera(lista.get(0).getCodigo_carrera());
        carrera.setNombre_carrera(lista.get(0).getNombre_carrera());
        carrera.setFecha_inicio(lista.get(0).getFecha_inicio());
        carrera.setModalidad(lista.get(0).getModalidad());
        carrera.setCoordinador(lista.get(0).getCoordinador());
//        carrera.setHorario(lista.get(0).getHorario());

        vista.getTxtCodigo_carrera().setText(carrera.getCodigo_carrera());
        vista.getTxtNombre_carrera().setText(carrera.getNombre_carrera());
        vista.getTxtFecha_inicio().setText(carrera.getFecha_inicio());
        vista.getCmbModalidad().setSelectedItem(carrera.getModalidad());
        vista.getTxtCoordinador().setText(carrera.getCoordinador());
//        vista.getCmbHorario().setSelectedItem(carrera.getHorario());

    }

    public void listam() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaCarrera().getModel();
        List<CarreraMD> lista = carrera.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablaCarrera().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }

        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablaCarrera().setValueAt(lista.get(i).getCodigo_carrera(), i, 0);
            vista.getTablaCarrera().setValueAt(lista.get(i).getNombre_carrera(), i, 1);
            vista.getTablaCarrera().setValueAt(lista.get(i).getFecha_inicio(), i, 2);
            vista.getTablaCarrera().setValueAt(lista.get(i).getModalidad(), i, 3);
            vista.getTablaCarrera().setValueAt(lista.get(i).getCoordinador(), i, 4);
//            vista.getTblCarrera().setValueAt(lista.get(i).getHorario(), i, 4);

        }

    }

    public void modificar() {
        carrera.setNombre_carrera(vista.getTxtNombre_carrera().getText());
        carrera.setCodigo_carrera(vista.getTxtCodigo_carrera().getText());
        carrera.setFecha_inicio(vista.getTxtFecha_inicio().getText());
        String modalidad = (String) vista.getCmbModalidad().getSelectedItem();
        carrera.setModalidad(modalidad);
        carrera.setCoordinador(vista.getTxtCoordinador().getText());
//        String horario = (String) vista.getCmbHorario().getSelectedItem();
//        carrera.setHorario(horario);
        int resp2 = JOptionPane.showConfirmDialog(null, "CONFIRME SI DESEA MODIFICAR");
        if (resp2 == 0) {
            if (carrera.modificar(vista.getTxtCodigo_carrera().getText())) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                listam();
                nuevo();

            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }

        }

    }

    public void eliminar() {
        int resp1 = JOptionPane.showConfirmDialog(null, "CONFIRME SI DESEA ELMINAR");
        if (resp1 == 0) {
            if (carrera.Eliminar(vista.getTxtCodigo_carrera().getText())) {

                JOptionPane.showMessageDialog(null, "Datos actualizados");
                listam();
                nuevo();

            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
            }

        }
    }

    public void nuevo() {

        vista.getTxtCodigo_carrera().setText("");
        vista.getTxtNombre_carrera().setText("");
        vista.getTxtFecha_inicio().setText("");
        vista.getCmbModalidad().setSelectedItem("");
        vista.getTxtCoordinador().setText("");
//        vista.getCmbHorario().setSelectedItem("");
    }

    public void buscar_nc() {
        if (vista.getTxtNombre_carrera().getText().equals("")) {
            listam();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTablaCarrera().getModel();
            List<CarreraMD> listac = carrera.mostrardatos();
            int columnas = modelo.getColumnCount();
            for (int j = vista.getTablaCarrera().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
                for (int i = 0; i < listac.size(); i++) {
                    if (listac.get(i).getCodigo_carrera().equals(vista.getTxtNombre_carrera().getText())) {
                        modelo.addRow(new Object[columnas]);
                        vista.getTablaCarrera().setValueAt(listac.get(i).getCodigo_carrera(), i, 0);
                        vista.getTablaCarrera().setValueAt(listac.get(i).getNombre_carrera(), i, 1);
                        vista.getTablaCarrera().setValueAt(listac.get(i).getFecha_inicio(), i, 2);
                        vista.getTablaCarrera().setValueAt(listac.get(i).getModalidad(), i, 3);
                        vista.getTablaCarrera().setValueAt(listac.get(i).getCoordinador(), i, 4);
                    }
                }
            }
        }
        nuevo();
    }
       
    public void buscar_c() {
        if (vista.getTxtCoordinador().getText().equals("")) {
            listam();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTablaCarrera().getModel();
            List<CarreraMD> listac = carrera.mostrardatos();
            int columnas = modelo.getColumnCount();
            for (int j = vista.getTablaCarrera().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
                for (int i = 0; i < listac.size(); i++) {
                    if (listac.get(i).getCodigo_carrera().equals(vista.getTxtCoordinador().getText())) {
                        modelo.addRow(new Object[columnas]);
                        vista.getTablaCarrera().setValueAt(listac.get(i).getCodigo_carrera(), i, 0);
                        vista.getTablaCarrera().setValueAt(listac.get(i).getNombre_carrera(), i, 1);
                        vista.getTablaCarrera().setValueAt(listac.get(i).getFecha_inicio(), i, 2);
                        vista.getTablaCarrera().setValueAt(listac.get(i).getModalidad(), i, 3);
                        vista.getTablaCarrera().setValueAt(listac.get(i).getCoordinador(), i, 4);
                    }
                }
            }
        }
        nuevo();
    }
}
