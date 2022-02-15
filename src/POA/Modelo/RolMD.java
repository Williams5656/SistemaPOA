/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

/**
 *
 * @author PC FACTORY
 */
public class RolMD {
    private int numero_rol;
    private int id_rol;
    private String nombre_rol;
    private String observaciones;

    public RolMD() {
    }

    public RolMD(int numero_rol, int id_rol, String nombre_rol, String observaciones) {
        this.numero_rol = numero_rol;
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
        this.observaciones = observaciones;
    }

    public int getNumero_rol() {
        return numero_rol;
    }

    public void setNumero_rol(int numero_rol) {
        this.numero_rol = numero_rol;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    
}
