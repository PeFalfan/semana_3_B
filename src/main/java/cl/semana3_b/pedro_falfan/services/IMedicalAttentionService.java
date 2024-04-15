package cl.semana3_b.pedro_falfan.services;

import cl.semana3_b.pedro_falfan.models.MedicalAttentionModel;

import java.util.List;

public interface IMedicalAttentionService {
    List<MedicalAttentionModel> getAllMedicalAttentionByPatientId(Long patientId) throws Exception;
    MedicalAttentionModel getMedicalAttentionById(Long medicalAttentionId) throws Exception;
}
