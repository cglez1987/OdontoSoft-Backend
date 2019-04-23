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
import py.com.odontosoftbackend.models.Cita;
import py.com.odontosoftbackend.repositories.CitaRepository;

/**
 *
 * @author CARLOGON
 */
@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public Cita addCita(Cita cita) {
        return ((Cita) this.citaRepository.save(cita));
    }

    public Cita getCitaById(String id) throws Exception {
        Optional optional = this.citaRepository.findById(id);
        if (optional.isPresent()) {
            return ((Cita) optional.get());
        }
        throw new Exception("Cita not found!");
    }

    public List<Cita> getAllCitas() {
        return this.citaRepository.findAll();
    }

    public void deleteCita(String id) throws Exception {
        if (this.citaRepository.existsById(id)) {
            this.citaRepository.deleteById(id);
        } else {
            throw new Exception("Cita not found!");
        }
    }

    public Cita editCita(Cita cita, String id) {
        cita.setId(id);
        return ((Cita) this.citaRepository.save(cita));
    }

    public List<Cita> getTopCitas() {
        return this.citaRepository.findAll();
    }

}
