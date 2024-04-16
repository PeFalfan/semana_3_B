package cl.semana3_b.pedro_falfan.services.impl;

import cl.semana3_b.pedro_falfan.models.DoctorModel;
import cl.semana3_b.pedro_falfan.respository.IDoctorRepository;
import cl.semana3_b.pedro_falfan.services.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    private IDoctorRepository doctorRepository;

    @Override
    public DoctorModel createDoctor(DoctorModel doctor) throws Exception {
        List<DoctorModel> doctors = doctorRepository.findAll();

        for (DoctorModel doc : doctors) {
            if(doc.getRut().equals(doctor.getRut())) {
                throw new Exception("El rut del doctor ya se encuentra registrado!");
            }
        }
        return doctorRepository.save(doctor);
    }


    @Override
    public List<DoctorModel> getAllDoctors() throws Exception {
        List<DoctorModel> doctors = doctorRepository.findAll();

        if (doctors.isEmpty()) {
            throw new Exception("No se encuentran doctores registrados");
        }
        return doctorRepository.findAll();
    }

    @Override
    public List<DoctorModel> getDoctorsBySpecialty(String specialty) throws Exception {
        List<DoctorModel> doctors = doctorRepository.findAll();

        List<DoctorModel> doctorsOfTheSpecialty = new ArrayList<>();

        if (doctors.isEmpty()) {
            throw new Exception("No se encuentran doctores registrados");
        }
        for (DoctorModel doc : doctors) {
            if(doc.getSpeciality().equals(specialty)) {
                doctorsOfTheSpecialty.add(doc);
            }
        }

        return doctorsOfTheSpecialty;
    }


    @Override
    public DoctorModel updateDoctor(Long id, DoctorModel doctor) throws Exception {
        if (doctorRepository.existsById(id)) {
            doctor.setId(id);
            return doctorRepository.save(doctor);
        }
        throw new Exception("No existe el doctor con id " + id);
    }

    @Override
    public boolean deleteDoctor(Long id) throws Exception {

        List<DoctorModel> doctors = doctorRepository.findAll();

        for (DoctorModel doc : doctors) {
            if(doc.getId().equals(id)) {
                doctorRepository.delete(doc);
                return true;
            }
        }

        throw new Exception("No existe el doctor con id " + id);
    }
}
