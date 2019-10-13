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
import py.com.odontosoftbackend.models.Tipo_Tratamiento;
import py.com.odontosoftbackend.services.TipoTratamientoService;

/**
 *
 * @author CARLOGON
 */
@RestController
@RequestMapping(path = {"/tipoTratamientos"})
@CrossOrigin
public class TipoTratamientoController {

    @Autowired
    private TipoTratamientoService tipoTratamientoService;

    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<List<Tipo_Tratamiento>> getAllTipo_Tratamientos() {
        List tipoTratamientos = this.tipoTratamientoService.getAllTipoTratamientos();
        ResponseEntity response = new ResponseEntity(tipoTratamientos, HttpStatus.OK);
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.GET})
    public ResponseEntity<Tipo_Tratamiento> getTipo_TratamientoById(@PathVariable String id) {
        ResponseEntity response;
        try {
            Tipo_Tratamiento tipoTratamiento = this.tipoTratamientoService.getTipoTratamientoById(id);
            response = ResponseEntity.ok(tipoTratamiento);
        } catch (Exception ex) {
            response = ResponseEntity.notFound().build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.DELETE})
    public ResponseEntity deleteTipo_Tratamiento(@PathVariable String id) {
        ResponseEntity response;
        try {
            this.tipoTratamientoService.deleteTipoTratamiento(id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<Tipo_Tratamiento> saveTipo_Tratamiento(@Valid @RequestBody Tipo_Tratamiento tipoTratamiento) {
        ResponseEntity response;
        try {
            this.tipoTratamientoService.addTipoTratamiento(tipoTratamiento);
            response = ResponseEntity.ok(tipoTratamiento);
        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.PUT})
    public ResponseEntity editTipo_Tratamiento(@Valid @RequestBody Tipo_Tratamiento tipoTratamiento, @PathVariable String id) {
        ResponseEntity response;
        try {
            this.tipoTratamientoService.editTipoTratamiento(tipoTratamiento, id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

}
