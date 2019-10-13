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
import py.com.odontosoftbackend.models.Especialidad;
import py.com.odontosoftbackend.services.EspecialidadService;

/**
 *
 * @author CARLOGON
 */
@RestController
@RequestMapping(path = {"/especialidades"})
@CrossOrigin
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<List<Especialidad>> getAllEspecialidads() {
        List especialidads = this.especialidadService.getAllEspecialidads();
        ResponseEntity response = new ResponseEntity(especialidads, HttpStatus.OK);
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.GET})
    public ResponseEntity<Especialidad> getEspecialidadById(@PathVariable String id) {
        ResponseEntity response;
        try {
            Especialidad especialidad = this.especialidadService.getEspecialidadById(id);
            response = ResponseEntity.ok(especialidad);
        } catch (Exception ex) {
            response = ResponseEntity.notFound().build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.DELETE})
    public ResponseEntity deleteEspecialidad(@PathVariable String id) {
        ResponseEntity response;
        try {
            this.especialidadService.deleteEspecialidad(id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<Especialidad> saveEspecialidad(@Valid @RequestBody Especialidad especialidad) {
        ResponseEntity response;
        try {
            this.especialidadService.addEspecialidad(especialidad);
            response = ResponseEntity.ok(especialidad);
        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.PUT})
    public ResponseEntity editEspecialidad(@Valid @RequestBody Especialidad especialidad, @PathVariable String id) {
        ResponseEntity response;
        try {
            this.especialidadService.editEspecialidad(especialidad, id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

}
