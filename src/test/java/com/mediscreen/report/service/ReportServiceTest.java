package com.mediscreen.report.service;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mediscreen.report.model.Note;
import com.mediscreen.report.service.webclient.PatientWebClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportServiceTest {
	
	@Autowired
	ReportService reportService;

	@MockBean
	private PatientWebClient patientWebClient;
	

	List<Note> notes;
	
	@BeforeEach
	public void setup() {
		
		notes = new ArrayList<Note>();
		
		notes.add(new Note(BigInteger.valueOf(1),1,LocalDateTime.now(), "none"));
		notes.add(new Note(BigInteger.valueOf(1),1,LocalDateTime.now(), "HEMOBLOBINA1C"));
		notes.add(new Note(BigInteger.valueOf(1),1,LocalDateTime.now(), "MICROALBUMIN"));
		notes.add(new Note(BigInteger.valueOf(1),1,LocalDateTime.now(), "SIZE"));
		notes.add(new Note(BigInteger.valueOf(1),1,LocalDateTime.now(), "WEIGHT"));
		notes.add(new Note(BigInteger.valueOf(1),1,LocalDateTime.now(), "SMOKER"));
		notes.add(new Note(BigInteger.valueOf(1),1,LocalDateTime.now(), "ABNORMAL"));
		notes.add(new Note(BigInteger.valueOf(1),1,LocalDateTime.now(), "VERTIGO"));
		notes.add(new Note(BigInteger.valueOf(1),1,LocalDateTime.now(), "RELAPSE,REACTION"));

	}
	
	@Test
	public void zeroTriggerNote() {
		assertTrue(reportService.numberTriggersInNote(notes.get(0)) == 0);
	}
	
	@Test
	public void oneTriggerNote() {
		assertTrue(reportService.numberTriggersInNote(notes.get(1)) == 1);

	}

	@Test
	public void twoTriggerNote() {
		assertTrue(reportService.numberTriggersInNote(notes.get(8)) == 2);

	}
	
	@Test
	public void allTriggerNote() {
		assertTrue(reportService.numberTriggersOfPatient(notes) == 9);

	}
}
