/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.models;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author CARLOGON
 */
@Document
public class InspeccionBucal {

    private String id;
    private Date fechaRealizacion;
    private String patientId;
    private List<Diagnostico> list_diagnostico;
    private String observaciones_diagnostico;
    private List<Tratamiento> list_tratamiento;
    private String observaciones_tratamiento;

    public InspeccionBucal(String id, Date fecha_realizacion, List<Diagnostico> list_diagnostico, String observaciones_diagnostico, List<Tratamiento> list_tratamiento, String observaciones_tratamiento, String patientId) {
        this.id = id;
        this.fechaRealizacion = fecha_realizacion;
        this.list_diagnostico = list_diagnostico;
        this.observaciones_diagnostico = observaciones_diagnostico;
        this.list_tratamiento = list_tratamiento;
        this.observaciones_tratamiento = observaciones_tratamiento;
        this.patientId = patientId;
    }

    public InspeccionBucal() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public List<Diagnostico> getList_diagnostico() {
        return list_diagnostico;
    }

    public void setList_diagnostico(List<Diagnostico> list_diagnostico) {
        this.list_diagnostico = list_diagnostico;
    }

    public String getObservaciones_diagnostico() {
        return observaciones_diagnostico;
    }

    public void setObservaciones_diagnostico(String observaciones_diagnostico) {
        this.observaciones_diagnostico = observaciones_diagnostico;
    }

    public List<Tratamiento> getList_tratamiento() {
        return list_tratamiento;
    }

    public void setList_tratamiento(List<Tratamiento> list_tratamiento) {
        this.list_tratamiento = list_tratamiento;
    }

    public String getObservaciones_tratamiento() {
        return observaciones_tratamiento;
    }

    public void setObservaciones_tratamiento(String observaciones_tratamiento) {
        this.observaciones_tratamiento = observaciones_tratamiento;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

}
