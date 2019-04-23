/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.models;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

/**
 *
 * @author CARLOGON
 */
@Component
public class Presupuesto {

    @Id
    private String id;
    private String patientId;
    private String doctorId;
    private String inspeccionBucalId;
    private List<Tratamiento> tratamiento;
    private Date creationDate;

}
