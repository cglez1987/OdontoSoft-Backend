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
import py.com.odontosoftbackend.models.Patient;
import py.com.odontosoftbackend.repositories.PatientRepository;

/**
 *
 * @author CARLOGON
 */
@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient user) {
        return ((Patient) this.patientRepository.save(user));
    }

    public Patient getPatientById(String id) throws Exception {
        Optional optional = this.patientRepository.findById(id);
        if (optional.isPresent()) {
            return ((Patient) optional.get());
        }
        throw new Exception("Patient not found!");
    }

    public List<Patient> getAllPatients() {
        return this.patientRepository.findAll();
    }

    public void deletePatient(String id) throws Exception {
        if (this.patientRepository.existsById(id)) {
            this.patientRepository.deleteById(id);
        } else {
            throw new Exception("Patient not found!");
        }
    }

    public Patient editPatient(Patient patient, String id) {
        patient.setId(id);
        return ((Patient) this.patientRepository.save(patient));
    }

    public List<Patient> getTopPatients() {
        return this.patientRepository.findAll();
    }

}
