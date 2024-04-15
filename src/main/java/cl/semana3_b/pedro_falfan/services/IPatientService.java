package cl.semana3_b.pedro_falfan.services;

import cl.semana3_b.pedro_falfan.models.PatientModel;

public interface IPatientService {
    PatientModel getPatientByRut(String rut) throws Exception;
    PatientModel createPatient(PatientModel patientModel) throws Exception;
    PatientModel updatePatient(Long id, PatientModel patientModel) throws Exception;
    boolean deletePatient(Long id) throws Exception;
}
