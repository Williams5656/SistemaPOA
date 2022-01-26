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
    private String numero;
    private String id;
    private String nombre_rol;
    private String observaciones;

    public RolMD(String numero, String id, String nombre_rol, String observaciones) {
        this.numero = numero;
        this.id = id;
        this.nombre_rol = nombre_rol;
        this.observaciones = observaciones;
    }

    public RolMD() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
