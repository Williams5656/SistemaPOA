/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Modelo;

/**
 *
 * @author Isaac Mejia
 */
public class PermisosMD {
    private int id;
    private int id_rol;
    private String nombre_permiso;
    private boolean estado;

    public PermisosMD(int id, int id_rol, String nombre_permiso, boolean estado) {
        this.id = id;
        this.id_rol = id_rol;
        this.nombre_permiso = nombre_permiso;
        this.estado = estado;
    }

    public PermisosMD() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_permiso() {
        return nombre_permiso;
    }

    public void setNombre_permiso(String nombre_permiso) {
        this.nombre_permiso = nombre_permiso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
