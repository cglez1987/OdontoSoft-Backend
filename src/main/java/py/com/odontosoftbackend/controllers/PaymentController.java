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
import py.com.odontosoftbackend.models.Payment;
import py.com.odontosoftbackend.services.PaymentService;

/**
 *
 * @author CARLOGON
 */
@RestController
@RequestMapping(path = {"/payments"})
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<List<Payment>> getAllPayments() {
        List payments = this.paymentService.getAllPayments();
        ResponseEntity response = new ResponseEntity(payments, HttpStatus.OK);
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.GET})
    public ResponseEntity<Payment> getPaymentById(@PathVariable String id) {
        ResponseEntity response;
        try {
            Payment payment = this.paymentService.getPaymentById(id);
            response = ResponseEntity.ok(payment);
        } catch (Exception ex) {
            response = ResponseEntity.notFound().build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.DELETE})
    public ResponseEntity deletePayment(@PathVariable String id) {
        ResponseEntity response;
        try {
            this.paymentService.deletePayment(id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<Payment> savePayment(@Valid @RequestBody Payment payment) {
        ResponseEntity response;
        try {
            this.paymentService.addPayment(payment);
            response = ResponseEntity.ok(payment);
        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            System.err.println("Error: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(path = {"/{id}"}, method = {RequestMethod.PUT})
    public ResponseEntity editPayment(@Valid @RequestBody Payment payment, @PathVariable String id) {
        ResponseEntity response;
        try {
            this.paymentService.editPayment(payment, id);
            response = ResponseEntity.ok().build();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

    @RequestMapping(path = {"/patientId/{patientId}"}, method = {RequestMethod.GET})
    public ResponseEntity<List<Payment>> getAllInspeccionBucalsByPatientId(@PathVariable String patientId) {
        List payments = this.paymentService.getAllPaymentsByPatientId(patientId);
        ResponseEntity response = new ResponseEntity(payments, HttpStatus.OK);
        return response;
    }

}
