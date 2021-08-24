package com.mediscreen.patientrapport.entity;

public class PatientWithNote {
    private Patient patient;
    private PatientNote patientNote;

    public PatientWithNote() {
    }

    public PatientWithNote(Patient patient, PatientNote patientNote) {
        this.patient = patient;
        this.patientNote = patientNote;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PatientNote getPatientNote() {
        return patientNote;
    }

    public void setPatientNote(PatientNote patientNote) {
        this.patientNote = patientNote;
    }

    @Override
    public String toString() {
        return "PatientWithNote{" +
                "patient=" + patient +
                ", patientNote=" + patientNote +
                '}';
    }
}
