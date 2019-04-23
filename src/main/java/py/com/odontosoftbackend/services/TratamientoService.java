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
import py.com.odontosoftbackend.models.Tratamiento;
import py.com.odontosoftbackend.repositories.TratamientoRepository;

/**
 *
 * @author CARLOGON
 */
@Service
public class TratamientoService {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    public Tratamiento addTratamiento(Tratamiento tratamiento) {
        return ((Tratamiento) this.tratamientoRepository.save(tratamiento));
    }

    public Tratamiento getTratamientoById(String id) throws Exception {
        Optional optional = this.tratamientoRepository.findById(id);
        if (optional.isPresent()) {
            return ((Tratamiento) optional.get());
        }
        throw new Exception("Tratamiento not found!");
    }

    public List<Tratamiento> getAllTratamientos() {
        return this.tratamientoRepository.findAll();
    }

    public void deleteTratamiento(String id) throws Exception {
        if (this.tratamientoRepository.existsById(id)) {
            this.tratamientoRepository.deleteById(id);
        } else {
            throw new Exception("Tratamiento not found!");
        }
    }

    public Tratamiento editTratamiento(Tratamiento tratamiento, String id) {
        tratamiento.setId(id);
        return ((Tratamiento) this.tratamientoRepository.save(tratamiento));
    }

    public List<Tratamiento> getTopTratamientoes() {
        return this.tratamientoRepository.findAll();
    }

}
