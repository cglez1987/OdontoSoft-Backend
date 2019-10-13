/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import py.com.odontosoftbackend.models.Patient;
import py.com.odontosoftbackend.services.PatientService;

/**
 *
 * @author CARLOGON
 */
@RestController
@RequestMapping(path = {"/patients"})
@CrossOrigin
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<List<Patient>> getAllPatients() {
        List patients = this.patientService.getAllPatients();
        ResponseEntity response = new ResponseEntity(patients, HttpStatus.OK);
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.GET})
    public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
        ResponseEntity response;
        try {
            Patient patient = this.patientService.getPatientById(id);
            response = ResponseEntity.ok(patient);
        } catch (Exception ex) {
            response = ResponseEntity.notFound().build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.DELETE})
    public ResponseEntity deletePatient(@PathVariable String id) {
        ResponseEntity response;
        try {
            this.patientService.deletePatient(id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<Patient> savePatient(@Valid @RequestBody Patient patient) {
        ResponseEntity response;
        try {
            this.patientService.addPatient(patient);
            response = ResponseEntity.ok(patient);
        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.PUT})
    public ResponseEntity editPatient(@Valid @RequestBody Patient patient, @PathVariable String id) {
        ResponseEntity response;
        try {
            this.patientService.editPatient(patient, id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

}
