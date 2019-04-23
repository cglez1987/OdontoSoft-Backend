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
public class Especialidad {

    private String id;
    private String name;

    public Especialidad(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Especialidad() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
