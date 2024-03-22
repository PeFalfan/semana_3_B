package cl.semana3_b.pedro_falfan.models;

import java.util.Date;

public class PatientModel {
    private String rut;
    private String name;
    private String lastName;
    private int age;
    private Date birthDate;
    private String phoneNumber;

    public PatientModel(String rut, String name, String lastName, int age, Date birthDate, String phoneNumber) {
        this.rut = rut;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}