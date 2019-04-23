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
import py.com.odontosoftbackend.models.Tipo_Tratamiento;
import py.com.odontosoftbackend.repositories.TipoTratamientoRepository;

/**
 *
 * @author CARLOGON
 */
@Service
public class TipoTratamientoService {

    @Autowired
    private TipoTratamientoRepository tipoTratamientoRepository;

    public Tipo_Tratamiento addTipoTratamiento(Tipo_Tratamiento user) {
        return ((Tipo_Tratamiento) this.tipoTratamientoRepository.save(user));
    }

    public Tipo_Tratamiento getTipoTratamientoById(String id) throws Exception {
        Optional optional = this.tipoTratamientoRepository.findById(id);
        if (optional.isPresent()) {
            return ((Tipo_Tratamiento) optional.get());
        }
        throw new Exception("TipoTratamiento not found!");
    }

    public List<Tipo_Tratamiento> getAllTipoTratamientos() {
        return this.tipoTratamientoRepository.findAll();
    }

    public void deleteTipoTratamiento(String id) throws Exception {
        if (this.tipoTratamientoRepository.existsById(id)) {
            this.tipoTratamientoRepository.deleteById(id);
        } else {
            throw new Exception("TipoTratamiento not found!");
        }
    }

    public Tipo_Tratamiento editTipoTratamiento(Tipo_Tratamiento tipoTratamiento, String id) {
        tipoTratamiento.setId(id);
        return ((Tipo_Tratamiento) this.tipoTratamientoRepository.save(tipoTratamiento));
    }

    public List<Tipo_Tratamiento> getTopTipoTratamientos() {
        return this.tipoTratamientoRepository.findAll();
    }

}
