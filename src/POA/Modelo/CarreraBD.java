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
 * @author DANNY
 */
public class CarreraBD extends CarreraMD {

    Conect conectar = new Conect();

    public CarreraBD(String nombre_carrera, String codigo_carrera, String fecha_inicio, String modalidad, String horario) {
        super(nombre_carrera, codigo_carrera, fecha_inicio, modalidad, horario);
    }

    public CarreraBD() {
    }

    public List<CarreraMD> mostrardatos() {
        try {
            List<CarreraMD> lista = new ArrayList<CarreraMD>();
            String sql = "select * from carrera";
            ResultSet rs = conectar.query(sql);
//            byte[] is;
            while (rs.next()) {
                CarreraMD m = new CarreraMD();
                m.setNombre_carrera(rs.getString("nombre"));
                m.setCodigo_carrera(rs.getString("codigo"));
                m.setFecha_inicio(rs.getString("fecha_inicio"));
                m.setModalidad(rs.getString("modalidad"));
                m.setHorario(rs.getString("horario"));

                lista.add(m);

            }
            rs.close();
            return lista;
        } catch (SQLException e) {

            Logger.getLogger(CarreraMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<CarreraMD> obtenerdatos(String codigo_carrera) {
        try {
            List<CarreraMD> lista = new ArrayList<CarreraMD>();
            String sql = "select * from carrera" + " where \"codigo\"='" + codigo_carrera + "'";
            ResultSet rs = conectar.query(sql);
//            byte[] is;
            while (rs.next()) {
                CarreraMD m = new CarreraMD();
                m.setNombre_carrera(rs.getString("nombre"));
                m.setCodigo_carrera(rs.getString("codigo"));
                m.setFecha_inicio(rs.getString("fecha_inicio"));
                m.setModalidad(rs.getString("modalidad"));
                m.setHorario(rs.getString("horario"));

                lista.add(m);

            }
            rs.close();
            return lista;
        } catch (SQLException e) {

            Logger.getLogger(CarreraMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {

        String nsql = "INSERT INTO carrera(nombre,codigo,fecha_inicio,modalidad,horario)" + "VALUES ('" + getNombre_carrera() + "','" + getCodigo_carrera() + "','" + getFecha_inicio() + "','" + getModalidad() + "','" + getHorario() + "')";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String placa) {

        String nsql = "UPDATE carrera SET \n"
                + "  nombre = '" + getNombre_carrera() + "',fecha_inicio ='" + getFecha_inicio() + "',modalidad ='" + getModalidad() + "',horario ='" + getHorario() + "'\n"
                + "WHERE  ='" + getCodigo_carrera() + "';";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;

        }
    }

    public boolean Eliminar(String codigo) {
        String nsql = " delete from carrera where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error eliminar");
            return false;
        }
    }

}
