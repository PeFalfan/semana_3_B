package cl.semana3_b.pedro_falfan.services;

import cl.semana3_b.pedro_falfan.models.DoctorModel;

import java.util.List;

public interface IDoctorService {
    List<DoctorModel> getAllDoctors() throws Exception;
    DoctorModel getDoctorById(Long id) throws Exception;
    DoctorModel createDoctor(DoctorModel doctorModel) throws Exception;
    DoctorModel updateDoctor(Long id, DoctorModel doctorModel) throws Exception;
    boolean deleteDoctor(Long id) throws Exception;
}
