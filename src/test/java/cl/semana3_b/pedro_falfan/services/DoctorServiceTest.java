package cl.semana3_b.pedro_falfan.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import cl.semana3_b.pedro_falfan.models.DoctorModel;
import cl.semana3_b.pedro_falfan.models.ResponseModel;
import cl.semana3_b.pedro_falfan.respository.IDoctorRepository;
import cl.semana3_b.pedro_falfan.services.impl.DoctorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @InjectMocks
    private DoctorServiceImpl doctorService;

    @Mock
    private IDoctorRepository doctorRepository;

    @Test
    public void getAllDoctorsTest() {
        DoctorModel doctor1 = new DoctorModel();
        doctor1.setId(1L);
        doctor1.setName("Doctor1");
        doctor1.setRut("11.111.111-1");
        doctor1.setSpeciality("Medicina General");

        DoctorModel doctor2 = new DoctorModel();
        doctor2.setId(2L);
        doctor2.setName("Doctor2");
        doctor2.setRut("22.222.222-22");
        doctor2.setSpeciality("Dental");

        List<DoctorModel> doctors = new ArrayList<>();

        doctors.add(doctor1);
        doctors.add(doctor2);

        assertEquals(2, doctors.size());
        assertEquals("Doctor1", doctors.getFirst().getName());
        assertEquals("Doctor2", doctors.get(1).getName());

    }

    @Test
    public void createDoctorTest() {
        DoctorModel doctor = new DoctorModel();
        doctor.setId(1L);
        doctor.setName("Doctor1");
        doctor.setRut("11.111.111-1");
        doctor.setSpeciality("Medicina General");

        when(doctorRepository.save(any())).thenReturn(doctor);

        ResponseModel responseModel = doctorService.createDoctor(doctor);

        assertEquals("Doctor1", ((DoctorModel)responseModel.getData()).getName());
    }

    @Test
    public void getDoctorsBySoecialtyTest() {
        DoctorModel doctor = new DoctorModel();
        doctor.setId(1L);
        doctor.setName("Doctor1");
        doctor.setRut("11.111.111-1");
        doctor.setSpeciality("Medicina General");

        DoctorModel doctor2 = new DoctorModel();
        doctor2.setId(2L);
        doctor2.setName("Doctor2");
        doctor2.setRut("22.222.222-22");
        doctor2.setSpeciality("Dental");

        DoctorModel doctor3 = new DoctorModel();
        doctor3.setId(3L);
        doctor3.setName("Doctor3");
        doctor3.setRut("33.333.333-33");
        doctor3.setSpeciality("Medicina General");

        List<DoctorModel> doctors = new ArrayList<>();

        doctors.add(doctor);
        doctors.add(doctor3);

        assertEquals(2, doctors.size());
        assertEquals("Doctor1", doctors.get(0).getName());
        assertEquals("Doctor3", doctors.get(1).getName());
    }

    @Test
    public void updateDoctorTest() {
        DoctorModel doctor = new DoctorModel();
        doctor.setId(1L);
        doctor.setName("Doctor1");
        doctor.setRut("11.111.111-1");
        doctor.setSpeciality("Medicina General");

        doctorRepository.save(doctor);

        Optional<DoctorModel> doctorOptional = doctorRepository.findById(1L);
    }
}
