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
import py.com.odontosoftbackend.models.HealthHistory;
import py.com.odontosoftbackend.services.HealthHistoryService;

/**
 *
 * @author CARLOGON
 */
@RestController
@RequestMapping(path = {"/healthHistory"})
@CrossOrigin
public class HealthHistoryController {

    @Autowired
    private HealthHistoryService healthHistoryService;

    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<List<HealthHistory>> getAllHealthHistorys() {
        List healthHistorys = this.healthHistoryService.getAllHealthHistorys();
        ResponseEntity response = new ResponseEntity(healthHistorys, HttpStatus.OK);
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.GET})
    public ResponseEntity<HealthHistory> getHealthHistoryById(@PathVariable String id) {
        ResponseEntity response;
        try {
            HealthHistory healthHistory = this.healthHistoryService.getHealthHistoryById(id);
            response = ResponseEntity.ok(healthHistory);
        } catch (Exception ex) {
            response = ResponseEntity.notFound().build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.DELETE})
    public ResponseEntity deleteHealthHistory(@PathVariable String id) {
        ResponseEntity response;
        try {
            this.healthHistoryService.deleteHealthHistory(id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<HealthHistory> saveHealthHistory(@Valid @RequestBody HealthHistory healthHistory) {
        ResponseEntity response;
        try {
            HealthHistory temp =  this.healthHistoryService.addHealthHistory(healthHistory);
            response = ResponseEntity.ok(temp);
        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.PUT})
    public ResponseEntity editHealthHistory(@Valid @RequestBody HealthHistory healthHistory, @PathVariable String id) {
        ResponseEntity response;
        try {
            this.healthHistoryService.editHealthHistory(healthHistory, id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

    @RequestMapping(path = {"/patientId/{patientId}"}, method = {RequestMethod.GET})
    public ResponseEntity<HealthHistory> getHealthHistoryByPatientId(@PathVariable String patientId) {
        ResponseEntity response;
        try {
            HealthHistory healthHistory = this.healthHistoryService.getHealthHistoryByPatientId(patientId);
            response = ResponseEntity.ok(healthHistory);
        } catch (Exception ex) {
            response = ResponseEntity.notFound().build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }
}
