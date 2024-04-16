package cl.semana3_b.pedro_falfan.services.impl;

import cl.semana3_b.pedro_falfan.models.MedicalAttentionModel;
import cl.semana3_b.pedro_falfan.respository.IMedicalAttentionRepository;
import cl.semana3_b.pedro_falfan.services.IMedicalAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalAttentionServiceImpl implements IMedicalAttentionService {

    @Autowired
    private IMedicalAttentionRepository attentionRepository;

    @Override
    public MedicalAttentionModel createMedicalAttention(MedicalAttentionModel medicalAttention) throws Exception {
        return attentionRepository.save(medicalAttention);
    }

    @Override
    public List<MedicalAttentionModel> getAllMedicalAttentionByPatientId(Long patientId) throws Exception {
        List<MedicalAttentionModel> attentions = attentionRepository.findAll();

        List<MedicalAttentionModel> patientsAttentions = new ArrayList<>();

        for (MedicalAttentionModel attention : attentions) {
            if(attention.getPacientId().equals(patientId)) {
                patientsAttentions.add(attention);
            }
        }

        if (patientsAttentions.isEmpty()) {
            throw new Exception("No se encuentran atenciones registradas para ese paciente");
        }

        return patientsAttentions;
    }
}
