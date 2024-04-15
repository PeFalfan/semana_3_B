package cl.semana3_b.pedro_falfan.services.impl;

import cl.semana3_b.pedro_falfan.models.DoctorModel;
import cl.semana3_b.pedro_falfan.respository.IDoctorRepository;
import cl.semana3_b.pedro_falfan.services.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return List.of();
    }

    @Override
    public DoctorModel getDoctorById(Long id) throws Exception {
        return null;
    }


    @Override
    public DoctorModel updateDoctor(Long id, DoctorModel doctorModel) throws Exception {
        return null;
    }

    @Override
    public boolean deleteDoctor(Long id) throws Exception {
        return false;
    }
}
