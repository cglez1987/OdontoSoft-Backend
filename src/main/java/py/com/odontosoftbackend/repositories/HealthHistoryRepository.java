/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import py.com.odontosoftbackend.models.HealthHistory;

/**
 *
 * @author CARLOGON
 */
public interface HealthHistoryRepository extends MongoRepository<HealthHistory, String> {

    public HealthHistory findByPatientId(String patientId);

}
