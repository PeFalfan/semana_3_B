package cl.semana3_b.pedro_falfan.models;

import java.util.Date;

public class MedicalAttention {
    private String attentionId;
    private DoctorModel doctor;
    private PatientModel pacient;
    private String diagnosis;
    private Date attentionDate;
    private boolean requiresRest;
    private Date restStartDate;
    private Date restEndDate;

    public MedicalAttention(String attentionId, DoctorModel doctor, PatientModel pacient, String diagnosis, Date attentionDate, boolean requiresRest) {
        this.attentionId = attentionId;
        this.doctor = doctor;
        this.pacient = pacient;
        this.diagnosis = diagnosis;
        this.attentionDate = attentionDate;
        this.requiresRest = requiresRest;
    }

    public MedicalAttention(String attentionId, DoctorModel doctor, PatientModel pacient, String diagnosis, Date attentionDate, boolean requiresRest, Date restStartDate, Date restEndDate) {
        this.attentionId = attentionId;
        this.doctor = doctor;
        this.pacient = pacient;
        this.diagnosis = diagnosis;
        this.attentionDate = attentionDate;
        this.requiresRest = requiresRest;
        this.restStartDate = restStartDate;
        this.restEndDate = restEndDate;
    }

    public String getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(String attentionId) {
        this.attentionId = attentionId;
    }

    public DoctorModel getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorModel doctor) {
        this.doctor = doctor;
    }

    public PatientModel getPacient() {
        return pacient;
    }

    public void setPacient(PatientModel pacient) {
        this.pacient = pacient;
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
