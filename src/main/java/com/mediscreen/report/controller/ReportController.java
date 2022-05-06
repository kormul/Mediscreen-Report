package com.mediscreen.report.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mediscreen.report.dto.PatientDTO;
import com.mediscreen.report.model.Patient;
import com.mediscreen.report.service.ConvertDtoModel;
import com.mediscreen.report.service.DemographicDataService;
import com.mediscreen.report.service.ReportService;
import com.mediscreen.report.service.webclient.PatientWebClient;

@Controller
public class ReportController {
	
	private Logger logger = LogManager.getLogger();
	
	@Autowired
	PatientWebClient patientWebClient;
	
	@Autowired
	ConvertDtoModel convertDtoModel;
	
	@Autowired
	ReportService reportService;
	
	@Autowired
	DemographicDataService demographicDataService;
	
	@GetMapping("/report/patient")
	public String getReportPatient(@RequestParam(value = "id", required = true) int id, Model model) {
		logger.info("Get : report Patient");
		
		PatientDTO patientDto = patientWebClient.getPatient(id);
		
		if(patientDto != null) {
		
			Patient patient = convertDtoModel.patientDtoToPatient(patientDto);
			model.addAttribute("demographics", demographicDataService.getDemographicData(patient));
			model.addAttribute("report", reportService.riskDiabet(patient));
		
		}
		return "Report";
	}

}
