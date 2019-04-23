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
import py.com.odontosoftbackend.models.Tratamiento;
import py.com.odontosoftbackend.services.TratamientoService;

/**
 *
 * @author CARLOGON
 */
@RestController
@RequestMapping(path = {"/tratamientos"})
@CrossOrigin(origins = {"*"}, maxAge = 3600L)
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<List<Tratamiento>> getAllTratamientos() {
        List tratamientos = this.tratamientoService.getAllTratamientos();
        ResponseEntity response = new ResponseEntity(tratamientos, HttpStatus.OK);
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.GET})
    public ResponseEntity<Tratamiento> getTratamientoById(@PathVariable String id) {
        ResponseEntity response;
        try {
            Tratamiento tratamiento = this.tratamientoService.getTratamientoById(id);
            response = ResponseEntity.ok(tratamiento);
        } catch (Exception ex) {
            response = ResponseEntity.notFound().build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.DELETE})
    public ResponseEntity deleteTratamiento(@PathVariable String id) {
        ResponseEntity response;
        try {
            this.tratamientoService.deleteTratamiento(id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<Tratamiento> saveTratamiento(@Valid @RequestBody Tratamiento tratamiento) {
        ResponseEntity response;
        try {
            this.tratamientoService.addTratamiento(tratamiento);
            response = ResponseEntity.ok(tratamiento);
        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.PUT})
    public ResponseEntity editTratamiento(@Valid @RequestBody Tratamiento tratamiento, @PathVariable String id) {
        ResponseEntity response;
        try {
            this.tratamientoService.editTratamiento(tratamiento, id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

}
