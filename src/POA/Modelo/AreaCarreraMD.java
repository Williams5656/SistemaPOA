/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

/**
 *
 * @author Usuario
 */
public class AreaCarreraMD {
    private int idArea;
    private int idCarrera;
    private int idPerfil;
    private String idResponsable;

    public AreaCarreraMD() {
    }

    public AreaCarreraMD(int idArea, int idCarrera, int idPerfil, String idResponsable) {
        this.idArea = idArea;
        this.idCarrera = idCarrera;
        this.idPerfil = idPerfil;
        this.idResponsable = idResponsable;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(String idResponsable) {
        this.idResponsable = idResponsable;
    }
    
    
    
}
