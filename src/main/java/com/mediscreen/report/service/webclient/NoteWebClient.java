package com.mediscreen.report.service.webclient;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mediscreen.report.model.Note;

@Service
public class NoteWebClient {
	
	public String dockerURLLocation = "http://localhost:8081";
	
	private Logger logger = LogManager.getLogger();
	
	public List<Note> getListNotePatient(int id){
		logger.debug("NoteWebClient : getListNotePatient");

		List<Note> notes;

		RestTemplate restTemplate = new RestTemplate();
		
        ResponseEntity<List<Note>> result = restTemplate.exchange(dockerURLLocation+"/rest/note/list?id="+id,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Note>>(){});
        
        notes = result.getBody();
        
		return notes;
	}

}
