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
import py.com.odontosoftbackend.models.Especialidad;
import py.com.odontosoftbackend.repositories.EspecialidadRepository;

/**
 *
 * @author CARLOGON
 */
@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public Especialidad addEspecialidad(Especialidad user) {
        return ((Especialidad) this.especialidadRepository.save(user));
    }

    public Especialidad getEspecialidadById(String id) throws Exception {
        Optional optional = this.especialidadRepository.findById(id);
        if (optional.isPresent()) {
            return ((Especialidad) optional.get());
        }
        throw new Exception("Especialidad not found!");
    }

    public List<Especialidad> getAllEspecialidads() {
        return this.especialidadRepository.findAll();
    }

    public void deleteEspecialidad(String id) throws Exception {
        if (this.especialidadRepository.existsById(id)) {
            this.especialidadRepository.deleteById(id);
        } else {
            throw new Exception("Especialidad not found!");
        }
    }

    public Especialidad editEspecialidad(Especialidad especialidad, String id) {
        especialidad.setId(id);
        return ((Especialidad) this.especialidadRepository.save(especialidad));
    }

    public List<Especialidad> getTopEspecialidads() {
        return this.especialidadRepository.findAll();
    }

}
