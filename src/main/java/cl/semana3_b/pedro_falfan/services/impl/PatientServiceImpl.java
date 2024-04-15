package cl.semana3_b.pedro_falfan.services.impl;

import cl.semana3_b.pedro_falfan.models.PatientModel;
import cl.semana3_b.pedro_falfan.respository.IPatientRepository;
import cl.semana3_b.pedro_falfan.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public PatientModel getPatientByRut(String rut) throws Exception {

        List<PatientModel> patients = patientRepository.findAll();

        for (PatientModel patient : patients) {
            if (patient.getRut().equals(rut)) {
                return patient;
            }
        }

        throw new Exception("No se encuentra paciente bajo el rut: " + rut);
    }

    @Override
    public PatientModel createPatient(PatientModel patient) throws Exception {
        List<PatientModel> patients = patientRepository.findAll();

        for (PatientModel p : patients) {
            if(p.getRut().equals(patient.getRut())) {
                throw new Exception("El rut del paciente ya se encuentra registrado!");
            }
        }
        return patientRepository.save(patient);
    }

    @Override
    public PatientModel updatePatient(Long id, PatientModel patient) throws Exception {
        if(patientRepository.existsById(id)) {
            patient.setId(id);
            return patientRepository.save(patient);
        }
        throw new Exception("No existe el paciente con el id: " + id);
    }

    @Override
    public boolean deletePatient(Long id) throws Exception {

        List<PatientModel> patients = patientRepository.findAll();

        for(PatientModel u : patients) {
            if(u.getId().equals(id)) {
                patientRepository.delete(u);
                return true;
            }
        }

        throw new Exception("No existe el paciente con id " + id);
    }
}
