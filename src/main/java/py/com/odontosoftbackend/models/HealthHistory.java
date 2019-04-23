/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.odontosoftbackend.models;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author CARLOGON
 */
@Document
public class HealthHistory {

    private String id;
    private String patientId;
    private boolean tiene_tratamiento_medico;
    private String tratamiento_medico;

    private boolean sangra_mucho;
    private boolean hizo_test_elisa;
    private boolean tiene_enfermedad;
    private String enfermedad;
    private boolean tiene_medicamentos;
    private String medicamentos;
    private String alergias;
    private boolean tiene_cirugias;
    private String cirugias;
    private boolean tiene_transfusion_sangre;

    private String motivo_consulta;
    private Date ultima_visita_odonto;
    private String causa_perdida_dientes;
    private String cant_cepillados;
    private boolean tolera_anestecia_odonto;

    private String observaciones;
    private List<String> elementos_limpieza_bucal;

    public HealthHistory(String id, String patientId, boolean tiene_tratamiento_medico, String tratamiento_medico, boolean sangra_mucho, boolean hizo_test_elisa, boolean tiene_enfermedad, String enfermedad, boolean tiene_medicamentos, String medicamentos, boolean tiene_alergias, boolean tiene_cirugias, String cirugias, boolean tiene_transfusion_sangre, String motivo_consulta, Date ultima_visita_odonto, String causa_perdida_dientes, String cant_cepillados, boolean tolera_anestecia_odonto, String observaciones, List<String> elementos_limpieza_bucal) {
        this.id = id;
        this.patientId = patientId;
        this.tiene_tratamiento_medico = tiene_tratamiento_medico;
        this.tratamiento_medico = tratamiento_medico;
        this.sangra_mucho = sangra_mucho;
        this.hizo_test_elisa = hizo_test_elisa;
        this.tiene_enfermedad = tiene_enfermedad;
        this.enfermedad = enfermedad;
        this.tiene_medicamentos = tiene_medicamentos;
        this.medicamentos = medicamentos;
        this.alergias = alergias;
        this.tiene_cirugias = tiene_cirugias;
        this.cirugias = cirugias;
        this.tiene_transfusion_sangre = tiene_transfusion_sangre;
        this.motivo_consulta = motivo_consulta;
        this.ultima_visita_odonto = ultima_visita_odonto;
        this.causa_perdida_dientes = causa_perdida_dientes;
        this.cant_cepillados = cant_cepillados;
        this.tolera_anestecia_odonto = tolera_anestecia_odonto;
        this.observaciones = observaciones;
        this.elementos_limpieza_bucal = elementos_limpieza_bucal;
    }

    public HealthHistory() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public boolean isTiene_tratamiento_medico() {
        return tiene_tratamiento_medico;
    }

    public void setTiene_tratamiento_medico(boolean tiene_tratamiento_medico) {
        this.tiene_tratamiento_medico = tiene_tratamiento_medico;
    }

    public String getTratamiento_medico() {
        return tratamiento_medico;
    }

    public void setTratamiento_medico(String tratamiento_medico) {
        this.tratamiento_medico = tratamiento_medico;
    }

    public boolean isSangra_mucho() {
        return sangra_mucho;
    }

    public void setSangra_mucho(boolean sangra_mucho) {
        this.sangra_mucho = sangra_mucho;
    }

    public boolean isHizo_test_elisa() {
        return hizo_test_elisa;
    }

    public void setHizo_test_elisa(boolean hizo_test_elisa) {
        this.hizo_test_elisa = hizo_test_elisa;
    }

    public boolean isTiene_enfermedad() {
        return tiene_enfermedad;
    }

    public void setTiene_enfermedad(boolean tiene_enfermedad) {
        this.tiene_enfermedad = tiene_enfermedad;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public boolean isTiene_medicamentos() {
        return tiene_medicamentos;
    }

    public void setTiene_medicamentos(boolean tiene_medicamentos) {
        this.tiene_medicamentos = tiene_medicamentos;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public boolean isTiene_cirugias() {
        return tiene_cirugias;
    }

    public void setTiene_cirugias(boolean tiene_cirugias) {
        this.tiene_cirugias = tiene_cirugias;
    }

    public String getCirugias() {
        return cirugias;
    }

    public void setCirugias(String cirugias) {
        this.cirugias = cirugias;
    }

    public boolean isTiene_transfusion_sangre() {
        return tiene_transfusion_sangre;
    }

    public void setTiene_transfusion_sangre(boolean tiene_transfusion_sangre) {
        this.tiene_transfusion_sangre = tiene_transfusion_sangre;
    }

    public String getMotivo_consulta() {
        return motivo_consulta;
    }

    public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
    }

    public Date getUltima_visita_odonto() {
        return ultima_visita_odonto;
    }

    public void setUltima_visita_odonto(Date ultima_visita_odonto) {
        this.ultima_visita_odonto = ultima_visita_odonto;
    }

    public String getCausa_perdida_dientes() {
        return causa_perdida_dientes;
    }

    public void setCausa_perdida_dientes(String causa_perdida_dientes) {
        this.causa_perdida_dientes = causa_perdida_dientes;
    }

    public String getCant_cepillados() {
        return cant_cepillados;
    }

    public void setCant_cepillados(String cant_cepillados) {
        this.cant_cepillados = cant_cepillados;
    }

    public boolean getTolera_anestecia_odonto() {
        return tolera_anestecia_odonto;
    }

    public void setTolera_anestecia_odonto(boolean tolera_anestecia_odonto) {
        this.tolera_anestecia_odonto = tolera_anestecia_odonto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<String> getElementos_limpieza_bucal() {
        return elementos_limpieza_bucal;
    }

    public void setElementos_limpieza_bucal(List<String> elementos_limpieza_bucal) {
        this.elementos_limpieza_bucal = elementos_limpieza_bucal;
    }

}
