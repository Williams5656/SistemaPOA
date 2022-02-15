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
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.postgresql.util.Base64;

/**
 *
 * @author PC FACTORY
 */
public class RolBD extends RolMD{
    Conect conectar = new Conect();

    public RolBD() {
    }

    public RolBD(int numero_rol, int id_rol, String nombre_rol, String observaciones) {
        super(numero_rol, id_rol, nombre_rol, observaciones);
    }
    public List<RolMD> mostrardatos(){
        List<RolMD> listar = new  ArrayList<RolMD>();
        try{
            String sql = "select * from rol";
            ResultSet rs = conectar.query(sql);
            while (rs.next()){
                RolMD r = new RolMD();
                r.setNumero_rol(rs.getInt("numero_rol"));
                r.setId_rol(rs.getInt("id_rol"));
                r.setNombre_rol(rs.getString("nombre_rol"));
                r.setObservaciones(rs.getString("observaciones"));
                listar.add(r);
            }
            rs.close();
            return listar;
        }catch (Exception e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public List<RolMD> obtenerDatos(int id_rol){
        List<RolMD> listar = new  ArrayList<RolMD>();
        try{
            String sql = "select * from rol" + " where \"id_rol\"='" + id_rol + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()){
                RolMD r = new RolMD();
                r.setNumero_rol(rs.getInt("numero_rol"));
                r.setId_rol(rs.getInt("id_rol"));
                r.setNombre_rol(rs.getString("nombre_rol"));
                r.setObservaciones(rs.getString("observaciones"));
                listar.add(r);
            }
            rs.close();
            return listar;
        }catch (Exception e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public boolean insertar(){
       String nsql =  "INSERT INTO rol(numero_rol, id_rol, nombre_rol, observaciones)"+ "VALUES ('"+getNumero_rol()+ "','" + getId_rol() + "','" + getNombre_rol() + "','" + getObservaciones() + "')" ;
       if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }
    public boolean Modificar (int id_rol){
       String nsql = "update rol set \"nombre_rol\"='" + getNombre_rol() + "',\"observaciones\"='" + getObservaciones() + "'"
                + " where \"id_rol\"='" + id_rol + "'";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("ERROR AL EDITAR");
            return false;
        } 
    }
    public boolean Eliminar(int id_rol) {
        String nsql = " delete from rol where \"id_rol\"='" + id_rol + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error eliminar");
            return false;
        }
    }
}
