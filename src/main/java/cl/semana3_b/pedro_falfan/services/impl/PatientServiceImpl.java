package cl.semana3_b.pedro_falfan.services.impl;

import cl.semana3_b.pedro_falfan.models.PatientModel;
import cl.semana3_b.pedro_falfan.services.IPatientService;

import java.util.List;

public class PatientServiceImpl implements IPatientService {
    @Override
    public List<PatientModel> getAllPatients() throws Exception {
        return List.of();
    }

    @Override
    public PatientModel getPatientById(Long id) throws Exception {
        return null;
    }

    @Override
    public PatientModel createPatient(PatientModel patientModel) throws Exception {
        return null;
    }

    @Override
    public PatientModel updatePatient(Long id, PatientModel patientModel) throws Exception {
        return null;
    }

    @Override
    public boolean deletePatient(Long id) throws Exception {
        return false;
    }
}
