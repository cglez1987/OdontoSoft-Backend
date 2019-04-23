/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.controllers;

import java.util.List;
import javax.servlet.http.HttpSession;
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
import py.com.odontosoftbackend.models.Cita;
import py.com.odontosoftbackend.services.CitaService;

/**
 *
 * @author CARLOGON
 */
@RestController
@RequestMapping(path = {"/citas"})
@CrossOrigin(origins = {"*"}, maxAge = 3600L)
public class CitaController {

    @Autowired
    private CitaService citaService;

    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<List<Cita>> getAllCitas() {
        List citas = this.citaService.getAllCitas();
        ResponseEntity response = new ResponseEntity(citas, HttpStatus.OK);
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.GET})
    public ResponseEntity<Cita> getCitaById(@PathVariable String id) {
        ResponseEntity response;
        try {
            Cita cita = this.citaService.getCitaById(id);
            response = ResponseEntity.ok(cita);
        } catch (Exception ex) {
            response = ResponseEntity.notFound().build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.DELETE})
    public ResponseEntity deleteCita(@PathVariable String id) {
        ResponseEntity response;
        try {
            this.citaService.deleteCita(id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<Cita> saveCita(@Valid @RequestBody Cita cita) {
        ResponseEntity response;
        try {
            this.citaService.addCita(cita);
            response = ResponseEntity.ok(cita);
        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.PUT})
    public ResponseEntity editCita(@Valid @RequestBody Cita cita, @PathVariable String id) {
        ResponseEntity response;
        try {
            this.citaService.editCita(cita, id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

}
