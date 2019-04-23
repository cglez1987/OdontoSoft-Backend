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
import py.com.odontosoftbackend.models.TipoDiagnostico;
import py.com.odontosoftbackend.models.Tipo_Tratamiento;
import py.com.odontosoftbackend.repositories.TipoDiagnosticoRepository;

/**
 *
 * @author CARLOGON
 */
@Service
public class TipoDiagnosticoService {

    @Autowired
    private TipoDiagnosticoRepository tipoDiagnosticoRepository;

    public TipoDiagnostico addTipoDiagnostico(TipoDiagnostico tipoDiagnostico) {
        return ((TipoDiagnostico) this.tipoDiagnosticoRepository.save(tipoDiagnostico));
    }

    public TipoDiagnostico getTipoDiagnosticoById(String id) throws Exception {
        Optional optional = this.tipoDiagnosticoRepository.findById(id);
        if (optional.isPresent()) {
            return ((TipoDiagnostico) optional.get());
        }
        throw new Exception("TipoDiagnostico not found!");
    }

    public List<TipoDiagnostico> getAllTipoDiagnosticos() {
        return this.tipoDiagnosticoRepository.findAll();
    }

    public void deleteTipoDiagnostico(String id) throws Exception {
        if (this.tipoDiagnosticoRepository.existsById(id)) {
            this.tipoDiagnosticoRepository.deleteById(id);
        } else {
            throw new Exception("TipoDiagnostico not found!");
        }
    }

    public TipoDiagnostico editTipoDiagnostico(TipoDiagnostico tipoDiagnostico, String id) {
        tipoDiagnostico.setId(id);
        return ((TipoDiagnostico) this.tipoDiagnosticoRepository.save(tipoDiagnostico));
    }

    public List<TipoDiagnostico> getTopTipoDiagnosticos() {
        return this.tipoDiagnosticoRepository.findAll();
    }

}
