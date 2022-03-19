/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

/**
 *
 * @author Renato Llivisaca
 */
public class CalendarioMD {
    private int id_Carrera;
    private int id_Periodo;
    private int id_TipoActividad;

    public CalendarioMD() {
    }

    public CalendarioMD(int id_Carrera, int id_Periodo, int id_Actividad) {
        this.id_Carrera = id_Carrera;
        this.id_Periodo = id_Periodo;
        this.id_TipoActividad = id_Actividad;
    }

    public int getId_Carrera() {
        return id_Carrera;
    }

    public void setId_Carrera(int id_Carrera) {
        this.id_Carrera = id_Carrera;
    }

    public int getId_Periodo() {
        return id_Periodo;
    }

    public void setId_Periodo(int id_Periodo) {
        this.id_Periodo = id_Periodo;
    }

    public int getid_TipoActividad() {
        return id_TipoActividad;
    }

    public void setid_TipoActividad(int id_Actividad) {
        this.id_TipoActividad = id_Actividad;
    }
    
    
}
