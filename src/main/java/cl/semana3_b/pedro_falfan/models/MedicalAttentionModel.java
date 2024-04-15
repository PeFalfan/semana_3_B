package cl.semana3_b.pedro_falfan.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "medical_attention")
public class MedicalAttentionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "patient_id")
    private Long pacientId;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "attention_date")
    private Date attentionDate;

    @Column(name = "require_rest")
    private boolean requiresRest;

    @Column(name = "rest_start_date")
    private Date restStartDate;

    @Column(name = "rest_end_date")
    private Date restEndDate;

    public MedicalAttentionModel() {
    }

    public MedicalAttentionModel(Long id, Long doctorId, Long pacientId, String diagnosis, Date attentionDate, boolean requiresRest, Date restStartDate, Date restEndDate) {
        this.id = id;
        this.doctorId = doctorId;
        this.pacientId = pacientId;
        this.diagnosis = diagnosis;
        this.attentionDate = attentionDate;
        this.requiresRest = requiresRest;
        this.restStartDate = restStartDate;
        this.restEndDate = restEndDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPacientId() {
        return pacientId;
    }

    public void setPacientId(Long pacientId) {
        this.pacientId = pacientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getAttentionDate() {
        return attentionDate;
    }

    public void setAttentionDate(Date attentionDate) {
        this.attentionDate = attentionDate;
    }

    public boolean isRequiresRest() {
        return requiresRest;
    }

    public void setRequiresRest(boolean requiresRest) {
        this.requiresRest = requiresRest;
    }

    public Date getRestStartDate() {
        return restStartDate;
    }

    public void setRestStartDate(Date restStartDate) {
        this.restStartDate = restStartDate;
    }

    public Date getRestEndDate() {
        return restEndDate;
    }

    public void setRestEndDate(Date restEndDate) {
        this.restEndDate = restEndDate;
    }
}
