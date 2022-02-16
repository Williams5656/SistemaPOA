/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.Base64;

/**
 *
 * @author Usuario
 */
public class PerfilBD extends PerfilMD {

    Conect conectar = new Conect();

    public PerfilBD(String codigo, String nombre, String descripcion) {
        super(codigo, nombre, descripcion);
    }

    

    public PerfilBD() {
    }

    public int codigo() {
        try {
            int c = 0;
            String sql = "select max(codigo) as codigo from perfil";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                c = rs.getInt("codigo");
            }
            return c + 1;
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public List<PerfilMD> mostrardatos() {
        try {
            List<PerfilMD> lista = new ArrayList<PerfilMD>();
            String sql = "select * from perfil";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                PerfilMD perfil = new PerfilMD();
                perfil.setCodigo(rs.getString("codigo"));
                perfil.setNombre(rs.getString("nombre"));
                perfil.setDescripcion(rs.getString("descripcion"));
                lista.add(perfil);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<PerfilMD> obtenerdatos(String identificador) {
        try {
            List<PerfilMD> lista = new ArrayList<PerfilMD>();
            String sql = "select * from perfil" + " where \"codigo\"='" + identificador + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                PerfilMD perfil = new PerfilMD();
                perfil.setCodigo(rs.getString("codigo"));
                perfil.setNombre(rs.getString("nombre"));
                perfil.setDescripcion(rs.getString("descripcion"));
                lista.add(perfil);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public boolean insertar() {
        String sql = "INSERT INTO perfil(codigo, nombre,descripcion)" + "VALUES ('" + getCodigo() + "','" + getNombre() + "','" + getDescripcion() + "')";
        System.out.println(sql);
        
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }
        public boolean modificar(String identificador) {
        String sql = "update perfil set \"nombre\"='"+getNombre()+ "',\"descripcion\"='" + getDescripcion()+"'"
                + " where \"codigo\"='" + identificador + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("Error al editar");

            return false;
        }
    }
    public boolean eliminar(String identificador){
        String sql = "delete from perfil where \"codigo\"='" + identificador + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("Error eliminar");
            return false;
        }
    }
}
