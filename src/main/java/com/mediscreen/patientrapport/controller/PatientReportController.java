package com.mediscreen.patientrapport.controller;

import com.mediscreen.patientrapport.entity.PatientDiabetesReport;
import com.mediscreen.patientrapport.entity.PatientWithNote;
import com.mediscreen.patientrapport.service.PatientReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "Génère le rapport du patient")
@RestController
public class PatientReportController {

    @Autowired
    PatientReportService patientReportService;

    @ApiOperation(value = "Génère le rapport de diabète du patient")
    @PostMapping(value = "/patient-report")
    public PatientDiabetesReport generatePatientDiabetesReport(@RequestBody PatientWithNote patientWithNote) {
        return patientReportService.generatePatientDiabetesReport(patientWithNote);
    }
}
