package com.mediscreen.report.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mediscreen.report.dto.PatientDTO;
import com.mediscreen.report.model.Address;
import com.mediscreen.report.model.Patient;

@Service
public class ConvertDtoModelImpl implements ConvertDtoModel {

	private Logger logger = LogManager.getLogger();

	@Override
	public Patient patientDtoToPatient(PatientDTO patientDTO) {
		logger.debug("ConvertDtoModel : patientDtoToPatient");

		Address address = new Address(patientDTO.getAddress(), patientDTO.getCity(), patientDTO.getZip(), patientDTO.getCountry());
		Patient patient = new Patient(patientDTO.getId(), patientDTO.getFirstName(), patientDTO.getLastName(), patientDTO.getDateOfBirth(), patientDTO.isMan(), address, patientDTO.getPhone());
		
		return patient;
	}

}
