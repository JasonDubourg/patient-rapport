package com.mediscreen.patientrapport.entity;

public class PatientNote {
    private String id;
    private int patientId;
    private String notes;

    public PatientNote() {
    }

    public PatientNote(int patientId, String notes) {
        this.patientId = patientId;
        this.notes = notes;
    }

    public String getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return String.format("Patient note = [id: %s, Patient id: '%s', Notes: '%s']", id, patientId, notes);
    }

}
