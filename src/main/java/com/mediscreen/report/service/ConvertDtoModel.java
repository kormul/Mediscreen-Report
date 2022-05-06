package com.mediscreen.report.service;

import com.mediscreen.report.dto.PatientDTO;
import com.mediscreen.report.model.Patient;

public interface ConvertDtoModel {
	
	public Patient patientDtoToPatient(PatientDTO patientDTO);
	
}
