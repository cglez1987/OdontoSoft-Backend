/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import py.com.odontosoftbackend.models.Doctor;

/**
 *
 * @author CARLOGON
 */
public abstract interface DoctorRepository extends MongoRepository<Doctor, String> {

    public abstract boolean existsByUsername(String username);

    public abstract Doctor findByUsernameAndPassword(String username, String password);
}
