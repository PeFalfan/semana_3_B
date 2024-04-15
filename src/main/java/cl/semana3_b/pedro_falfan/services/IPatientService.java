package cl.semana3_b.pedro_falfan.services;

import cl.semana3_b.pedro_falfan.models.PatientModel;

import java.util.List;

public interface IPatientService {
    List<PatientModel> getAllPatients() throws Exception;
    PatientModel getPatientById(Long id) throws Exception;
    PatientModel createPatient(PatientModel patientModel) throws Exception;
    PatientModel updatePatient(Long id, PatientModel patientModel) throws Exception;
    boolean deletePatient(Long id) throws Exception;
}
