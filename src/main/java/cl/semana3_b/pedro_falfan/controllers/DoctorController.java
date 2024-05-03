package cl.semana3_b.pedro_falfan.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import cl.semana3_b.pedro_falfan.models.DoctorModel;
import cl.semana3_b.pedro_falfan.models.ResponseModel;
import cl.semana3_b.pedro_falfan.services.IDoctorService;

import java.util.List;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {

    private static final Logger log = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    private IDoctorService doctorService;

    @GetMapping
    public ResponseModel getAllDoctors() {

        log.info("GET /doctors");
        log.info("Retornando todos los doctores");

        ResponseModel response = doctorService.getAllDoctors();

        if (response.getData() != null) {
            @SuppressWarnings({"unchecked"})
            List<EntityModel<DoctorModel>> doctors = ((List<DoctorModel>) response.getData()).stream()
                    .map(doc -> EntityModel.of(doc,
                            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass())
                                    .getDoctorsBySpecialty(doc.getSpeciality())).withSelfRel())).toList();

            WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllDoctors());

            CollectionModel<EntityModel<DoctorModel>> resources = CollectionModel.of(doctors, linkTo.withRel("doctors"));

            response.setData(resources);
        }

        return response;
    }

    @PutMapping(value = "/registerDoctor")
    public ResponseModel registerDoctor(@RequestBody DoctorModel doctor) {
        log.info("PUT /doctors/registerDoctor");
        log.info("Registrando el doctor");

        ResponseModel response = doctorService.createDoctor(doctor);

        if (response.getData() != null) {
            EntityModel<DoctorModel> doc = EntityModel.of(((DoctorModel)response.getData()),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass())
                            .getDoctorsBySpecialty(((DoctorModel)response.getData()).getSpeciality())).withSelfRel());

            response.setData(doc);
        }

        return response;
    }

    @GetMapping(value = "/getDoctorsBySpecialty{specialty}")
    public ResponseModel getDoctorsBySpecialty(@RequestParam(value = "specialty") String specialty) {

        log.info("GET /doctors/getDoctorsBySpecialty{specialty}");
        log.info("Retornando todos los doctores de una especialidad");

        ResponseModel response = doctorService.getDoctorsBySpecialty(specialty);

        if (response.getData() != null) {
            @SuppressWarnings({"unchecked"})
            List<EntityModel<DoctorModel>> doctors = ((List<DoctorModel>) response.getData()).stream()
                    .map(doc -> EntityModel.of(doc,
                            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass())
                                    .getDoctorsBySpecialty(doc.getSpeciality())).withSelfRel())).toList();

            WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllDoctors());

            CollectionModel<EntityModel<DoctorModel>> resources = CollectionModel.of(doctors, linkTo.withRel("/doctors/getDoctorsBySpecialty"));

            response.setData(resources);
        }

        return response;
    }

    @PutMapping(value = "/updateDoctor{id}")
    public ResponseModel updateDoctor(@RequestParam(value = "id")Long id, @RequestBody DoctorModel doctor) {
        log.info("PUT /doctors/updateDoctor{id}");
        log.info("Actualizando datos del doctor");

        ResponseModel response = doctorService.updateDoctor(id, doctor);

        if (response.getData() != null) {
            EntityModel<DoctorModel> doc = EntityModel.of(((DoctorModel)response.getData()),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass())
                            .getDoctorsBySpecialty(((DoctorModel)response.getData()).getSpeciality())).withSelfRel());

            response.setData(doc);
        }

        return response;
    }

    @DeleteMapping(value = "/deleteDoctorById{id}")
    public ResponseModel deleteDoctor(@RequestParam(value = "id") Long id) {
        log.info("DELETE /doctors/deleteDoctorById{id}");
        log.info("Eliminamos al doctor");

        return doctorService.deleteDoctor(id);

    }

}
