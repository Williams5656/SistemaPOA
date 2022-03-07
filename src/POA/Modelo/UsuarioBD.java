/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JOptionPane;
import org.postgresql.util.Base64;
/**
 *
 * @author Renato Llivisaca
 */
public class UsuarioBD extends UsuarioMD {
    Conect conectar = new Conect();

    public UsuarioBD(String cedula, String nombreUsuario, String contrasenia, int rol, String estado) {
        super(cedula, nombreUsuario, contrasenia, rol, estado);
    }

   

    public UsuarioBD() {
        
    }
    
  public List<UsuarioMD> mostrardatos() {
        List<UsuarioMD> listaA = new ArrayList<UsuarioMD>();
        try {
            String sql = "select * from usuario";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                UsuarioMD m = new UsuarioMD();
                m.setCedula(rs.getString("cedula"));
                m.setNombreUsuario(rs.getString("usuario"));
                m.setContrasenia(rs.getString("contrasenia"));
                m.setRol(rs.getInt("rol"));
                m.setEstado(rs.getString("estado"));
                
                listaA.add(m);
            }
            rs.close();
            return listaA;
        } catch (Exception e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }


  public boolean guardar() {
       
        String nsql = "INSERT INTO usuario(cedula,usuario,contrasenia,rol,estado)" + "VALUES ('" + getCedula()+ "','" + getNombreUsuario()+ "','" + getContrasenia()+ "','" + getRol()+"','" + getEstado()+ "')";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }
  
   public boolean modificar(String cedula){
          //Transformo image a base64 encode para postgresl
        
            String nsql= "update usuario set \"usuario\"='"+getNombreUsuario()+  "',\"contrasenia\"='"+getContrasenia()+ "',\"rol\"='"+getRol()+  "'" 
                    + " where \"cedula\"='"+cedula+"'";
            
            if(conectar.noQuery(nsql)==null){
                return true;
                }
                else{
                    System.out.println("error al editar");
                     return false;
                }
            
            }
   
    
    
    public List<UsuarioMD> obtenerDatos(String cedula) {
        List<UsuarioMD> listaA = new ArrayList<UsuarioMD>();
        try {
            String sql = "select * from usuario" + " where \"cedula\"='"+cedula+"'";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                UsuarioMD m = new UsuarioMD();
                m.setCedula(rs.getString("cedula"));
                m.setNombreUsuario(rs.getString("usuario"));
                m.setContrasenia(rs.getString("contrasenia"));
                m.setRol(rs.getInt("rol"));
                m.setEstado(rs.getString("estado"));
                listaA.add(m);
            }
            rs.close();
            return listaA;
        } catch (Exception e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }

    }
    
    public boolean desactivar(String cedula) {
        String sql = "UPDATE usuario set \"estado\"='" + "Inactivo" + "'"
                + " where \"cedula\"='" + cedula + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public boolean activar(String cedula) {
        String sql = "UPDATE usuario set \"estado\"='" + "Activo" + "'"
                + " where \"cedula\"='" + cedula + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
    public int rol(String usuario, String contra) throws SQLException{
        System.out.println("tengo suezzzzzz");
        String sql = "select rol from usuario where usuario = '"+usuario+"' and contrasenia= '"+contra+"'";
        ResultSet rs = conectar.query(sql);      
        if (rs.next()) {
            return rs.getInt("rol");          
        } else {
            JOptionPane.showMessageDialog(null, "ERROR USUARIO NO REGISTRADO", "", 2);
        }
        rs.close();
        return 0;
    }
    
  
}
