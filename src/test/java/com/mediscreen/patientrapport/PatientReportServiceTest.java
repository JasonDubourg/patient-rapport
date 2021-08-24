package com.mediscreen.patientrapport;

import com.mediscreen.patientrapport.entity.*;
import com.mediscreen.patientrapport.service.PatientReportService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatientReportServiceTest {

    @Autowired
    PatientReportService patientReportService;

    @Test
    void generatePatientDiabetesReportTest(){
        DiabetesPatientRiskLevel diabetesPatientRiskLevel = DiabetesPatientRiskLevel.NONE;
        Patient patient= new Patient("John","Snow","03/12/1992","Homme","address","phone");
        PatientNote patientNote = new PatientNote(1, "Note");
        PatientDiabetesReport patientDiabetesReport = new PatientDiabetesReport("John", "Snow", "Homme", 29, diabetesPatientRiskLevel );
        PatientWithNote patientWithNote = new PatientWithNote(patient, patientNote);
        patientReportService.generatePatientDiabetesReport(patientWithNote);
        assertEquals("John", patientDiabetesReport.getFirstName());
        assertEquals(DiabetesPatientRiskLevel.NONE, patientDiabetesReport.getDiabetesPatientRiskLevel());
    }

    @Test
    void calculPatientDiabetesReportTest(){
        Patient patient= new Patient("Cersei","Lanister","03/12/1988","Femme","address","phone");
        PatientNote patientNote = new PatientNote(1, "Taille fumeur");
        DiabetesPatientRiskLevel diabetesPatientRiskLevel = DiabetesPatientRiskLevel.BORDERLINE;
        PatientDiabetesReport patientDiabetesReportTest = patientReportService.calculPatientDiabetesReport(patient, patientNote);
        assertEquals("Cersei", patientDiabetesReportTest.getFirstName());
        assertEquals(DiabetesPatientRiskLevel.BORDERLINE, patientDiabetesReportTest.getDiabetesPatientRiskLevel());
    }

    @Test
    void calculPatientAgeFromDateOfBirthTest(){
        Patient patient= new Patient("Cersei","Lanister","03/12/1988","Femme","address","phone");
        int age = patientReportService.calculPatientAgeFromDateOfBirth(patient.getDateOfBirth());
        assertEquals(33, age);
    }

    @Test
    void numberOfTriggerWordTest(){
        PatientNote patientNote = new PatientNote(1, "Persone de grande taille fumeuse, souffre de cholestérol anormal. Elle a fait une rechute, pleins de réaction avec anticorps");
        int triggerWords = patientReportService.numberOfTriggerWord(patientNote);
        assertEquals(6, triggerWords);
    }

    @Test
    void manDiabetesReportWithNoneRiskTest(){
        Patient patient= new Patient("John","Snow","03/12/1992","Homme","address","phone");
        int age = 29;
        int triggerWords = 2;
        PatientDiabetesReport patientDiabetesReportTest = patientReportService.manDiabetesReport(patient, age, triggerWords);
        assertEquals(DiabetesPatientRiskLevel.NONE, patientDiabetesReportTest.getDiabetesPatientRiskLevel());
    }

    @Test
    void manDiabetesReportWithBorderlineRiskTest(){
        Patient patient= new Patient("John","Snow","03/12/1988","Homme","address","phone");
        int age = 33;
        int triggerWords = 4;
        PatientDiabetesReport patientDiabetesReportTest = patientReportService.manDiabetesReport(patient, age, triggerWords);
        assertEquals(DiabetesPatientRiskLevel.BORDERLINE, patientDiabetesReportTest.getDiabetesPatientRiskLevel());
    }

    @Test
    void manDiabetesReportWithInDangerRiskTest(){
        Patient patient= new Patient("John","Snow","03/12/1988","Homme","address","phone");
        int age = 33;
        int triggerWords = 6;
        PatientDiabetesReport patientDiabetesReportTest = patientReportService.manDiabetesReport(patient, age, triggerWords);
        assertEquals(DiabetesPatientRiskLevel.IN_DANGER, patientDiabetesReportTest.getDiabetesPatientRiskLevel());
    }

    @Test
    void manDiabetesReportWithEarlyOnsetRiskTest1(){
        Patient patient= new Patient("John","Snow","03/12/1992","Homme","address","phone");
        int age = 29;
        int triggerWords = 5;
        PatientDiabetesReport patientDiabetesReportTest = patientReportService.manDiabetesReport(patient, age, triggerWords);
        assertEquals(DiabetesPatientRiskLevel.EARLY_ONSET, patientDiabetesReportTest.getDiabetesPatientRiskLevel());
    }

    @Test
    void manDiabetesReportWithEarlyOnsetRiskTest2(){
        Patient patient= new Patient("John","Snow","03/12/1988","Homme","address","phone");
        int age = 33;
        int triggerWords = 9;
        PatientDiabetesReport patientDiabetesReportTest = patientReportService.manDiabetesReport(patient, age, triggerWords);
        assertEquals(DiabetesPatientRiskLevel.EARLY_ONSET, patientDiabetesReportTest.getDiabetesPatientRiskLevel());
    }

    @Test
    void womenDiabetesReportWithNoneRiskTest(){
        Patient patient= new Patient("Cersei","Lanister","03/12/1992","Femme","address","phone");
        int age = 29;
        int triggerWords = 3;
        PatientDiabetesReport patientDiabetesReportTest = patientReportService.womenDiabetesReport(patient, age, triggerWords);
        assertEquals(DiabetesPatientRiskLevel.NONE, patientDiabetesReportTest.getDiabetesPatientRiskLevel());
    }

    @Test
    void womenDiabetesReportWithBorderlineRiskTest(){
        Patient patient= new Patient("Cersei","Lanister","03/12/1988","Femme","address","phone");
        int age = 33;
        int triggerWords = 4;
        PatientDiabetesReport patientDiabetesReportTest = patientReportService.womenDiabetesReport(patient, age, triggerWords);
        assertEquals(DiabetesPatientRiskLevel.BORDERLINE, patientDiabetesReportTest.getDiabetesPatientRiskLevel());
    }

    @Test
    void womenDiabetesReportWithInDangerRiskTest(){
        Patient patient= new Patient("Cersei","Lanister","03/12/1988","Femme","address","phone");
        int age = 33;
        int triggerWords = 7;
        PatientDiabetesReport patientDiabetesReportTest = patientReportService.womenDiabetesReport(patient, age, triggerWords);
        assertEquals(DiabetesPatientRiskLevel.IN_DANGER, patientDiabetesReportTest.getDiabetesPatientRiskLevel());
    }

    @Test
    void womenDiabetesReportWithEarlyOnsetRiskTest1(){
        Patient patient= new Patient("Cersei","Lanister","03/12/1992","Femme","address","phone");
        int age = 29;
        int triggerWords = 10;
        PatientDiabetesReport patientDiabetesReportTest = patientReportService.womenDiabetesReport(patient, age, triggerWords);
        assertEquals(DiabetesPatientRiskLevel.EARLY_ONSET, patientDiabetesReportTest.getDiabetesPatientRiskLevel());
    }

    @Test
    void womenDiabetesReportWithEarlyOnsetRiskTest2(){
        Patient patient= new Patient("Cersei","Lanister","03/12/1988","Femme","address","phone");
        int age = 33;
        int triggerWords = 8;
        PatientDiabetesReport patientDiabetesReportTest = patientReportService.womenDiabetesReport(patient, age, triggerWords);
        assertEquals(DiabetesPatientRiskLevel.EARLY_ONSET, patientDiabetesReportTest.getDiabetesPatientRiskLevel());
    }
}
