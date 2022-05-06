package com.mediscreen.report.service;

import java.util.List;

import com.mediscreen.report.model.Note;
import com.mediscreen.report.model.Patient;
import com.mediscreen.report.model.Report;

public interface ReportService {
	
	public int numberTriggersInNote(Note note);
	
	public int numberTriggersOfPatient(List<Note> notes);
	
	public Report riskDiabet(Patient patient);
	
}
