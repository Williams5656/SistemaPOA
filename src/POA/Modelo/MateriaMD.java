/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

/**
 *
 * @author A
 */
public class MateriaMD {
    private String nombre_carrera;
    private String eje_formacion;
    private String cod_materia;
    private String nombre_materia;
    private String ciclo;
    private String creditos;
    private String plan;
    private String area;

    public MateriaMD(String nombre_carrera, String eje_formacion, String cod_materia, String nombre_materia, String ciclo, String creditos, String plan, String area) {
        this.nombre_carrera = nombre_carrera;
        this.eje_formacion = eje_formacion;
        this.cod_materia = cod_materia;
        this.nombre_materia = nombre_materia;
        this.ciclo = ciclo;
        this.creditos = creditos;
        this.plan = plan;
        this.area = area;
    }
    
    public MateriaMD() {
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public String getEje_formacion() {
        return eje_formacion;
    }

    public void setEje_formacion(String eje_formacion) {
        this.eje_formacion = eje_formacion;
    }

    public String getCod_materia() {
        return cod_materia;
    }

    public void setCod_materia(String cod_materia) {
        this.cod_materia = cod_materia;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
