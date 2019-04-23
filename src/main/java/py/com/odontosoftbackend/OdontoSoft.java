/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import py.com.odontosoftbackend.models.Doctor;
import py.com.odontosoftbackend.models.InspeccionBucal;
import py.com.odontosoftbackend.services.DoctorService;
import py.com.odontosoftbackend.services.InspeccionBucalService;

/**
 *
 * @author CARLOGON
 */
@SpringBootApplication
@EnableMongoRepositories(basePackages = {"py.com.odontosoftbackend.repositories"})
@PropertySource({"application.properties"})
public class OdontoSoft implements CommandLineRunner {

    @Autowired
    private DoctorService us;

    @Autowired
    private InspeccionBucalService inspService;

    public static void main(String[] args) {
        SpringApplication.run(OdontoSoft.class, args);
    }

    @Override
    public void run(String[] args) throws Exception {
        us.addDoctor(new Doctor(null, "Carlos", "Gonzalez", "cglez", "mana123"));
    }

}
