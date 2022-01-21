/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoauto.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author willi
 */
public class AutoBD extends AutoMD {

    Conect conectar = new Conect();

    public AutoBD() {
    }

    // consulta sql
    public AutoBD(String placa, String marca, String modelo, int anio, String color, int motor, String chasis, double precio) {
        super(placa, marca, modelo, anio, color, motor, chasis, precio);
    }

    public List<AutoMD> mostrardatos() {
        try {
            List<AutoMD> lista = new ArrayList<AutoMD>();
            String sql = "select * from auto";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                AutoMD m = new AutoMD();
                m.setPlaca(rs.getString("placa"));
                m.setMarca(rs.getString("marca"));
                m.setModelo(rs.getString("modelo"));
                m.setMotor(rs.getInt("motor"));
                m.setAnio(rs.getInt("año"));
                m.setColor(rs.getString("color"));
                m.setChasis(rs.getString("chasis"));
                m.setPrecio(rs.getDouble("precio"));
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(AutoBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
        public List<AutoMD> obtenerdatos(String placa) {
        try {
            List<AutoMD> lista = new ArrayList<AutoMD>();
            String sql = "select * from auto" + " where \"placa\"='"+placa+"'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                AutoMD m = new AutoMD();
                m.setPlaca(rs.getString("placa"));
                m.setMarca(rs.getString("marca"));
                m.setModelo(rs.getString("modelo"));
                m.setMotor(rs.getInt("motor"));
                m.setAnio(rs.getInt("año"));
                m.setColor(rs.getString("color"));
                m.setChasis(rs.getString("chasis"));
                m.setPrecio(rs.getDouble("precio"));
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(AutoBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "INSERT INTO auto(placa,marca,modelo,año,color,chasis,precio,motor)" + "VALUES ('" + getPlaca()+ "','" + getMarca()+ "','" + getModelo()+ "','" + getAnio()+ "','" + getColor()+ "','" + getChasis()+ "','" + getPrecio()+ "','" + getMotor()+ "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }
    public boolean modificar(String placa){
            String sql= "update auto set \"marca\"='"+getMarca()+"',\"modelo\"='"+getModelo()+  "',\"año\"='"+getAnio()+ "',\"color\"='"+getColor()+ "',\"chasis\"='"+getChasis()+ "',\"precio\"='"+getPrecio()+ "',\"motor\"='"+getMotor()+ "'" 
                    + " where \"placa\"='"+placa+"'";
            
            if(conectar.noQuery(sql)==null){
                return true;
                }
                else{
                    System.out.println("error al editar");
   
        return false;
                }
            
            }
}
