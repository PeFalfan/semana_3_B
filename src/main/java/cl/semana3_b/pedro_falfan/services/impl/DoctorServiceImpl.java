package cl.semana3_b.pedro_falfan.services.impl;

import cl.semana3_b.pedro_falfan.models.DoctorModel;
import cl.semana3_b.pedro_falfan.models.ResponseModel;
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
    public ResponseModel getAllDoctors() {
        try {
            ResponseModel response = new ResponseModel();
            List<DoctorModel> doctors = doctorRepository.findAll();

            if (doctors.isEmpty()) {
                response.setMessageResponse("No se encuentran doctores registrados");
                response.setData(null);
                response.setError("No se encuentran doctores registrados");
                return response;
            }

            response.setMessageResponse("Doctores registrados");
            response.setData(doctors);
            response.setError(null);
            return response;

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMessageResponse("Error al buscar registros de doctores");
            response.setData(null);
            response.setError(e.getMessage());
            return response;
        }
    }

    @Override
    public ResponseModel createDoctor(DoctorModel doctor) {
        try {
            ResponseModel response = new ResponseModel();

            List<DoctorModel> doctors = doctorRepository.findAll();

            for (DoctorModel doc : doctors) {
                if(doc.getRut().equals(doctor.getRut())) {

                    response.setError("El rut del doctor ya se encuentra registrado!");
                    response.setData(null);
                    response.setMessageResponse("Error al registrar al doctor");

                    return response;
                }
            }

            DoctorModel registeredDoctor = doctorRepository.save(doctor);
            response.setData(registeredDoctor);
            response.setError(null);
            response.setMessageResponse("Doctor " + registeredDoctor.getName() + " registrado con exito");

            return response;

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setError(e.getMessage());
            response.setData(null);
            response.setMessageResponse("Error al registrar al doctor");

            return response;
        }
    }

    @Override
    public ResponseModel getDoctorsBySpecialty(String specialty) {
        try {
            ResponseModel response = new ResponseModel();

            List<DoctorModel> doctors = doctorRepository.findAll();

            List<DoctorModel> doctorsOfTheSpecialty = new ArrayList<>();

            if (doctors.isEmpty()) {
                response.setData(null);
                response.setError("No se encuentran doctores registrados");
                response.setMessageResponse("Error al buscar registros de doctores");
                return response;
            }

            for (DoctorModel doc : doctors) {
                if(doc.getSpeciality().equals(specialty)) {
                    doctorsOfTheSpecialty.add(doc);
                }
            }

            response.setData(doctorsOfTheSpecialty);
            response.setError(null);
            response.setMessageResponse("Se cargaron " + doctors.size() + " doctores registrados");

            return response;

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setData(null);
            response.setError(e.getMessage());
            response.setMessageResponse("error al obtener los doctores");

            return response;
        }
    }

    @Override
    public ResponseModel updateDoctor(Long id, DoctorModel doctor) {
        try {
            ResponseModel response = new ResponseModel();

            if (doctorRepository.existsById(id)) {
                doctor.setId(id);
                DoctorModel updatedDoctor = doctorRepository.save(doctor);
                response.setError(null);
                response.setData(updatedDoctor);
                response.setMessageResponse("Doctor " + updatedDoctor.getName() + " actualizado con exito");

                return response;
            }

            response.setError("No existe el doctor con id " + id);
            response.setData(null);
            response.setMessageResponse("Error al actualizar el doctor");

            return response;

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setError(e.getMessage());
            response.setData(null);
            response.setMessageResponse("Error al actualizar el doctor");

            return response;
        }
    }

    @Override
    public ResponseModel deleteDoctor(Long id) {
        try {
            ResponseModel response = new ResponseModel();

            List<DoctorModel> doctors = doctorRepository.findAll();

            for (DoctorModel doc : doctors) {
                if(doc.getId().equals(id)) {
                    doctorRepository.delete(doc);
                    response.setData(true);
                    response.setError(null);
                    response.setMessageResponse("Doctor de id: " + id + " eliminado con exito");
                    return response;
                }
            }

            response.setError("No existe el doctor con id " + id);
            response.setData(null);
            response.setMessageResponse("Error al eliminar el doctor");

            return response;

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setError(e.getMessage());
            response.setData(null);
            response.setMessageResponse("Error al eliminar el doctor");

            return response;
        }

    }
}
