package cl.semana3_b.pedro_falfan.services;

import cl.semana3_b.pedro_falfan.models.MedicalAttentionModel;

import java.util.List;

public interface IMedicalAttentionService {
    MedicalAttentionModel createMedicalAttention(MedicalAttentionModel medicalAttention) throws Exception;
    List<MedicalAttentionModel> getAllMedicalAttentionByPatientId(Long patientId) throws Exception;
}
