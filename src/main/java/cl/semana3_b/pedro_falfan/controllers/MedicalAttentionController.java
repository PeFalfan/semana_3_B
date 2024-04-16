package cl.semana3_b.pedro_falfan.controllers;

import cl.semana3_b.pedro_falfan.models.DoctorModel;
import cl.semana3_b.pedro_falfan.models.MedicalAttentionModel;
import cl.semana3_b.pedro_falfan.models.ResponseModel;
import cl.semana3_b.pedro_falfan.services.IMedicalAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/medicalAttentions")
public class MedicalAttentionController {

    @Autowired
    private IMedicalAttentionService medicalService;

    @PutMapping(value = "/registerAttention")
    public ResponseModel registerMedicalAttention(@RequestBody MedicalAttentionModel medicalAttention) {
        try {
            ResponseModel response = new ResponseModel();

            MedicalAttentionModel registeredAttention = medicalService.createMedicalAttention(medicalAttention);

            response.setData(registeredAttention);
            response.setError(null);
            response.setMessageResponse("Atención " + registeredAttention.getId() + " registrada con exito");

            return response;

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setError(e.getMessage());
            response.setData(null);
            response.setMessageResponse("Error al registrar atención medica");

            return response;
        }
    }

    @GetMapping(value = "/getAttentionsByPatientId{id}")
    public ResponseModel getAttentionsByPatientId(@RequestParam(value = "id") Long id) {
        try {
            ResponseModel response = new ResponseModel();

            List<MedicalAttentionModel> attentions = medicalService.getAllMedicalAttentionByPatientId(id);
            response.setData(attentions);
            response.setError(null);
            response.setMessageResponse("Se cargaron " + attentions.size() + " Atenciones registradas");

            return response;

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setData(null);
            response.setError(e.getMessage());
            response.setMessageResponse("error al obtener atenciones");

            return response;
        }
    }


}
