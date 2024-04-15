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




//    @GetMapping(value = "/getClient{rut}")
//    public @ResponseBody ResponseModel getClientInformation(@RequestParam(value = "rut") String clientRut) {
//        ResponseModel response = new ResponseModel();
//
//        response.setData(null);
//        response.setError("No se pudieron cargar datos de paciente");
//        response.setMessageResponse("Datos no recuperados");
//
//        for (PatientModel patient : patients) {
//            if (patient.getRut().equals(clientRut)) {
//                response.setData(patient);
//                response.setError(null);
//                response.setMessageResponse("Datos recuperados exitosamente");
//            }
//        }
//
//        return response;
//    }
//
//    @GetMapping(value = "/getDoctorBySpeciality{speciality}")
//    public @ResponseBody ResponseModel getDoctorBySpeciality(@RequestParam(value = "speciality") String doctorSpeciality) {
//        ResponseModel response = new ResponseModel();
//
//        response.setData(null);
//        response.setError("No se pudieron cargar datos del doctor");
//        response.setMessageResponse("Datos no recuperados");
//
//        for (DoctorModel doctor : doctors) {
//            if (doctor.getSpeciality().equals(doctorSpeciality)) {
//                response.setData(doctor);
//                response.setError(null);
//                response.setMessageResponse("Datos recuperados exitosamente");
//            }
//        }
//
//        return response;
//    }
//
//    @GetMapping(value = "/getClientAttentionsByRut{rut}")
//    public @ResponseBody ResponseModel getClientAttentionsByRut(@RequestParam(value = "rut") String clientRut) {
//        ResponseModel response = new ResponseModel();
//
//        List<MedicalAttention> attentionsToSend = new ArrayList<>();
//
//        response.setData(null);
//        response.setError("No se pudieron cargar datos de paciente");
//        response.setMessageResponse("Datos no recuperados");
//
//        for (MedicalAttention attention : attentions) {
//
//
//            if (attention.getPacient().getRut().equals(clientRut)) {
//
//                //System.out.println(attention.getPacient().getRut());
//
//                attentionsToSend.add(attention);
//            }
//        }
//
//
//        response.setData(attentionsToSend);
//        response.setError(null);
//        response.setMessageResponse("Datos recuperados exitosamente");
//
//        return response;
//    }


    //    public PatientController() {
//
//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.set(1000, Calendar.AUGUST, 22);
//        patients.add(
//                new PatientModel(
//                        "",
//                        600,
//                        calendar1.getTime(),
//                        "+56999999999"));
//
//
//        Calendar calendar2 = Calendar.getInstance();
//        calendar2.set(500, Calendar.SEPTEMBER, 2);
//        patients.add(
//                new PatientModel(
//                        "88.888.888-8",
//                        "Malenia",
//                        "Blade of Miquella",
//                        1100,
//                        calendar2.getTime(),
//                        "+56988888888"));
//
//
//        Calendar calendar3 = Calendar.getInstance();
//        calendar3.set(0, Calendar.JANUARY, 1);
//        patients.add(
//                new PatientModel(
//                        "00.000.000-0",
//                        "Hoarah",
//                        "Loux",
//                        1700,
//                        calendar3.getTime(),
//                        "+56911111111"));
//
//        doctors.add(
//                new DoctorModel("", "Dental"));
//
//        doctors.add(
//                new DoctorModel("Miquella", "Medicina General"));
//
//        Calendar calendar4 = Calendar.getInstance();
//        calendar4.set(1000, Calendar.AUGUST, 22);
//
//        attentions.add(
//                new MedicalAttention(
//                        "A001",
//                        doctors.get(0),
//                        patients.get(0),
//                        "Se siente mal, se le recomienda sentarce bien",
//                        calendar4.getTime(),
//                        false));
//
//
//        attentions.add(
//                new MedicalAttention(
//                        "A004",
//                        doctors.get(1),
//                        patients.get(0),
//                        "Se siente mal, se le recomienda mejorar",
//                        calendar4.getTime(),
//                        false));
//
//
//        Calendar calendar5 = Calendar.getInstance();
//        calendar5.set(1000, Calendar.AUGUST, 22);
//
//        Calendar calendar6 = Calendar.getInstance();
//        calendar6.set(1000, Calendar.AUGUST, 22);
//
//        Calendar calendar7 = Calendar.getInstance();
//        calendar7.set(1001, Calendar.AUGUST, 22);
//
//        attentions.add(
//                new MedicalAttention(
//                        "A002",
//                        doctors.get(1),
//                        patients.get(1),
//                        "Está malito, hay que hacerle la murición",
//                        calendar5.getTime(),
//                        true,
//                        calendar6.getTime(),
//                        calendar7.getTime()));
//    }


}
