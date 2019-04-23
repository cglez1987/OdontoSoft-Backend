/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.models;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author CARLOGON
 */
@Document
public class Tratamiento {

    private String id;
    private String especialidad;
    private String tipo_tratamiento;
    private String description;
    private double costo;
    private double pagado;

    public Tratamiento(String id, String especialidad, String tipo_tratamiento, String description, double costo, double pagado) {
        this.id = id;
        this.especialidad = especialidad;
        this.tipo_tratamiento = tipo_tratamiento;
        this.description = description;
        this.costo = costo;
        this.pagado = pagado;
    }

    public Tratamiento() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTipo_tratamiento() {
        return tipo_tratamiento;
    }

    public void setTipo_tratamiento(String tipo_tratamiento) {
        this.tipo_tratamiento = tipo_tratamiento;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPagado() {
        return pagado;
    }

    public void setPagado(double pagado) {
        this.pagado = pagado;
    }

}
