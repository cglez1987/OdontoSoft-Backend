/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.models;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author CARLOGON
 */
@Document
public class Payment {

    @Id
    private String id;
    private String patientId;
    private String inspeccionBucalId;
    private String tratamiento;
    private Date payment_date;
    private double amount;
    private String payment_type;
    private String observations;

    public Payment(String id, String patientId, String inspeccionBucalId, String tratamiento, Date payment_date, double amount, String payment_type, String observations) {
        this.id = id;
        this.patientId = patientId;
        this.inspeccionBucalId = inspeccionBucalId;
        this.tratamiento = tratamiento;
        this.payment_date = payment_date;
        this.amount = amount;
        this.payment_type = payment_type;
        this.observations = observations;
    }

    public Payment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getInspeccionBucalId() {
        return inspeccionBucalId;
    }

    public void setInspeccionBucalId(String inspeccionBucalId) {
        this.inspeccionBucalId = inspeccionBucalId;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

}
