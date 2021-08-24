package com.mediscreen.patientrapport;

import com.mediscreen.patientrapport.controller.PatientReportController;
import com.mediscreen.patientrapport.entity.*;
import com.mediscreen.patientrapport.service.PatientReportService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest(PatientReportController.class)
public class PatientReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PatientReportService patientReportService;

    @DisplayName("GET : /patient-report/{idd}")
    @Test
    void generatePatientDiabetesReportTest() throws Exception {
        //ARRANGE
        int id = 1;
        Patient patient= new Patient("John","Snow","01/01/01","Homme","address","phone");
        PatientNote patientNote = new PatientNote(1, "Note");
        PatientWithNote patientWithNote = new PatientWithNote(patient, patientNote);
        DiabetesPatientRiskLevel result = DiabetesPatientRiskLevel.NONE;
        PatientDiabetesReport patientDiabetesReport = new PatientDiabetesReport("John","Snow","Homme",31,result);
        when(patientReportService.generatePatientDiabetesReport(patientWithNote)).thenReturn(patientDiabetesReport);
        // ACT
        MvcResult mvcResult = mockMvc.perform(post("/patient-report/").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"John\"}")).andDo(print()).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        // ASSERT
        assertEquals(200, response.getStatus());
    }
}
