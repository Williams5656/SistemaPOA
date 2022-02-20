
package POA.Controlador;
import POA.Modelo.BaseDatosAsignacion;
import POA.Vista.*;
import POA.Modelo.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sebastian
 */
public class ControladorAsignacion {
    private Vis_Asignacion ventanaAsignacion;
    private BaseDatosAsignacion baseDatosAsignacion = new BaseDatosAsignacion();
    private DefaultTableModel model = new DefaultTableModel();
    private ArrayList<ModeloAsignacion> listaAsignados = new ArrayList<>();
    

    public ControladorAsignacion(Vis_Asignacion ventanaAsignacion) {
        this.ventanaAsignacion = ventanaAsignacion;
        
        ventanaAsignacion.setTitle("Asignación");
        
        ventanaAsignacion.getBtnGuardar().addActionListener(e -> guardar());
        
        
        
    }
    
    public void guardar(){
        
        baseDatosAsignacion.guardar(ventanaAsignacion.getTxtCedula().getText(), (String) ventanaAsignacion.getComboPerfil().getSelectedItem());
        lista();
        JOptionPane.showMessageDialog(null, "Guardado");
    }
    
    public void modificar(){
        int codigo = listaAsignados.get(ventanaAsignacion.getTablaAsignacion().getSelectedRow()).getId();
        baseDatosAsignacion.modificar(codigo, ventanaAsignacion.getTxtCedula().getText(), (String) ventanaAsignacion.getComboPerfil().getSelectedItem());
        lista();
        JOptionPane.showConfirmDialog(null, "Modificado");
    }
    
    public void lista(){
        model.setRowCount(0);
        model.setColumnCount(0);
        
        model.addColumn("Id");
        model.addColumn("Cédula Persona");
        model.addColumn("Perfil");
        
        listaAsignados = baseDatosAsignacion.mostrarDatos();
        for (ModeloAsignacion user : listaAsignados) {
            Object[] fila = new Object[3];
            fila[0] = user.getId();
            fila[1] = user.getCodigoPersona();
            fila[2] = user.getPerfil();
            
            model.addRow(fila);
        }
        
        ventanaAsignacion.getTablaAsignacion().setModel(model);

    }
    
    
}
