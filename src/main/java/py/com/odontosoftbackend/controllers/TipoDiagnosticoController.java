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
import py.com.odontosoftbackend.models.TipoDiagnostico;
import py.com.odontosoftbackend.services.TipoDiagnosticoService;

/**
 *
 * @author CARLOGON
 */
@RestController
@RequestMapping(path = {"/tipoDiagnosticos"})
@CrossOrigin(origins = {"*"}, maxAge = 3600L)
public class TipoDiagnosticoController {

    @Autowired
    private TipoDiagnosticoService tipoDiagnosticoService;

    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<List<TipoDiagnostico>> getAllTipoDiagnosticos() {
        List tipoTratamientos = this.tipoDiagnosticoService.getAllTipoDiagnosticos();
        ResponseEntity response = new ResponseEntity(tipoTratamientos, HttpStatus.OK);
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.GET})
    public ResponseEntity<TipoDiagnostico> getTipoDiagnosticoById(@PathVariable String id) {
        ResponseEntity response;
        try {
            TipoDiagnostico tipoTratamiento = this.tipoDiagnosticoService.getTipoDiagnosticoById(id);
            response = ResponseEntity.ok(tipoTratamiento);
        } catch (Exception ex) {
            response = ResponseEntity.notFound().build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.DELETE})
    public ResponseEntity deleteTipoDiagnostico(@PathVariable String id) {
        ResponseEntity response;
        try {
            this.tipoDiagnosticoService.deleteTipoDiagnostico(id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<TipoDiagnostico> saveTipoDiagnostico(@Valid @RequestBody TipoDiagnostico tipoTratamiento) {
        ResponseEntity response;
        try {
            this.tipoDiagnosticoService.addTipoDiagnostico(tipoTratamiento);
            response = ResponseEntity.ok(tipoTratamiento);
        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.PUT})
    public ResponseEntity editTipoDiagnostico(@Valid @RequestBody TipoDiagnostico tipoDiagnostico, @PathVariable String id) {
        ResponseEntity response;
        try {
            this.tipoDiagnosticoService.editTipoDiagnostico(tipoDiagnostico, id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }
}
