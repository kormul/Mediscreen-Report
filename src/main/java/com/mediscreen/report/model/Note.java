package com.mediscreen.report.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
	
	private BigInteger id;
	
	private int patientId;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;
    
    private String memo;

}
