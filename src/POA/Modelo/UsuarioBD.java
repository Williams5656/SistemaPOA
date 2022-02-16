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
import sun.util.logging.PlatformLogger;
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

    public UsuarioBD(String nombre, String nombreUsuario, String contrasenia) {
        super(nombre, nombreUsuario, contrasenia);
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
                UsuarioBD m = new UsuarioBD();
                m.setNombre(rs.getString("cedula"));
                m.setNombreUsuario(rs.getString("usuario"));
                m.setContrasenia(rs.getString("contrasenia"));
                
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
       
        String nsql = "INSERT INTO usuario(cedula,usuario,contrasenia)" + "VALUES ('" + getNombreUsuario()+ "','" + getNombreUsuario()+ "','" + getContrasenia()+ "')";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }
  
   public boolean modificar(String cedula){
          //Transformo image a base64 encode para postgresl
        
            String nsql= "update usuario set \"usuario\"='"+getNombreUsuario()+  "',\"contrasenia\"='"+getContrasenia()+ "'" 
                    + " where \"cedula\"='"+cedula+"'";
            
            if(conectar.noQuery(nsql)==null){
                return true;
                }
                else{
                    System.out.println("error al editar");
                     return false;
                }
            
            }
   
    public boolean eliminar(String cedula){
                String nsql= "delete from usuario where \"cedula\"='" + cedula + "'";
                if(conectar.noQuery(nsql)==null){
                return true;
                }
                else{
                    System.out.println("error eliminar");
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
                UsuarioBD m = new UsuarioBD();
                m.setNombre(rs.getString("cedula"));
                m.setNombreUsuario(rs.getString("usuario"));
                m.setContrasenia(rs.getString("contrsenia"));
                listaA.add(m);
            }
            rs.close();
            return listaA;
        } catch (Exception e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }

    }

  
}
