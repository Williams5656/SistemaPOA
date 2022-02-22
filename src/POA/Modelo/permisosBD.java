/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isaac Mejia
 */
public class permisosBD extends Permisos{
    Conect conectar = new Conect();

    public permisosBD() {    }

    
    public permisosBD(int id, int id_rol, String nombre_permiso, boolean estado) {
        super(id, id_rol, nombre_permiso, estado);
    }
    
    public boolean insertar(){
       String nsql =  "INSERT INTO editar_permisos(id, id_rol, nombre_permiso, estado)"+ "VALUES ('"+getId()+ "','" + getId_rol()+ "','" + getNombre_permiso() + "','" + isEstado() + "')" ;
       if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }
    public boolean Modificar (int id_rol,int id){
       String nsql = "update editar_permisos set \"estado\"='" + isEstado()+ "'"
                + " where \"id_rol\"='" + id_rol + "' and id ="+id;

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("ERROR AL EDITAR");
            return false;
        } 
    }
    
    public List<Permisos> obtenerDatos(int idRol){
        List<Permisos> listar = new  ArrayList<Permisos>();
        try{
            String sql = "select * from editar_permisos" + " where \"id_rol\"='" + idRol + "' and estado = 'true'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()){
                Permisos r = new Permisos();
                r.setId(rs.getInt("id"));
                r.setId_rol(rs.getInt("id_rol"));
                r.setNombre_permiso(rs.getString("nombre_permiso"));
                listar.add(r);
            }
            rs.close();
            return listar;
        }catch (Exception e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public int Validar(int id_rol){
        int fila=0;
       try{
            String sql = "select * from editar_permisos" + " where \"id_rol\"='" + id_rol + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()){
                fila++;
            }
            rs.close();
            return fila;
        }catch (Exception e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return fila;
        }
    }
    
}
