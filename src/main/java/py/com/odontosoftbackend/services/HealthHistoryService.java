/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.odontosoftbackend.models.HealthHistory;
import py.com.odontosoftbackend.repositories.HealthHistoryRepository;

/**
 *
 * @author CARLOGON
 */
@Service
public class HealthHistoryService {

    @Autowired
    private HealthHistoryRepository healthHistoryRepository;

    public HealthHistory addHealthHistory(HealthHistory user) {
        return ((HealthHistory) this.healthHistoryRepository.save(user));
    }

    public HealthHistory getHealthHistoryById(String id) throws Exception {
        Optional optional = this.healthHistoryRepository.findById(id);
        if (optional.isPresent()) {
            return ((HealthHistory) optional.get());
        }
        throw new Exception("HealthHistory not found!");
    }

    public List<HealthHistory> getAllHealthHistorys() {
        return this.healthHistoryRepository.findAll();
    }

    public void deleteHealthHistory(String id) throws Exception {
        if (this.healthHistoryRepository.existsById(id)) {
            this.healthHistoryRepository.deleteById(id);
        } else {
            throw new Exception("HealthHistory not found!");
        }
    }

    public HealthHistory editHealthHistory(HealthHistory healthHistory, String id) {
        healthHistory.setId(id);
        return ((HealthHistory) this.healthHistoryRepository.save(healthHistory));
    }

    public List<HealthHistory> getTopHealthHistorys() {
        return this.healthHistoryRepository.findAll();
    }

    public HealthHistory getHealthHistoryByPatientId(String patientId) {
        return this.healthHistoryRepository.findByPatientId(patientId);
    }
}
