/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import py.com.odontosoftbackend.models.Payment;

/**
 *
 * @author CARLOGON
 */
public interface PaymentRepository extends MongoRepository<Payment, String> {
    
    public List<Payment> findByPatientId(String patientId);

}
