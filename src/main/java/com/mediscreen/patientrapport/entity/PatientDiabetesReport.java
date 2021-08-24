package com.mediscreen.patientrapport.entity;

public class PatientDiabetesReport {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private DiabetesPatientRiskLevel diabetesPatientRiskLevel;

    public PatientDiabetesReport() {
    }

    public PatientDiabetesReport(String firstName, String lastName, String gender, int age, DiabetesPatientRiskLevel diabetesPatientRiskLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.diabetesPatientRiskLevel = diabetesPatientRiskLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DiabetesPatientRiskLevel getDiabetesPatientRiskLevel() {
        return diabetesPatientRiskLevel;
    }

    public void setDiabetesPatientRiskLevel(DiabetesPatientRiskLevel diabetesPatientRiskLevel) {
        this.diabetesPatientRiskLevel = diabetesPatientRiskLevel;
    }

    @Override
    public String toString() {
        return "PatientDiabetesReport{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", diabetesPatientRiskLevel=" + diabetesPatientRiskLevel +
                '}';
    }
}
