/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.postgresql.util.Base64;

/**
 *
 * @author A
 */
public class MateriaBD extends MateriaMD{
    Conect conectar = new Conect();

    public MateriaBD(String nombre_carrera, String eje_formacion, String cod_materia, String nombre_materia, String ciclo, String creditos, String plan, String area) {
        super(nombre_carrera, eje_formacion, cod_materia, nombre_materia, ciclo, creditos, plan, area);
    }
    
    public MateriaBD() {
    }

    public List<MateriaMD> mostrardatos() {
        try {
            List<MateriaMD> lista = new ArrayList<MateriaMD>();
            String sql = "select * from materia";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                MateriaMD m = new MateriaMD();
                m.setNombre_carrera(rs.getString("nombre"));
                m.setEje_formacion(rs.getString("eje"));
                m.setCod_materia(rs.getString("codigo"));
                m.setNombre_materia(rs.getString("materia"));
                m.setCiclo(rs.getString("ciclo"));
                m.setCreditos(rs.getString("creditos"));
                m.setPlan(rs.getString("plan"));
                m.setArea(rs.getString("area"));
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(MateriaMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<MateriaMD> obtenerdatos(String cod_materia) {
        try {
            List<MateriaMD> lista = new ArrayList<MateriaMD>();
            String sql = "select * from materia" + " where \"codigo\"='" + cod_materia + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                MateriaMD m = new MateriaMD();
                m.setNombre_carrera(rs.getString("nombre"));
                m.setEje_formacion(rs.getString("eje"));
                m.setCod_materia(rs.getString("codigo"));
                m.setNombre_materia(rs.getString("materia"));
                m.setCiclo(rs.getString("ciclo"));
                m.setCreditos(rs.getString("creditos"));
                m.setPlan(rs.getString("plan"));
                m.setArea(rs.getString("area"));
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(MateriaMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {

        String nsql = "INSERT INTO materia(nombre,eje,codigo,materia,ciclo,creditos,plan,area)" + "VALUES ('" + getNombre_carrera() + "','" + getEje_formacion()+ "','" + getCod_materia()+ "','" + getNombre_materia()+ "','" + getCiclo()+ "','" + getCreditos() + "','" + getPlan() + "','" + getArea()+ "')";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }

//    public boolean modificar(String codigo_materia) {
//
//        String nsql = "UPDATE materia SET \n"
//                + "  nombre = '" + getNombre_carrera() + "',eje ='" + getEje_formacion()+ "',codigo ='" + getCod_materia()+ "',materia ='" + getNombre_materia()+ "',ciclo ='" + getCiclo() + "',credito ='" + getCreditos()+ "',plan ='"+ getPlan()+ "'\n"
//                + "WHERE \"codigo\"='" + codigo_materia + "'";
//        if (conectar.noQuery(nsql) == null) {
//            return true;
//        } else {
//            System.out.println("Error");
//            return false;
//        }
//    }

//    public boolean Eliminar(String codigo_carrera) {
//        String nsql = " delete from carrera where \"codigo\"='" + codigo_carrera + "'";
//        if (conectar.noQuery(nsql) == null) {
//            return true;
//        } else {
//            System.out.println("error eliminar");
//            return false;
//        }
//    }

}
