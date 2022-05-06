package com.mediscreen.report.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediscreen.report.enumeration.RiskLevel;
import com.mediscreen.report.enumeration.Trigger;
import com.mediscreen.report.model.DemographicData;
import com.mediscreen.report.model.Note;
import com.mediscreen.report.model.Patient;
import com.mediscreen.report.model.Report;
import com.mediscreen.report.service.webclient.NoteWebClient;


@Service
public class ReportServiceImpl implements ReportService {

	private Logger logger = LogManager.getLogger();

	@Autowired
	private DemographicDataService demographicDataService;
	
	@Autowired 
	private NoteWebClient noteWebClient;
	
    public List<Trigger> getListTriggerTerms() {
        return new ArrayList<Trigger>(Arrays.asList(Trigger.values()));
    }
    
	@Override
	public int numberTriggersInNote(Note note) {
		logger.debug("ReportService : numberTriggersInNote");

		int numberTriggers = 0;
		String notePatient = note.getMemo();

		notePatient = notePatient.toUpperCase();

		for(Trigger trigger : getListTriggerTerms()) {
			if(notePatient.contains(trigger.toString()))
				numberTriggers++;
		}
		
		return numberTriggers;
	}

	@Override
	public int numberTriggersOfPatient(List<Note> notes) {
		logger.debug("ReportService : numberTriggersOfPatient");

		int numberTriggers = 0;
		for(Note note : notes) {
			numberTriggers += numberTriggersInNote(note);
		}
		
		return numberTriggers;
	}

	@Override
	public Report riskDiabet(Patient patient) {
		logger.debug("ReportService : riskDiabet");

		DemographicData demographicData = demographicDataService.getDemographicData(patient);
		int nbTriggers = numberTriggersOfPatient(noteWebClient.getListNotePatient(patient.getId()));
		Report report = new Report();
		
		report.setRiskLevel(RiskLevel.NONE);

		if(demographicData.getAge()<30) {
			if(demographicData.isMan()) {
				if(nbTriggers>=5) {
					report.setRiskLevel(RiskLevel.EARLYONSET);
				}
				else if(nbTriggers >= 3) {
					report.setRiskLevel(RiskLevel.INDANGER);
				}
			}
			else {
				if(nbTriggers>=7) {
					report.setRiskLevel(RiskLevel.EARLYONSET);
				}
				else if(nbTriggers >= 4) {
					report.setRiskLevel(RiskLevel.INDANGER);
				}
			}
		}
		else {
			if(nbTriggers>=8) {
				report.setRiskLevel(RiskLevel.EARLYONSET);
			}
			else if(nbTriggers >= 6) {
				report.setRiskLevel(RiskLevel.INDANGER);
			}
			else if(nbTriggers >= 2) {
				report.setRiskLevel(RiskLevel.BORDERLINE);
			}
		}
		return report;
	}

}
