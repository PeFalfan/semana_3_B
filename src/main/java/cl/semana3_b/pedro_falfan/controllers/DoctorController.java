package cl.semana3_b.pedro_falfan.controllers;

import cl.semana3_b.pedro_falfan.models.DoctorModel;
import cl.semana3_b.pedro_falfan.models.PatientModel;
import cl.semana3_b.pedro_falfan.models.ResponseModel;
import cl.semana3_b.pedro_falfan.services.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    @PutMapping(value = "/registerDoctor")
    public ResponseModel registerDoctor(@RequestBody DoctorModel doctor) {
        try {
            ResponseModel response = new ResponseModel();

            DoctorModel registeredDoctor = doctorService.createDoctor(doctor);
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

    @GetMapping
    public ResponseModel getAllDoctors() {
        try {
            ResponseModel response = new ResponseModel();

            List<DoctorModel> doctors = doctorService.getAllDoctors();

            response.setMessageResponse("Se encuentran: " + doctors.size() + " doctores registrados");
            response.setData(doctors);
            response.setError(null);

            return response;

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setError(e.getMessage());
            response.setData(null);
            response.setMessageResponse("Error al obtener los doctores");

            return response;
        }
    }

    @GetMapping(value = "/getDoctorsBySpecialty{specialty}")
    public ResponseModel getDoctorsBySpecialty(@RequestParam(value = "specialty") String specialty) {
        try {
            ResponseModel response = new ResponseModel();

            List<DoctorModel> doctors = doctorService.getDoctorsBySpecialty(specialty);
            response.setData(doctors);
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

    @PutMapping(value = "/updateDoctor{id}")
    public ResponseModel updateDoctor(@RequestParam(value = "id")Long id, @RequestBody DoctorModel doctor) {
        try {
            ResponseModel response = new ResponseModel();
            DoctorModel updatedDoctor = doctorService.updateDoctor(id, doctor);
            response.setData(updatedDoctor);
            response.setError(null);
            response.setMessageResponse("Doctor " + updatedDoctor.getName() + " actualizado con exito");

            return response;

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setError(e.getMessage());
            response.setData(null);
            response.setMessageResponse("Error al actualizar el doctor");

            return response;
        }
    }

    @DeleteMapping(value = "/deleteDoctorById{id}")
    public ResponseModel deleteDoctor(@RequestParam(value = "id") Long id) {
        try {
            ResponseModel response = new ResponseModel();
            response.setData(doctorService.deleteDoctor(id));
            response.setError(null);
            response.setMessageResponse("Doctor de id: " + id + " eliminado con exito");

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
