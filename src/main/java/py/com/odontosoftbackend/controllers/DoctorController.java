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
import py.com.odontosoftbackend.models.Doctor;
import py.com.odontosoftbackend.services.DoctorService;

/**
 *
 * @author CARLOGON
 */
@RestController
@RequestMapping(path = {"/doctors"})
@CrossOrigin(origins = {"*"}, maxAge = 3600L)
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List doctors = this.doctorService.getAllDoctors();
        ResponseEntity response = new ResponseEntity(doctors, HttpStatus.OK);
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.GET})
    public ResponseEntity<Doctor> getDoctorById(@PathVariable String id) {
        ResponseEntity response;
        try {
            Doctor doctor = this.doctorService.getDoctorById(id);
            response = ResponseEntity.ok(doctor);
        } catch (Exception ex) {
            response = ResponseEntity.notFound().build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.DELETE})
    public ResponseEntity deleteDoctor(@PathVariable String id) {
        ResponseEntity response;
        try {
            this.doctorService.deleteDoctor(id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<Doctor> saveDoctor(@Valid @RequestBody Doctor doctor) {
        ResponseEntity response;
        try {
            this.doctorService.addDoctor(doctor);
            response = ResponseEntity.ok(doctor);
        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.PUT})
    public ResponseEntity editDoctor(@Valid @RequestBody Doctor doctor, @PathVariable String id) {
        ResponseEntity response;
        try {
            this.doctorService.editDoctor(doctor, id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

    @RequestMapping(path = {"/authenticate"}, method = {RequestMethod.POST})
    public ResponseEntity<Doctor> authenticate(@RequestBody Doctor doctor, HttpSession httpSession) {
        try {
            return ResponseEntity.ok(this.doctorService.authenticate(doctor.getUsername(), doctor.getPassword(), httpSession));
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

}
