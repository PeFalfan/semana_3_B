package cl.semana3_b.pedro_falfan.controllers;

import cl.semana3_b.pedro_falfan.models.PatientModel;
import cl.semana3_b.pedro_falfan.models.ResponseModel;
import cl.semana3_b.pedro_falfan.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/patients")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @PutMapping(value = "/registerPatient")
    public ResponseModel registerPatient(@RequestBody PatientModel patient) {
        try {
            ResponseModel response = new ResponseModel();

            PatientModel registeredPatient = patientService.createPatient(patient);

            response.setData(registeredPatient);
            response.setError(null);
            response.setMessageResponse("Paciente " + registeredPatient.getName() + " registrado con exito");

            return response;

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setError(e.getMessage());
            response.setData(null);
            response.setMessageResponse("Error al registrar el paciente");

            return response;
        }
    }

    @GetMapping(value = "/getPatientByRut{rut}")
    public ResponseModel getPatientById(@RequestParam(value = "rut") String rut) {
        try {
            ResponseModel response = new ResponseModel();
            PatientModel patient = patientService.getPatientByRut(rut);
            response.setData(patient);
            response.setError(null);
            response.setMessageResponse("Paciente " + patient.getName() + " consultado con exito");

            return response;

        }catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setError(e.getMessage());
            response.setData(null);
            response.setMessageResponse("Error al consultar el paciente");

            return response;
        }
    }

    @PutMapping(value = "/updatePatient{id}")
    public ResponseModel updatePatient(@RequestParam(value = "id") Long id, @RequestBody PatientModel patient) {
        try {
            ResponseModel response = new ResponseModel();
            PatientModel updatedPatient = patientService.updatePatient(id, patient);
            response.setData(updatedPatient);
            response.setError(null);
            response.setMessageResponse("Paciente " + patient.getName() + " actualizado con exito");

            return response;

        }catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setError(e.getMessage());
            response.setData(null);
            response.setMessageResponse("Error al actualizar el paciente");

            return response;
        }
    }

    @DeleteMapping(value = "/deletePatientById{id}")
    public ResponseModel deletePatient(@RequestParam(value = "id") Long id) {
        try {
            ResponseModel response = new ResponseModel();
            response.setData(patientService.deletePatient(id));
            response.setError(null);
            response.setMessageResponse("Paciente " + id + " eliminado con exito");

            return response;

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setError(e.getMessage());
            response.setData(null);
            response.setMessageResponse("Error al eliminar el paciente");

            return response;
        }
    }
}
