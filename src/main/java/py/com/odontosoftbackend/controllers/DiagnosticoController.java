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
import py.com.odontosoftbackend.models.Diagnostico;
import py.com.odontosoftbackend.services.DiagnosticoService;

/**
 *
 * @author CARLOGON
 */
@RestController
@RequestMapping(path = {"/diagnosticos"})
@CrossOrigin
public class DiagnosticoController {

    @Autowired
    private DiagnosticoService diagnosticoService;

    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<List<Diagnostico>> getAllDiagnosticos() {
        List diagnosticos = this.diagnosticoService.getAllDiagnosticos();
        ResponseEntity response = new ResponseEntity(diagnosticos, HttpStatus.OK);
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.GET})
    public ResponseEntity<Diagnostico> getDiagnosticoById(@PathVariable String id) {
        ResponseEntity response;
        try {
            Diagnostico diagnostico = this.diagnosticoService.getDiagnosticoById(id);
            response = ResponseEntity.ok(diagnostico);
        } catch (Exception ex) {
            response = ResponseEntity.notFound().build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.DELETE})
    public ResponseEntity deleteDiagnostico(@PathVariable String id) {
        ResponseEntity response;
        try {
            this.diagnosticoService.deleteDiagnostico(id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<Diagnostico> saveDiagnostico(@Valid @RequestBody Diagnostico diagnostico) {
        ResponseEntity response;
        try {
            this.diagnosticoService.addDiagnostico(diagnostico);
            response = ResponseEntity.ok(diagnostico);
        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.PUT})
    public ResponseEntity editDiagnostico(@Valid @RequestBody Diagnostico diagnostico, @PathVariable String id) {
        ResponseEntity response;
        try {
            this.diagnosticoService.editDiagnostico(diagnostico, id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

}
