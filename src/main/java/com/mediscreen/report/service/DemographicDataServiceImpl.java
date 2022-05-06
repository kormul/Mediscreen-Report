package com.mediscreen.report.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediscreen.report.model.DemographicData;
import com.mediscreen.report.model.Patient;

@Service
public class DemographicDataServiceImpl implements DemographicDataService {

	private Logger logger = LogManager.getLogger();

	@Autowired
	AgeCalculatorService ageCalculatorService;
	
	@Override
	public DemographicData getDemographicData(Patient patient) {
		logger.debug("DemographicDataService : getDemographicDatav");

		
		return new DemographicData(
				patient.getFirstName(), 
				patient.getLastName(),
				ageCalculatorService.calculteAge(patient.getDateOfBirth()),
				patient.isMan(),
				patient.getAddress().getCity());
	}

}
