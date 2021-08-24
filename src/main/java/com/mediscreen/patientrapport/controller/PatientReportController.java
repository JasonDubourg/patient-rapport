package com.mediscreen.patientrapport.controller;

import com.mediscreen.patientrapport.entity.PatientDiabetesReport;
import com.mediscreen.patientrapport.entity.PatientWithNote;
import com.mediscreen.patientrapport.service.PatientReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientReportController {

    @Autowired
    PatientReportService patientReportService;

    @GetMapping(value = "/patient-report")
    public PatientDiabetesReport generatePatientDiabetesReport(@RequestBody PatientWithNote patientWithNote) {
        return patientReportService.generatePatientDiabetesReport(patientWithNote);
    }
}
