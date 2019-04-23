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
public class Tipo_Tratamiento {

    private String id;
    private String especialidad;
    private String name;
    private double cost;

    public Tipo_Tratamiento(String id, String especialidad, String name, double cost) {
        this.id = id;
        this.especialidad = especialidad;
        this.name = name;
        this.cost = cost;
    }

    public Tipo_Tratamiento() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
