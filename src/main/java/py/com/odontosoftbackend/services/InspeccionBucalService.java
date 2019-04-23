/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import py.com.odontosoftbackend.models.InspeccionBucal;
import py.com.odontosoftbackend.repositories.InspeccionBucalRepository;

/**
 *
 * @author CARLOGON
 */
@Service
public class InspeccionBucalService {

    @Autowired
    private InspeccionBucalRepository inspeccionBucalRepository;

    public InspeccionBucal addInspeccionBucal(InspeccionBucal user) {
        return ((InspeccionBucal) this.inspeccionBucalRepository.save(user));
    }

    public InspeccionBucal getInspeccionBucalById(String id) throws Exception {
        Optional optional = this.inspeccionBucalRepository.findById(id);
        if (optional.isPresent()) {
            return ((InspeccionBucal) optional.get());
        }
        throw new Exception("InspeccionBucal not found!");
    }

    public List<InspeccionBucal> getAllInspeccionBucals() {
        return this.inspeccionBucalRepository.findAll();
    }

    public void deleteInspeccionBucal(String id) throws Exception {
        if (this.inspeccionBucalRepository.existsById(id)) {
            this.inspeccionBucalRepository.deleteById(id);
        } else {
            throw new Exception("InspeccionBucal not found!");
        }
    }

    public InspeccionBucal editInspeccionBucal(InspeccionBucal inspeccionBucal, String id) {
        inspeccionBucal.setId(id);
        return ((InspeccionBucal) this.inspeccionBucalRepository.save(inspeccionBucal));
    }

    public List<InspeccionBucal> getInspeccionBucalsByPatientId(String patientId) {
        return this.inspeccionBucalRepository.findByPatientId(patientId);
    }

    public InspeccionBucal getLastInspeccionBucal(String patientId) {
        return this.inspeccionBucalRepository.findFirstByPatientId(patientId, new Sort(Sort.Direction.DESC, "fechaRealizacion"));
    }
}
