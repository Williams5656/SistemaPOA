/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

/**
 *
 * @author DANNY
 */
public class CarreraMD {
    private String nombre_carrera;
    private String codigo_carrera;
    private String fecha_inicio;
    private String modalidad;
    private String horario;

    public CarreraMD(String nombre_carrera, String codigo_carrera, String fecha_inicio, String modalidad, String horario) {
        this.nombre_carrera = nombre_carrera;
        this.codigo_carrera = codigo_carrera;
        this.fecha_inicio = fecha_inicio;
        this.modalidad = modalidad;
        this.horario = horario;
    }

    
    public CarreraMD(){
        
    }
            
    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public String getCodigo_carrera() {
        return codigo_carrera;
    }

    public void setCodigo_carrera(String codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
    
}
