package cl.semana3_b.pedro_falfan.models;

public class DoctorModel {
    private String name;
    private String speciality;

    public DoctorModel(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
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
