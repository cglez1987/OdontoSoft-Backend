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
import py.com.odontosoftbackend.models.Diagnostico;
import py.com.odontosoftbackend.repositories.DiagnosticoRepository;

/**
 *
 * @author CARLOGON
 */
@Service
public class DiagnosticoService {

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    public Diagnostico addDiagnostico(Diagnostico user) {
        return ((Diagnostico) this.diagnosticoRepository.save(user));
    }

    public Diagnostico getDiagnosticoById(String id) throws Exception {
        Optional optional = this.diagnosticoRepository.findById(id);
        if (optional.isPresent()) {
            return ((Diagnostico) optional.get());
        }
        throw new Exception("Diagnostico not found!");
    }

    public List<Diagnostico> getAllDiagnosticos() {
        return this.diagnosticoRepository.findAll();
    }

    public void deleteDiagnostico(String id) throws Exception {
        if (this.diagnosticoRepository.existsById(id)) {
            this.diagnosticoRepository.deleteById(id);
        } else {
            throw new Exception("Diagnostico not found!");
        }
    }

    public Diagnostico editDiagnostico(Diagnostico diagnostico, String id) {
        diagnostico.setId(id);
        return ((Diagnostico) this.diagnosticoRepository.save(diagnostico));
    }

    public List<Diagnostico> getTopDiagnosticos() {
        return this.diagnosticoRepository.findAll();
    }

}
