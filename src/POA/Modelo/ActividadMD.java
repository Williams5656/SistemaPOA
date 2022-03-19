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
public class ActividadMD extends CalendarioMD{
    private int id_TipoActividad;
    private int id_Actividad;
    private String Nombre_Actividad;
    private String Responsables;
    private String Descripcion;
    private String Fecha_Inicio;
    private String Fecha_Limite;

    public ActividadMD(int id_Carrera, int id_Periodo, int id_Actividad) {
        super(id_Carrera, id_Periodo, id_Actividad);
    }

    public ActividadMD(int id_TipoActividad, int id_Actividad, String Nombre_Actividad, String Responsables, String Descripcion, String Fecha_Inicio, String Fecha_Limite, int id_Carrera, int id_Periodo ) {
        super(id_Carrera, id_Periodo, id_Actividad);
        this.id_TipoActividad = id_TipoActividad;
        this.Nombre_Actividad = Nombre_Actividad;
        this.Responsables = Responsables;
        this.Descripcion = Descripcion;
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Limite = Fecha_Limite;
    }

    public int getId_TipoActividad() {
        return id_TipoActividad;
    }

    public void setId_TipoActividad(int id_TipoActividad) {
        this.id_TipoActividad = id_TipoActividad;
    }

    public int getId_Actividad() {
        return id_Actividad;
    }

    public void setId_Actividad(int id_Actividad) {
        this.id_Actividad = id_Actividad;
    }

    public String getNombre_Actividad() {
        return Nombre_Actividad;
    }

    public void setNombre_Actividad(String Nombre_Actividad) {
        this.Nombre_Actividad = Nombre_Actividad;
    }

    public String getResponsables() {
        return Responsables;
    }

    public void setResponsables(String Responsables) {
        this.Responsables = Responsables;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(String Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    public String getFecha_Limite() {
        return Fecha_Limite;
    }

    public void setFecha_Limite(String Fecha_Limite) {
        this.Fecha_Limite = Fecha_Limite;
    }
 
}
