package cl.semana3_b.pedro_falfan.models;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class DoctorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rut")
    private String rut;

    @Column(name = "speciality")
    private String speciality;

    public DoctorModel() {
    }

    public DoctorModel(Long id, String name, String rut, String speciality) {
        this.id = id;
        this.name = name;
        this.rut = rut;
        this.speciality = speciality;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
