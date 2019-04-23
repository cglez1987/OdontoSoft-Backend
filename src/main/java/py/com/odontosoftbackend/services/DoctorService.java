/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.services;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.odontosoftbackend.models.Doctor;
import py.com.odontosoftbackend.repositories.DoctorRepository;

/**
 *
 * @author CARLOGON
 */
@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor user) {
        return ((Doctor) this.doctorRepository.save(user));
    }

    public Doctor getDoctorById(String id) throws Exception {
        Optional optional = this.doctorRepository.findById(id);
        if (optional.isPresent()) {
            return ((Doctor) optional.get());
        }
        throw new Exception("Doctor not found!");
    }

    public List<Doctor> getAllDoctors() {
        return this.doctorRepository.findAll();
    }

    public void deleteDoctor(String id) throws Exception {
        if (this.doctorRepository.existsById(id)) {
            this.doctorRepository.deleteById(id);
        } else {
            throw new Exception("Doctor not found!");
        }
    }

    public Doctor editDoctor(Doctor doctor, String id) {
        doctor.setId(id);
        return ((Doctor) this.doctorRepository.save(doctor));
    }

    public Doctor authenticate(String username, String password, HttpSession httpSession) throws Exception {
        if ((username == null) || (username.isEmpty()) || (password == null) || (password.isEmpty())) {
            throw new Exception("Login error. Doctorname or password incorrect.");
        }
        Doctor u = this.doctorRepository.findByUsernameAndPassword(username, password);
        //u.setToken(httpSession.getId());
        return u;
    }

    public List<Doctor> getTopDoctors() {
        return this.doctorRepository.findAll();
    }
}
