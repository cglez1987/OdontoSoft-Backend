/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.repositories;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import py.com.odontosoftbackend.models.InspeccionBucal;

/**
 *
 * @author CARLOGON
 */
public interface InspeccionBucalRepository extends MongoRepository<InspeccionBucal, String> {

    public List<InspeccionBucal> findByPatientId(String patientId);

    public InspeccionBucal findFirstByPatientId(String patientId, Sort sort);

}
