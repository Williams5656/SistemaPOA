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
import org.postgresql.util.Base64;
/**
 *
 * @author Renato Llivisaca
 */
public class UsuarioBD extends UsuarioMD {
    Conect conectar = new Conect();

    public UsuarioBD(String nombre, String nombreUsuario, String contrasenia, String estado) {
        super(nombre, nombreUsuario, contrasenia, estado);
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
                m.setNombre(rs.getString("nombre"));
                m.setNombreUsuario(rs.getString("usuario"));
                m.setContrasenia(rs.getString("contrasenia"));
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
       
        String nsql = "INSERT INTO usuario(nombre,usuario,contrasenia,estado)" + "VALUES ('" + getNombre()+ "','" + getNombreUsuario()+ "','" + getContrasenia()+ "','" + getEstado()+ "')";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }
  
   public boolean modificar(String nombre){
          //Transformo image a base64 encode para postgresl
        
            String nsql= "update usuario set \"usuario\"='"+getNombreUsuario()+  "',\"contrasenia\"='"+getContrasenia()+ "'" 
                    + " where \"nombre\"='"+nombre+"'";
            
            if(conectar.noQuery(nsql)==null){
                return true;
                }
                else{
                    System.out.println("error al editar");
                     return false;
                }
            
            }
   
    
    
    public List<UsuarioMD> obtenerDatos(String nombre) {
        List<UsuarioMD> listaA = new ArrayList<UsuarioMD>();
        try {
            String sql = "select * from usuario" + " where \"nombre\"='"+nombre+"'";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                UsuarioBD m = new UsuarioBD();
                m.setNombre(rs.getString("nombre"));
                m.setNombreUsuario(rs.getString("usuario"));
                m.setContrasenia(rs.getString("contrasenia"));
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
    
    public boolean desactivar(String nombre) {
        String sql = "UPDATE usuario set \"estado\"='" + "Inactivo" + "'"
                + " where \"nombre\"='" + nombre + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public boolean activar(String nombre) {
        String sql = "UPDATE usuario set \"estado\"='" + "Activo" + "'"
                + " where \"nombre\"='" + nombre + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

  
}
