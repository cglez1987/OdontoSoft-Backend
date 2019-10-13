/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CARLOGON
 */
@RestController
@RequestMapping(path = {"/health"})
@CrossOrigin
public class HealthController {


    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<String> getHealth() {
        ResponseEntity response = new ResponseEntity("Healthy", HttpStatus.OK);
        return response;
    }

}
