package com.mediscreen.report.service;

import com.mediscreen.report.model.DemographicData;
import com.mediscreen.report.model.Patient;

public interface DemographicDataService {
	
	public DemographicData getDemographicData(Patient patient);

}
