
package POA.Controlador;
import POA.Modelo.BaseDatosAsignacion;
import POA.Vista.*;
import POA.Modelo.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sebastian
 */
public class ControladorAsignacion {
    private final Vis_Asignacion ventanaAsignacion;
    private BaseDatosAsignacion baseDatosAsignacion = new BaseDatosAsignacion();
    private PersonaBD baseDatosPersona = new PersonaBD();
    private DefaultTableModel model = new DefaultTableModel();
    private ArrayList<ModeloAsignacion> listaAsignados = new ArrayList<>();
    private List<PersonaMD> listaPersonas = new ArrayList<>();
    private List<PerfilMD> listaPerfiles = new ArrayList<>();
    private PerfilBD baseDatosPerfil = new PerfilBD();
    private String codigoPerfil;

    public ControladorAsignacion(Vis_Asignacion ventanaAsignacion) {
        this.ventanaAsignacion = ventanaAsignacion;
        
        cargarComboPerfil();

        ventanaAsignacion.setTitle("Asignación");
        ventanaAsignacion.setVisible(true);
        lista();
        
        ventanaAsignacion.getBtnModificar().setEnabled(false);
   
        ventanaAsignacion.getBtnGuardar().addActionListener(e -> guardar());
        ventanaAsignacion.getBtnModificar().addActionListener(e -> modificar());
        ventanaAsignacion.getPanel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nuevo();
            };
        
        });
        
        ventanaAsignacion.getTablaAsignacion().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            };
        
        });
        
        ventanaAsignacion.getTxtCedula().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                mostrarNombrePersona();
            }
            
        });

    }
    
    public void guardar(){
        listaPersonas = baseDatosPersona.mostrardatos();
        boolean existente = false;
        String perfilCombo = (String) ventanaAsignacion.getComboPerfil().getSelectedItem();
        int codigoPerfil = 0;
        boolean perfilRepetido = false;
        
        String perfilesCombo = (String) ventanaAsignacion.getComboPerfil().getSelectedItem();
        boolean encontrado = false;
        
        for (PerfilMD perfil : listaPerfiles){
            if (perfilesCombo.equals(perfil.getNombre())){
                codigoPerfil = perfil.getCodigo();     
                
            }
            for (ModeloAsignacion asignacion : listaAsignados){
                if (perfil.getCodigo() == asignacion.getPerfil()){
                    if (perfil.getNombre().equals(perfilesCombo) && !perfil.getNombre().equalsIgnoreCase("Docente")){
                        perfilRepetido = true;
                        }
                    }
            }
        }
 
        listaPerfiles = baseDatosPerfil.mostrardatos();
        for (PerfilMD perfil : listaPerfiles){
            if (perfil.getNombre().equals(perfilCombo))
                codigoPerfil = perfil.getCodigo();
        }
        
        for (PersonaMD person : listaPersonas){
            if (person.getCedula().equals(ventanaAsignacion.getTxtCedula().getText())){
                existente = true;
                if (person.getEstado().equals("ACTIVO")
                    && !perfilRepetido){
                
                    baseDatosAsignacion.guardar(ventanaAsignacion.getTxtCedula().getText(), codigoPerfil);
                    lista();
                    JOptionPane.showMessageDialog(null, "Guardado");
                
                }
            }   
        }
        
        if (!existente)
            JOptionPane.showMessageDialog(null, "Persona no existente o inactiva");
        if (perfilRepetido)
               JOptionPane.showMessageDialog(null, "Perfil repetido");
        nuevo();
    }
    
    public void modificar(){
        int codigoPerfil = 0;
        boolean perfilRepetido = false;
        
        String perfilesCombo = (String) ventanaAsignacion.getComboPerfil().getSelectedItem();
        boolean encontrado = false;
        
        for (PerfilMD perfil : listaPerfiles){
            if (perfilesCombo.equals(perfil.getNombre())){
                codigoPerfil = perfil.getCodigo();
            }
        }
        int codigo = listaAsignados.get(ventanaAsignacion.getTablaAsignacion().getSelectedRow()).getId();
        
        for (PerfilMD perfil : listaPerfiles){
            if (perfilesCombo.equals(perfil.getNombre())){
                codigoPerfil = perfil.getCodigo();     
                
            }
            for (ModeloAsignacion asignacion : listaAsignados){
                if (perfil.getCodigo() == asignacion.getPerfil()){
                    if (perfil.getNombre().equals(perfilesCombo) && !perfil.getNombre().equalsIgnoreCase("Docente")){
                        perfilRepetido = true;
                        }
                    }
            }
        }
        
        if (!perfilRepetido){
            baseDatosAsignacion.modificar(codigo, ventanaAsignacion.getTxtCedula().getText(), codigoPerfil);
            lista();
            JOptionPane.showMessageDialog(null, "Modificado");
        }
        else{
            JOptionPane.showMessageDialog(null, "Perfil repetido");
        }
        
        
    }
    
    public void lista(){
        model.setRowCount(0);
        model.setColumnCount(0);
        
        model.addColumn("Id");
        model.addColumn("Cédula Persona");
        model.addColumn("Perfil");
 
        Object[] fila = new Object[3];
        
        listaAsignados = baseDatosAsignacion.mostrarDatos();
        for (ModeloAsignacion user : listaAsignados) {
            
            fila[0] = user.getId();
            fila[1] = user.getCodigoPersona();
            
            for (PerfilMD perfil : listaPerfiles){
                if (perfil.getCodigo() == user.getPerfil()){
                    fila[2] = perfil.getNombre();
                }
        }  
            model.addRow(fila);
        }
        
        listaPerfiles = baseDatosPerfil.mostrardatos();
        ventanaAsignacion.getTablaAsignacion().setModel(model);

    }
    
    public void seleccionar(){
        ventanaAsignacion.getBtnModificar().setEnabled(true);
        ventanaAsignacion.getBtnGuardar().setEnabled(false);
        
        int seleccionado = ventanaAsignacion.getTablaAsignacion().getSelectedRow();
        ventanaAsignacion.getTxtCedula().setText(listaAsignados.get(seleccionado).getCodigoPersona());
        
        for (PerfilMD perfil : listaPerfiles){
            if (perfil.getCodigo() == listaAsignados.get(seleccionado).getPerfil()){
                ventanaAsignacion.getComboPerfil().setSelectedItem(perfil.getNombre());
            }
        }
    }
    
    public void cargarComboPerfil(){
        ventanaAsignacion.getComboPerfil().removeAllItems();
        ventanaAsignacion.getComboPerfil().addItem("");
        listaPerfiles = baseDatosPerfil.mostrardatos();
        for (PerfilMD perfil : listaPerfiles){
            ventanaAsignacion.getComboPerfil().addItem(perfil.getNombre());
        }
    }
    
    public void nuevo(){
        ventanaAsignacion.getTxtCedula().setText("");
        ventanaAsignacion.getComboPerfil().setSelectedIndex(0);
        ventanaAsignacion.getBtnModificar().setEnabled(false);
        ventanaAsignacion.getBtnGuardar().setEnabled(true);
        
        ventanaAsignacion.getTablaAsignacion().setCellSelectionEnabled(false);
    }
    
    public void mostrarNombrePersona(){
        for (PersonaMD person : listaPersonas){
            if (person.getCedula().equals(ventanaAsignacion.getTxtCedula().getText())){
                ventanaAsignacion.getLblNombre().setText(person.getNombres() + " " + person.getApellidos());
            }
        }
    }

}
