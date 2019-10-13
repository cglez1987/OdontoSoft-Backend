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
import py.com.odontosoftbackend.models.InspeccionBucal;
import py.com.odontosoftbackend.services.InspeccionBucalService;

/**
 *
 * @author CARLOGON
 */
@RestController
@RequestMapping(path = {"/inspeccionBucales"})
@CrossOrigin
public class InspeccionBucalController {

    @Autowired
    private InspeccionBucalService inspeccionBucalService;

    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<List<InspeccionBucal>> getAllInspeccionBucals() {
        List inspeccionBucals = this.inspeccionBucalService.getAllInspeccionBucals();
        ResponseEntity response = new ResponseEntity(inspeccionBucals, HttpStatus.OK);
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.GET})
    public ResponseEntity<InspeccionBucal> getInspeccionBucalById(@PathVariable String id) {
        ResponseEntity response;
        try {
            InspeccionBucal inspeccionBucal = this.inspeccionBucalService.getInspeccionBucalById(id);
            response = ResponseEntity.ok(inspeccionBucal);
        } catch (Exception ex) {
            response = ResponseEntity.notFound().build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.DELETE})
    public ResponseEntity deleteInspeccionBucal(@PathVariable String id) {
        ResponseEntity response;
        try {
            this.inspeccionBucalService.deleteInspeccionBucal(id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<InspeccionBucal> saveInspeccionBucal(@Valid @RequestBody InspeccionBucal inspeccionBucal) {
        ResponseEntity response;
        try {
            this.inspeccionBucalService.addInspeccionBucal(inspeccionBucal);
            response = ResponseEntity.ok(inspeccionBucal);
        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            System.err.println("Error: " + ex.getMessage());
        }
        System.out.println("Salvando la inspeccion bucal");
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.PUT})
    public ResponseEntity editInspeccionBucal(@Valid @RequestBody InspeccionBucal inspeccionBucal, @PathVariable String id) {
        ResponseEntity response;
        try {
            this.inspeccionBucalService.editInspeccionBucal(inspeccionBucal, id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

    @RequestMapping(path = {"/patientId/{patientId}"}, method = {RequestMethod.GET})
    public ResponseEntity<List<InspeccionBucal>> getAllInspeccionBucalsByPatientId(@PathVariable String patientId) {
        List inspeccionBucals = this.inspeccionBucalService.getInspeccionBucalsByPatientId(patientId);
        ResponseEntity response = new ResponseEntity(inspeccionBucals, HttpStatus.OK);
        return response;
    }

    @RequestMapping(path = {"/last/{patientId}"}, method = {RequestMethod.GET})
    public ResponseEntity<InspeccionBucal> getLastInspeccionBucal(@PathVariable String patientId) {
        ResponseEntity response;
        try {
            InspeccionBucal inspeccionBucal = this.inspeccionBucalService.getLastInspeccionBucal(patientId);
            response = ResponseEntity.ok(inspeccionBucal);
        } catch (Exception ex) {
            response = ResponseEntity.notFound().build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }
}
