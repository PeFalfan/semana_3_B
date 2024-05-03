package cl.semana3_b.pedro_falfan.services;

import cl.semana3_b.pedro_falfan.models.DoctorModel;
import cl.semana3_b.pedro_falfan.models.ResponseModel;

import java.util.List;

public interface IDoctorService {
    ResponseModel getAllDoctors();
    ResponseModel getDoctorsBySpecialty(String specialty);
    ResponseModel createDoctor(DoctorModel doctorModel);
    ResponseModel updateDoctor(Long id, DoctorModel doctorModel);
    ResponseModel deleteDoctor(Long id);
}
