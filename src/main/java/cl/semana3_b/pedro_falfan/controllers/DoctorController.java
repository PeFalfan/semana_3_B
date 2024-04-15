package cl.semana3_b.pedro_falfan.controllers;

import cl.semana3_b.pedro_falfan.models.DoctorModel;
import cl.semana3_b.pedro_falfan.models.ResponseModel;
import cl.semana3_b.pedro_falfan.services.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
